package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class ShopPanelController implements MouseListener{
    JLabel upgradesLabel;
    private ArrayList<JLabel> itemLabel;
    private JLabel quantityLabel;
    private ArrayList<JSpinner> quantitySpinner;
    private ArrayList<JButton> buyButton;
    private ArrayList<JLabel> costLabel;

    public ShopPanelController(JLabel upgradesLabel,ArrayList<JLabel> itemLabel, JLabel quantityLabel, ArrayList<JSpinner> quantitySpinner, ArrayList<JButton> buyButton,ArrayList<JLabel> costLabel) {
        this.upgradesLabel=upgradesLabel;
        this.itemLabel=itemLabel;
        this.quantityLabel=quantityLabel;
        this.quantitySpinner=quantitySpinner;
        this.buyButton=buyButton;
        this.costLabel=costLabel;



        ////////////////////////////////
        ///CREATING ALL THE COMPONENTS
        this.upgradesLabel=new JLabel("Upgrades");

        this.itemLabel.add(new JLabel("LeftCooker Storage"));
        this.itemLabel.add(new JLabel("CentralCooker Storage"));
        this.itemLabel.add(new JLabel("RightCooker Storage"));
        this.itemLabel.add(new JLabel("Tray Storage"));
        this.itemLabel.add(new JLabel("Fridge Storage"));
        this.itemLabel.add(new JLabel("Van Storage"));
        this.itemLabel.add(new JLabel("Cooking speed"));
        this.itemLabel.add(new JLabel("Cooling speed"));

        this.quantityLabel=new JLabel("MIAO :3");


        this.quantitySpinner.add(new JSpinner(new SpinnerNumberModel(0,0,null,1)));
        this.quantitySpinner.add(new JSpinner(new SpinnerNumberModel()));
        this.quantitySpinner.add(new JSpinner(new SpinnerNumberModel()));
        this.quantitySpinner.add(new JSpinner(new SpinnerNumberModel()));
        this.quantitySpinner.add(new JSpinner(new SpinnerNumberModel()));
        this.quantitySpinner.add(new JSpinner(new SpinnerNumberModel()));
        this.quantitySpinner.add(new JSpinner(new SpinnerNumberModel()));
        this.quantitySpinner.add(new JSpinner(new SpinnerNumberModel()));

        this.buyButton.add(new JButton());
        this.buyButton.add(new JButton());
        this.buyButton.add(new JButton());
        this.buyButton.add(new JButton());
        this.buyButton.add(new JButton());
        this.buyButton.add(new JButton());
        this.buyButton.add(new JButton());
        this.buyButton.add(new JButton());

        this.costLabel.add(new JLabel());
        this.costLabel.add(new JLabel());
        this.costLabel.add(new JLabel());
        this.costLabel.add(new JLabel());
        this.costLabel.add(new JLabel());
        this.costLabel.add(new JLabel());
        this.costLabel.add(new JLabel());
        this.costLabel.add(new JLabel());
        ///////////////////////////////////////////////////


        GameFrameController.gf.getShopPanel().add(this.upgradesLabel);
        this.itemLabel.forEach((g)-> GameFrameController.gf.getShopPanel().add(g));
        GameFrameController.gf.getShopPanel().add(this.quantityLabel);
        this.quantitySpinner.forEach((g)-> GameFrameController.gf.getShopPanel().add(g));
        this.buyButton.forEach((g)-> GameFrameController.gf.getShopPanel().add(g));
        this.costLabel.forEach((g)-> GameFrameController.gf.getShopPanel().add(g));

        adjustPosAndSize();
    }
    public void adjustPosAndSize(){
        double imageResizeRatio=GameFrameController.media.getImageResizeRatio();



        itemLabel.forEach((g)-> g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)imageResizeRatio*7)));
        itemLabel.forEach((g)-> g.setForeground(Color.white));
        itemLabel.forEach((g)-> g.setSize((int)imageResizeRatio*78,(int)imageResizeRatio*9));
        int yMultiplier=3;
        for(int n=0; n<itemLabel.size();n++,yMultiplier+=9){
            itemLabel.get(n).setLocation((int)imageResizeRatio*7,(int)imageResizeRatio*(47+yMultiplier++));
        }
        itemLabel.forEach((g)-> g.setBorder(BorderFactory.createLineBorder(Color.white,2)));


        quantityLabel.setText("Miao :3");
        quantityLabel.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,(int)imageResizeRatio*5));
        quantityLabel.setForeground(Color.GREEN);
        quantityLabel.setBounds((int)imageResizeRatio*10,(int)imageResizeRatio*10,(int)imageResizeRatio*20,(int)imageResizeRatio*10);
        quantityLabel.setBorder(BorderFactory.createLineBorder(Color.white,2));

        quantitySpinner.forEach((g)-> g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)imageResizeRatio*5)));
        quantitySpinner.forEach((g)-> g.setSize((int)imageResizeRatio*15,(int)imageResizeRatio*5));
        yMultiplier=3;
        for(int n=0; n<quantitySpinner.size();n++,yMultiplier+=9){
            quantitySpinner.get(n).setLocation((int)imageResizeRatio*90,(int)imageResizeRatio*(49+yMultiplier++));
        }
        quantitySpinner.forEach((g)-> g.setBorder(BorderFactory.createLineBorder(Color.white,2)));


        buyButton.forEach((g)-> g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)imageResizeRatio*4)));
        buyButton.forEach((g)-> g.setSize((int)imageResizeRatio*16,(int)imageResizeRatio*8));
        yMultiplier=3;
        for(int n=0; n<buyButton.size();n++,yMultiplier+=9){
            buyButton.get(n).setLocation((int)imageResizeRatio*115,(int)imageResizeRatio*(47+yMultiplier++));
        }
        buyButton.forEach((g)-> g.setText("BUY"));
        buyButton.forEach((g)-> g.setForeground(Color.white));
        buyButton.forEach((g)-> g.setBackground(Color.green));

        GameFrameController.gf.getShopPanel().setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

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
