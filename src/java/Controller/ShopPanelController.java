package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class ShopPanelController implements MouseListener{
    private JLabel upgradesLabel;
    private ArrayList<JLabel> itemLabel;
    private JLabel quantityLabel;
    private ArrayList<JSpinner> quantitySpinner;
    private ArrayList<JButton> buyButton;

    public ShopPanelController(JLabel upgradesLabel,ArrayList<JLabel> itemLabel, JLabel quantityLabel, ArrayList<JSpinner> quantitySpinner, ArrayList<JButton> buyButton) {
        this.upgradesLabel=upgradesLabel;
        this.itemLabel=itemLabel;
        this.quantityLabel=quantityLabel;
        this.quantitySpinner=quantitySpinner;
        this.buyButton=buyButton;

        ////////////////////////////////
        ///CREATING ALL THE COMPONENTS
        itemLabel.add(new JLabel("LeftCooker Storage"));
        itemLabel.add(new JLabel("CentralCooker Storage"));
        itemLabel.add(new JLabel("RightCooker Storage"));
        itemLabel.add(new JLabel("Tray Storage"));
        itemLabel.add(new JLabel("Fridge Storage"));
        itemLabel.add(new JLabel("Van Storage"));
        itemLabel.add(new JLabel("Cooking speed"));
        itemLabel.add(new JLabel("Cooling speed"));

        quantityLabel=new JLabel("Quantity");


        quantitySpinner.add(new JSpinner(new SpinnerNumberModel()));
        quantitySpinner.add(new JSpinner(new SpinnerNumberModel()));
        quantitySpinner.add(new JSpinner(new SpinnerNumberModel()));
        quantitySpinner.add(new JSpinner(new SpinnerNumberModel()));
        quantitySpinner.add(new JSpinner(new SpinnerNumberModel()));
        quantitySpinner.add(new JSpinner(new SpinnerNumberModel()));
        quantitySpinner.add(new JSpinner(new SpinnerNumberModel()));
        quantitySpinner.add(new JSpinner(new SpinnerNumberModel()));

        buyButton.add(new JButton());
        buyButton.add(new JButton());
        buyButton.add(new JButton());
        buyButton.add(new JButton());
        buyButton.add(new JButton());
        buyButton.add(new JButton());
        buyButton.add(new JButton());
        buyButton.add(new JButton());
        ///////////////////////////////////////////////////


        itemLabel.forEach((g)-> GameFrameController.gf.getShopPanel().add(g));
        GameFrameController.gf.getShopPanel().add(quantityLabel);
        quantitySpinner.forEach((g)-> GameFrameController.gf.getShopPanel().add(g));
        buyButton.forEach((g)-> GameFrameController.gf.getShopPanel().add(g));

        adjustPosAndSize();
    }
    public void adjustPosAndSize(){
        double imageResizeRatio=GameFrameController.media.getImageResizeRatio();

        itemLabel.forEach((g)-> g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)imageResizeRatio*7)));
        itemLabel.forEach((g)-> g.setForeground(Color.white));
        itemLabel.forEach((g)-> g.setSize((int)imageResizeRatio*78,(int)imageResizeRatio*9));
        int yMultiplier=3;
        for(int n=0; n<itemLabel.size();n++,yMultiplier+=7){
            itemLabel.get(n).setLocation((int)imageResizeRatio*7,(int)imageResizeRatio*(40+yMultiplier++));
        }
        itemLabel.forEach((g)-> g.setBorder(BorderFactory.createLineBorder(Color.white,2)));


        GameFrameController.gf.getShopPanel().remove(quantityLabel);
        quantityLabel.setText("Quantity");
        quantityLabel.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,(int)imageResizeRatio*5));
        quantityLabel.setForeground(Color.white);
        quantityLabel.setSize((int)imageResizeRatio*21,(int)imageResizeRatio*9);
        quantityLabel.setLocation((int)imageResizeRatio*89,(int)imageResizeRatio*34);
        quantityLabel.setBorder(BorderFactory.createLineBorder(Color.white,2));
        GameFrameController.gf.getShopPanel().add(quantityLabel);


        quantitySpinner.forEach((g)-> g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)imageResizeRatio*5)));
        quantitySpinner.forEach((g)-> g.setSize((int)imageResizeRatio*15,(int)imageResizeRatio*5));
        yMultiplier=3;
        for(int n=0; n<quantitySpinner.size();n++,yMultiplier+=7){
            quantitySpinner.get(n).setLocation((int)imageResizeRatio*90,(int)imageResizeRatio*(42+yMultiplier++));
        }
        quantitySpinner.forEach((g)-> g.setBorder(BorderFactory.createLineBorder(Color.white,2)));
        quantitySpinner.forEach((g)-> g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)imageResizeRatio*5)));
        quantitySpinner.forEach((g)-> g.setSize((int)imageResizeRatio*15,(int)imageResizeRatio*5));
        yMultiplier=3;
        for(int n=0; n<quantitySpinner.size();n++,yMultiplier+=7){
            quantitySpinner.get(n).setLocation((int)imageResizeRatio*90,(int)imageResizeRatio*(42+yMultiplier++));
        }
        quantitySpinner.forEach((g)-> g.setBorder(BorderFactory.createLineBorder(Color.white,2)));



        buyButton.forEach((g)-> g.setBounds(100,100,100,100));

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
