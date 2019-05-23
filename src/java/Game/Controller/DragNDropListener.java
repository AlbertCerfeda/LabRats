package Game.Controller;

import Game.Model.Sprite;
import Game.Model.SpriteContainer;
import Game.View.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DragNDropListener implements MouseListener, ActionListener {

    private JLabel sourceLabel;
    private Sprite sourceLabelSprite;

    private JLabel destinationLabel;
    private Sprite destinationLabelSprite;


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() instanceof JButton){
            if(((JButton)e.getSource()).getText()==GameFrameController.getShopButton().getText()){
                GameFrame.setShopVisible();
            }
        }
    }

    private void attemptTransfer(){
        SpriteContainer sourceContainerSprite=(SpriteContainer) sourceLabelSprite;
        SpriteContainer destinationContainerSprite=(SpriteContainer) destinationLabelSprite;
        boolean transferPossible=false;

        if((sourceContainerSprite.getName().contains("Tank")&&destinationLabelSprite.getName().contains("Cooker"))){//If an ingredient is dragged over a Cooker

            //TODO: WHY DOESN'T THIS WORK
            String sourceTank; String destinationCooker;
            sourceTank=sourceContainerSprite.getName();//Extracts the name of the ingredient out of the sprite name (ex. muTank -> mu)
            sourceTank.replace("Tank","");
            destinationCooker=destinationContainerSprite.getName();//Extracts the name of the ingredient out of the sprite name (ex. muCooker -> mu)
            destinationCooker.replace("Cooker","");
            //////////////////////////////////////////////
            //Spaghetti code to make it work
            if(sourceTank.contains("mu")&&destinationCooker.contains("mu")){
                sourceTank="mu";
                destinationCooker="mu";
            }
            else if(sourceTank.contains("cs")&&destinationCooker.contains("cs")){
                sourceTank="cs";
                destinationCooker="cs";
            }
            else if(sourceTank.contains("hcl")&&destinationCooker.contains("hcl")){
                sourceTank="hcl";
                destinationCooker="hcl";
            }
            //////////////////
            if(sourceTank.compareTo(destinationCooker)==0&&CookerManagerThread.isCorrectIngredient(sourceTank)){//If the ingredient and the cooker are for the same element and it's the correct one, the transfer can be done
                transferPossible=true;

            }
            else{//If a mistake has been made, the police gets alerted and the countdown starts
                transferPossible=false;
                GameFrameController.makeLabExplode();
            }
        }
        else if((sourceContainerSprite.getName().contains("tray")&&destinationLabelSprite.getName().contains("fridge"))||//If you dragged the tray over the fridge
                (sourceContainerSprite.getName().contains("fridge")&&destinationLabelSprite.getName().contains("van"))){//If you dragged the fridge over the van
            transferPossible=true;
        }
        if(transferPossible){//Makes the transfer
            int max;
            if(sourceContainerSprite.getName().contains("fridge")){
                max=(int)((SpriteContainer)sourceLabelSprite).getStored2();
            }
            else{
                max=(int)sourceContainerSprite.getStored();
            }

            int defValue=0;
            if(sourceLabelSprite.getName().equals("tray")||sourceLabelSprite.getName().equals("fridge")){
                defValue=-1;
            }

            /////////////////////
            //Creates the spinner in the OptionPane to ask what quantity to transfer
            SpinnerNumberModel sModel = new SpinnerNumberModel(defValue, -1, max, 1);
            JSpinner spinner = new JSpinner(sModel);
            int option;
            if((sourceContainerSprite.getName().contains("fridge")&&sourceContainerSprite.getStored2()==0)){
                option=JOptionPane.CANCEL_OPTION;
            }
            else if(destinationContainerSprite.getStored()==destinationContainerSprite.getCapacity()||sourceContainerSprite.getStored()==0){
                option=JOptionPane.CANCEL_OPTION;
            }
            else{
                option = JOptionPane.showOptionDialog(null, spinner, "How much?  ( -1 -> everything)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            }
            ////////////////////////////////////////////

            if (option == JOptionPane.CANCEL_OPTION||option==JOptionPane.CLOSED_OPTION|| (int)sModel.getValue()==0){//if user click Cancel or closes the window
            } else if (option == JOptionPane.OK_OPTION){//If user gives ok

                if(sourceContainerSprite.getName().contains("Tank")){
                    String ingredient="";
                    if(sourceContainerSprite.getName().contains("mu")){
                        ingredient="mu";
                    }
                    else if(sourceContainerSprite.getName().contains("cs")){
                        ingredient="cs";
                    }
                    else if(sourceContainerSprite.getName().contains("hcl")){
                        ingredient="hcl";
                    }
                    CookerManagerThread.addIngredient(ingredient);
                }

                long quantity=(int)sModel.getValue();
                if(quantity==-1){
                    if(sourceLabelSprite.getName().equals("fridge")){
                        quantity=(int)((SpriteContainer)sourceLabelSprite).getStored2();
                    }
                    else{
                        quantity=sourceContainerSprite.getStored();
                    }

                }
                if(sourceLabelSprite.getName().equals("fridge")){
                    sourceContainerSprite.removeStored(quantity);
                    sourceContainerSprite.removeStored2(quantity);
                    int difference=(int)destinationContainerSprite.addStored(quantity); //The difference in excess when storing gets added back to the source//////
                    sourceContainerSprite.addStored(difference);
                    sourceContainerSprite.addStored2(difference);
                }
                else{
                    sourceContainerSprite.removeStored(quantity);
                    sourceContainerSprite.addStored(destinationContainerSprite.addStored(quantity)); //The difference in excess when storing gets added back to the source//////
                }

            }
        }
    }
    private MouseMotionHandler mousemotionhandler;

    public JLabel getSourceLabel() {return sourceLabel; }
    public Sprite getSourceLabelSprite() {return sourceLabelSprite; }

    public DragNDropListener() {
        mousemotionhandler=new MouseMotionHandler(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(((Sprite)((JLabel)e.getSource()).getIcon()).getName().equals("postit")){
            Toolkit tk=Toolkit.getDefaultToolkit();

            JFrame instructionFrame = new JFrame("how to cook some good meth step-by-step");
            instructionFrame.setResizable(false);
            instructionFrame.setMinimumSize(new Dimension((int)(tk.getScreenSize().getWidth()/2),(int)(tk.getScreenSize().getWidth()/2)));

            JPanel panel= new JPanel();
            panel.setMinimumSize(new Dimension((int)(tk.getScreenSize().getWidth()/2),(int)(tk.getScreenSize().getWidth()/2)));
            JLabel background= new JLabel("");
            panel.add(background);
            background.setIcon(new ImageIcon(tk.getImage(getClass().getResource("/instructions.png")).getScaledInstance((int)(tk.getScreenSize().getWidth()/2),(int)(tk.getScreenSize().getWidth()/2),Image.SCALE_DEFAULT)));
            background.setBounds(0,0,(int)(tk.getScreenSize().getWidth()/2),(int)(tk.getScreenSize().getWidth()/2));
            instructionFrame.add(panel);
            panel.setBounds(0,0,(int)(tk.getScreenSize().getWidth()/2),(int)(tk.getScreenSize().getWidth()/2));
            instructionFrame.setVisible(true);

            instructionFrame.repaint();
        }
        else if(((Sprite)((JLabel)e.getSource()).getIcon()).getName().equals("van")){
            GameFrameController.getVanThread().registerClick();

        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        Sprite pressedSprite=((Sprite)((JLabel)e.getSource()).getIcon());
        if(pressedSprite instanceof SpriteContainer){
            sourceLabel=(JLabel)e.getSource();
            sourceLabelSprite=pressedSprite;
        }
        else{
            sourceLabel=null;
            sourceLabelSprite=null;
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (sourceLabel!=null){
            sourceLabelSprite.resetPosition();
        }
        if(sourceLabel!=null&&destinationLabel!=null){
            attemptTransfer();
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        Sprite enteredSprite=((Sprite)((JLabel)e.getSource()).getIcon());
        if(enteredSprite instanceof SpriteContainer){

            destinationLabel=(JLabel)e.getSource();
            destinationLabelSprite=(Sprite)(destinationLabel.getIcon());

            enteredSprite.setHighlightMode(true);
        }
        else if(enteredSprite.getName().equals("postit")){
            enteredSprite.setHighlightMode(true);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        destinationLabel=null;
        destinationLabelSprite=null;

        Sprite exitedSprite=(Sprite)((JLabel)e.getSource()).getIcon();
        exitedSprite.setHighlightMode(false);
    }

    public JLabel getDestinationLabel() {
        return destinationLabel;
    }
    public Sprite getDestinationLabelSprite() {
        return destinationLabelSprite;
    }
    public MouseMotionHandler getMousemotionhandler() {
        return mousemotionhandler;
    }
}
class MouseMotionHandler implements MouseMotionListener{
    DragNDropListener dragndroplistener;

    public MouseMotionHandler(DragNDropListener dragndroplistener) {
        this.dragndroplistener=dragndroplistener;

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (dragndroplistener.getSourceLabelSprite()!=null&&(dragndroplistener.getSourceLabelSprite().getName().contains("Tank")||dragndroplistener.getSourceLabelSprite().getName().equals("tray"))){
            Point mousePos=GameFrameController.gf.getGamePanel().getMousePosition();
            dragndroplistener.getSourceLabelSprite().setXY(mousePos.x+5,mousePos.y+5);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}