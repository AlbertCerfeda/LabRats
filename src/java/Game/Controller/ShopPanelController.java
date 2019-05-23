package Game.Controller;

import Game.Model.SpriteContainer;
import Game.View.GameFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class ShopPanelController implements MouseListener{
    JLabel upgradesLabel;
    private ArrayList<JLabel> itemLabel;
    private ArrayList<JSpinner> quantitySpinner;
    private ArrayList<JButton> buyButton;
    private ArrayList<JLabel> costLabel;
    private static JLabel moneyLabel;
    private ChangeListener changeListener;
    private int prices[]=new int [13];
    private int nUpdates=13;
    private JButton switchToGame;

    private static int initialPrice[]=new int [13];
    private static double priceIncrease[]=new double[13];

    public ShopPanelController() {
        upgradesLabel=new JLabel("UPGRADES");

        itemLabel=new ArrayList<>();
        quantitySpinner=new ArrayList<>();
        buyButton=new ArrayList<>();
        costLabel=new ArrayList<>();
        prices=new int[13];
        switchToGame=new JButton("CLOSE SHOP");

        //TODO: INSERIRE I PREZZI INIZIALI DI OGNI UPGRADE
        initialPrice[0]=3;
        initialPrice[1]=3;
        initialPrice[2]=3;
        initialPrice[3]=3;
        initialPrice[4]=3;
        initialPrice[5]=3;
        initialPrice[6]=10;
        initialPrice[7]=200;
        initialPrice[8]=10;
        initialPrice[9]=200;
        initialPrice[10]=2;
        initialPrice[11]=2;
        initialPrice[12]=2;

        //TODO: INSERIRE IL COEFFICIENTE DELL'AUMENTO DEL PREZZO DEGLI UPGRADE
        priceIncrease[0]=1.3;
        priceIncrease[1]=1.3;
        priceIncrease[2]=1.3;
        priceIncrease[3]=1.3;
        priceIncrease[4]=1.3;
        priceIncrease[5]=1.3;
        priceIncrease[6]=1.6;
        priceIncrease[7]=3;
        priceIncrease[8]=1.6;
        priceIncrease[9]=3;
        priceIncrease[10]=1.6;
        priceIncrease[11]=1;
        priceIncrease[12]=1;
        ////////////////////////////////
        ///CREATING ALL THE COMPONENTS

        this.itemLabel.add(new JLabel("Mu Cooker Storage"));
        this.itemLabel.add(new JLabel("Cs Cooker Storage"));
        this.itemLabel.add(new JLabel("Hcl Cooker Storage"));
        this.itemLabel.add(new JLabel("Tray Storage"));
        this.itemLabel.add(new JLabel("Fridge Storage"));
        this.itemLabel.add(new JLabel("Van Storage"));
        this.itemLabel.add(new JLabel("Cooking speed (-0.1%)"));
        this.itemLabel.add(new JLabel("Cooking efficiency"));
        this.itemLabel.add(new JLabel("Cooling speed (-0.1%)"));
        this.itemLabel.add(new JLabel("Cooling efficiency"));
        this.itemLabel.add(new JLabel("MU"));
        this.itemLabel.add(new JLabel("CS"));
        this.itemLabel.add(new JLabel("HCL"));

        for(int i=0; i<nUpdates; i++)
            this.quantitySpinner.add(new JSpinner(new SpinnerNumberModel(1,1,null,1)));

        for(int i=0; i<nUpdates;i++)
            this.buyButton.add(new JButton());

        for(int i=0; i<nUpdates; i++)
            this.costLabel.add(new JLabel());

        prices=initialPrice;
        ///////////////////////////////////////////////////


        GameFrameController.gf.getShopPanel().add(this.upgradesLabel);
        this.itemLabel.forEach((g)-> GameFrameController.gf.getShopPanel().add(g));
        this.quantitySpinner.forEach((g)-> GameFrameController.gf.getShopPanel().add(g));
        this.buyButton.forEach((g)-> GameFrameController.gf.getShopPanel().add(g));
        this.costLabel.forEach((g)-> GameFrameController.gf.getShopPanel().add(g));

        moneyLabel=new JLabel(GameFrameController.getMoney()+"$");
        GameFrameController.gf.getShopPanel().add(moneyLabel);
        moneyLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)GameFrameController.media.getImageResizeRatio()*8));
        moneyLabel.setForeground(Color.green);

        GameFrameController.gf.getShopPanel().add(switchToGame);

        adjustPosAndSize();

        costLabel.forEach((g)-> g.setText(initialPrice+"$"));
        changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if(e.getSource().getClass().equals(JSpinner.class)) {
                    checkBuyable(quantitySpinner.indexOf((JSpinner)e.getSource()));
                }
            }
        };

        this.quantitySpinner.forEach((g)->g.addChangeListener(changeListener));
        this.buyButton.forEach((g)->g.addMouseListener(this));
        this.switchToGame.addMouseListener(this);

        for(int i=0; i<quantitySpinner.size(); i++)
        {
            checkBuyable(i);
        }
    }

    public void checkBuyable(int index)
    {
        int totalPrice=prices[index];
        int x=prices[index];
        if(index!=10&&index!=11&&index!=12){
            for(int i=1; i<(Integer) quantitySpinner.get(index).getValue(); i++)
            {
                totalPrice+=totalPrice*priceIncrease[index];
            }
        }
        else{
            totalPrice=(Integer) quantitySpinner.get(index).getValue();
        }
        costLabel.get(index).setText(String.valueOf(totalPrice));

        if (GameFrameController.getMoney()>=totalPrice){
            buyButton.get(index).setEnabled(true);
            buyButton.get(index).setForeground(Color.green);
            costLabel.get(index).setForeground(Color.white);
        }
        else{
            buyButton.get(index).setEnabled(false);
            buyButton.get(index).setForeground(Color.red);
            buyButton.get(index).setBackground(Color.GRAY);
            costLabel.get(index).setForeground(Color.red);
        }
    }

    public void adjustPosAndSize(){
        double imageResizeRatio=GameFrameController.media.getImageResizeRatio();
        int shiftPosition=140;


        itemLabel.forEach((g)-> g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)imageResizeRatio*7)));
        itemLabel.forEach((g)-> g.setForeground(Color.white));

        itemLabel.forEach((g)-> g.setSize((int)imageResizeRatio*78,(int)imageResizeRatio*9));
        int yMultiplier=3;
        for(int n=0; n<itemLabel.size();n++,yMultiplier+=9){
            if(n==8)
                yMultiplier=3;

            if(n<8)
                itemLabel.get(n).setLocation((int)imageResizeRatio*7,(int)imageResizeRatio*(35+yMultiplier++));
            else
                itemLabel.get(n).setLocation((int)imageResizeRatio*(7+shiftPosition),(int)imageResizeRatio*(35+yMultiplier++));
        }
        for(int i=nUpdates-3; i<nUpdates; i++)
        {
            itemLabel.get(i).setForeground(Color.ORANGE);
        }

        quantitySpinner.forEach((g)-> g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)imageResizeRatio*5)));
        quantitySpinner.forEach((g)-> g.setSize((int)imageResizeRatio*15,(int)imageResizeRatio*5));
        yMultiplier=3;
        for(int n=0; n<quantitySpinner.size();n++,yMultiplier+=9){
            if(n==8)
                yMultiplier=3;

            if(n<8)
                quantitySpinner.get(n).setLocation((int)imageResizeRatio*90,(int)imageResizeRatio*(37+yMultiplier++));
            else
                quantitySpinner.get(n).setLocation((int)imageResizeRatio*(90+shiftPosition),(int)imageResizeRatio*(37+yMultiplier++));
        }


        buyButton.forEach((g)-> g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)imageResizeRatio*4)));
        buyButton.forEach((g)-> g.setSize((int)imageResizeRatio*16,(int)imageResizeRatio*8));
        yMultiplier=3;
        for(int n=0; n<buyButton.size();n++,yMultiplier+=9){
            if(n==8)
                yMultiplier=3;

            if(n<8)
                buyButton.get(n).setLocation((int)imageResizeRatio*115,(int)imageResizeRatio*(35+yMultiplier++));
            else
                buyButton.get(n).setLocation((int)imageResizeRatio*(115+shiftPosition),(int)imageResizeRatio*(35+yMultiplier++));
        }
        buyButton.forEach((g)-> g.setText("BUY"));
        buyButton.forEach((g)-> g.setForeground(Color.white));
        buyButton.forEach((g)-> g.setBackground(Color.green));


        costLabel.forEach((g)-> g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)imageResizeRatio*4)));
        costLabel.forEach((g)-> g.setSize((int)imageResizeRatio*25,(int)imageResizeRatio*8));
        yMultiplier=3;
        for(int n=0; n<costLabel.size();n++,yMultiplier+=9){
            if(n==8)
                yMultiplier=3;

            if(n<8)
                costLabel.get(n).setLocation((int)imageResizeRatio*135,(int)imageResizeRatio*(35+yMultiplier++));
            else
                costLabel.get(n).setLocation((int)imageResizeRatio*(135+shiftPosition),(int)imageResizeRatio*(35+yMultiplier++));
        }
        costLabel.forEach((g)-> g.setForeground(Color.white));
        costLabel.forEach((g)-> g.setBackground(Color.green));

        moneyLabel.setBounds((int)imageResizeRatio*147,(int)imageResizeRatio*90,(int)imageResizeRatio*135,(int)imageResizeRatio*10);

        switchToGame.setBounds((int)imageResizeRatio*147,(int)imageResizeRatio*100,(int)imageResizeRatio*50,(int)imageResizeRatio*10);
        switchToGame.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)imageResizeRatio*4));
        switchToGame.setForeground(Color.BLACK);

        GameFrameController.gf.getShopPanel().setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource().equals(switchToGame)){
            GameFrame.setGameVisible();
        }
        else if(e.getSource().getClass().equals(JButton.class)) {
            int index=buyButton.indexOf(e.getSource());

            if (buyButton.get(index).isEnabled()){
                checkBuyable(index);
                GameFrameController.setMoney((GameFrameController.getMoney()) - (Integer.parseInt(costLabel.get(index).getText())));
                this.moneyLabel.setText(GameFrameController.getMoney() + "$");
                prices[index] =(int)(Integer.parseInt(costLabel.get(index).getText()) * priceIncrease[index]);

                for (int i = 0; i < quantitySpinner.size(); i++) {
                    checkBuyable(i);
                }

                //TODO: INSERIRE COSA DEVE FARE IL PROGRAMMA AL MOMENTO DELL'ACQUISTO
                switch(index){
                    case 0://Mu cooker storage
                        GameFrameController.getCookermanagerthread().mu.addCapacity((int)quantitySpinner.get(index).getValue());
                        break;
                    case 1://Cs Cooker storage
                        GameFrameController.getCookermanagerthread().cs.addCapacity((int)quantitySpinner.get(index).getValue());
                        break;
                    case 2://Hcl cooker storage
                        GameFrameController.getCookermanagerthread().hcl.addCapacity((int)quantitySpinner.get(index).getValue());
                        break;
                    case 3://Tray Storage
                        GameFrameController.getCookermanagerthread().tray.addCapacity((int)quantitySpinner.get(index).getValue());
                        break;
                    case 4://Fridge Storage
                        GameFrameController.getCookermanagerthread().fridge.addCapacity((int)quantitySpinner.get(index).getValue());
                        break;
                    case 5://Van Storage
                        GameFrameController.getCookermanagerthread().van.addCapacity((int)quantitySpinner.get(index).getValue());
                        break;
                    case 6://Cooking speed
                        for(int n=1;n<(int)quantitySpinner.get(index).getValue();n++){
                            GameFrameController.setMillisForCookCycle((long)(GameFrameController.getMillisForCookCycle()*0.9));
                        }
                        break;
                    case 7://Cooking efficiency
                        GameFrameController.setUnitsCookedForCookCycle(GameFrameController.getUnitsCookedForCookCycle()+(int)quantitySpinner.get(index).getValue());
                        break;
                    case 8://Cooling speed
                        for(int n=1;n<(int)quantitySpinner.get(index).getValue();n++){
                            GameFrameController.setMillisForCoolingCycle((long)(GameFrameController.getMillisForCoolingCycle()*0.9));
                        }
                        break;
                    case 9://Cooling efficiency
                        GameFrameController.setUnitsCooledForCoolingCycle(GameFrameController.getUnitsCooledForCoolingCycle()+(int)quantitySpinner.get(index).getValue());
                        break;
                    case 10://MU
                        int n;
                        for(n=0;n<= GameFrameController.getAnimatedContainers().size();n++){
                            if(((SpriteContainer)GameFrameController.getAnimatedContainers().get(n).getIcon()).getName()=="muTank"){
                                break;
                            }
                        }
                        ((SpriteContainer)GameFrameController.getAnimatedContainers().get(n).getIcon()).addStored((int)quantitySpinner.get(index).getValue());
                        break;
                    case 11://CS
                        for(n=0;n<= GameFrameController.getAnimatedContainers().size();n++){
                            if(((SpriteContainer)GameFrameController.getAnimatedContainers().get(n).getIcon()).getName()=="csTank"){
                                break;
                            }
                        }
                        ((SpriteContainer)GameFrameController.getAnimatedContainers().get(n).getIcon()).addStored((int)quantitySpinner.get(index).getValue());

                        break;
                    case 12://HCL
                        for(n=0;n<= GameFrameController.getAnimatedContainers().size();n++){
                            if(((SpriteContainer)GameFrameController.getAnimatedContainers().get(n).getIcon()).getName()=="hclTank"){
                                break;
                            }
                        }
                        ((SpriteContainer)GameFrameController.getAnimatedContainers().get(n).getIcon()).addStored((int)quantitySpinner.get(index).getValue());

                        break;
                }

                quantitySpinner.get(index).setValue(1);
            }
        }
    }

    public static JLabel getMoneyLabel() {
        return moneyLabel;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}