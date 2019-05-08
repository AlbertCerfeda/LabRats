package Controller;

import Model.Sprite;
import Model.SpriteContainer;
import View.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DragNDropListener implements MouseListener {

    private JLabel sourceLabel;
    private Sprite sourceLabelSprite;

    private JLabel destinationLabel;
    private Sprite destinationLabelSprite;

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
                System.out.println();
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
                //TODO: Signal that the countdown for police has to start
                System.out.println("Wrong ingredient in wrong tank. Explosion!! The poo-poo is coming");
            }
        }
        else if((sourceContainerSprite.getName().contains("tray")&&destinationLabelSprite.getName().contains("fridge"))||//If you dragged the tray over the fridge
                (sourceContainerSprite.getName().contains("fridge")&&destinationLabelSprite.getName().contains("van"))){//If you dragged the fridge over the van
            transferPossible=true;
        }
        if(transferPossible){//Makes the transfer
            int max=(int)sourceContainerSprite.getStored();
            System.out.println("|||"+(int)sourceContainerSprite.getStored()+"|||");
            int defValue=0;
            if(sourceLabelSprite.getName().equals("tray")||sourceLabelSprite.getName().equals("fridge")){
                defValue=-1;
            }

            /////////////////////
            //Creates the spinner in the OptionPane to ask what quantity to transfer
            SpinnerNumberModel sModel = new SpinnerNumberModel(defValue, -1, max, 1);
            JSpinner spinner = new JSpinner(sModel);
            int option;
            if(destinationContainerSprite.getStored()==destinationContainerSprite.getCapacity()||sourceContainerSprite.getStored()==0){
                option=JOptionPane.CANCEL_OPTION;
            }
            else{
                option = JOptionPane.showOptionDialog(null, spinner, "How much?  ( -1 -> everything)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            }
            ////////////////////////////////////////////

            if (option == JOptionPane.CANCEL_OPTION||option==JOptionPane.CLOSED_OPTION|| (int)sModel.getValue()==0){//if user click Cancel or closes the window
                System.out.println("CANCELLED");
            } else if (option == JOptionPane.OK_OPTION){//If user gives ok
                System.out.println("OK!! -----"+(int)sModel.getValue());

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
                    quantity=sourceContainerSprite.getStored();
                }
                sourceContainerSprite.removeStored(quantity);
                sourceContainerSprite.addStored(destinationContainerSprite.addStored(quantity)); //The difference in excess when storing gets added back to the source
                System.out.println("transfer complete!!");
            }


        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(((Sprite)((JLabel)e.getSource()).getIcon()).getName().equals("postit")){
            System.out.println("\npostit");
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
    }
    @Override
    public void mousePressed(MouseEvent e) {
        Sprite pressedSprite=((Sprite)((JLabel)e.getSource()).getIcon());
        if(pressedSprite instanceof SpriteContainer){
            sourceLabel=(JLabel)e.getSource();
            sourceLabelSprite=pressedSprite;
            System.out.print("\n"+sourceLabelSprite.getName()+" - ");
        }
        else{
            System.out.print("\nINVALID - ");
        }

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if(sourceLabel!=null&&destinationLabel!=null){
            attemptTransfer();
            System.out.print("-- dest."+destinationLabelSprite.getName()+"\n");
        }
        else{
            System.out.print(" - dest.INVALID\n");
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        Sprite enteredSprite=(Sprite)((JLabel)e.getSource()).getIcon();
        if(enteredSprite instanceof SpriteContainer){
            destinationLabel=(JLabel)e.getSource();
            destinationLabelSprite=(Sprite)(destinationLabel.getIcon());
            System.out.print("("+destinationLabelSprite.getName()+")");
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        destinationLabel=null;
        destinationLabelSprite=null;
    }
}
