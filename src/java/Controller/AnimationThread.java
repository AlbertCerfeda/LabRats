package Controller;

import Model.Sprite;
import Model.SpriteContainer;

import java.util.jar.JarFile;

import static java.lang.Thread.sleep;

public class AnimationThread implements Runnable{

    private long sleep;

    private SpriteContainer muTank;
    private SpriteContainer csTank;
    private SpriteContainer hclTank;
    private SpriteContainer muCooker;
    private SpriteContainer csCooker;
    private SpriteContainer hclCooker;
    private SpriteContainer tray;
    private SpriteContainer fridge;
    private SpriteContainer van;
    private Sprite postit;
    private Sprite fire;

    private int currentFrameIndex=1;
    public AnimationThread() {

        for(int n=0;n<GameFrameController.animatedCookers.size();n++){
            switch(((Sprite)GameFrameController.animatedCookers.get(n).getIcon()).getName()){
                case "muCooker":
                    System.out.println("Added "+((Sprite)GameFrameController.animatedCookers.get(n).getIcon()).getName());
                    muCooker=((SpriteContainer)GameFrameController.animatedCookers.get(n).getIcon());
                    break;
                case "csCooker":
                    System.out.println("Added "+((Sprite)GameFrameController.animatedCookers.get(n).getIcon()).getName());
                    csCooker=((SpriteContainer)GameFrameController.animatedCookers.get(n).getIcon());
                    break;
                case "hclCooker":
                    System.out.println("Added "+((Sprite)GameFrameController.animatedCookers.get(n).getIcon()).getName());
                    hclCooker=((SpriteContainer)GameFrameController.animatedCookers.get(n).getIcon());
                    break;
            }
        }
        for(int n=0;n<GameFrameController.animatedContainers.size();n++){
            switch(((Sprite)GameFrameController.animatedContainers.get(n).getIcon()).getName()){
                case "muTank":
                    System.out.println("Added "+((Sprite)GameFrameController.animatedContainers.get(n).getIcon()).getName());
                    muTank=((SpriteContainer)GameFrameController.animatedContainers.get(n).getIcon());
                    break;
                case "csTank":
                    System.out.println("Added "+((Sprite)GameFrameController.animatedContainers.get(n).getIcon()).getName());
                    csTank=((SpriteContainer)GameFrameController.animatedContainers.get(n).getIcon());
                    break;
                case "hclTank":
                    System.out.println("Added "+((Sprite)GameFrameController.animatedContainers.get(n).getIcon()).getName());
                    hclTank=((SpriteContainer)GameFrameController.animatedContainers.get(n).getIcon());
                    break;
                case "tray":
                    System.out.println("Added "+((Sprite)GameFrameController.animatedContainers.get(n).getIcon()).getName());
                    tray=((SpriteContainer)GameFrameController.animatedContainers.get(n).getIcon());
                    break;
                case "fridge":
                    System.out.println("Added "+((Sprite)GameFrameController.animatedContainers.get(n).getIcon()).getName());
                    fridge=((SpriteContainer)GameFrameController.animatedContainers.get(n).getIcon());
                    break;
                case "van":
                    System.out.println("Added "+((Sprite)GameFrameController.animatedContainers.get(n).getIcon()).getName());
                    van=((SpriteContainer)GameFrameController.animatedContainers.get(n).getIcon());
                    break;
            }
        }
        for(int n=0;n<GameFrameController.regularSprites.size();n++){
            switch(((Sprite)GameFrameController.regularSprites.get(n).getIcon()).getName()){
                case "postit":
                    System.out.println("Added "+((Sprite)GameFrameController.regularSprites.get(n).getIcon()).getName());
                    postit=((Sprite)GameFrameController.regularSprites.get(n).getIcon());
                    break;
                case "fire":
                System.out.println("Added "+((Sprite)GameFrameController.regularSprites.get(n).getIcon()).getName());
                fire=((Sprite)GameFrameController.regularSprites.get(n).getIcon());
                break;
            }
        }

        Thread thread=new Thread(this);
        thread.setName("AnimationThread");
        thread.start();
    }

    @Override
    public void run() {
        for(;;){
            GameFrameController.getMoneyLabel().setText(GameFrameController.getMoney()+"$");

            muCooker.switchFrame(0);
            csCooker.switchFrame(0);
            hclCooker.switchFrame(0);
            ////TRAY UPDATE//
            if((double)tray.getStored()/tray.getCapacity()==0){
                tray.switchFrame(0);
            }
            else if((double)tray.getStored()/tray.getCapacity()<=0.25){
                tray.switchFrame(1);
            }
            else if((double)tray.getStored()/tray.getCapacity()<=0.5){
                tray.switchFrame(2);
            }
            else if((double)tray.getStored()/tray.getCapacity()<=0.75){
                tray.switchFrame(3);
            }
            else {
                tray.switchFrame(4);
            }

            ////FRIDGE UPDATE//
            if((double)fridge.getStored()/fridge.getCapacity()==0){
                fridge.switchFrame(0);
            }
            else if((double)fridge.getStored()/fridge.getCapacity()<=0.25){
                fridge.switchFrame(1);
            }
            else if((double)fridge.getStored()/fridge.getCapacity()<=0.5){
                fridge.switchFrame(2);
            }
            else if((double)fridge.getStored()/fridge.getCapacity()<=0.75){
                fridge.switchFrame(3);
            }
            else {
                fridge.switchFrame(4);
            }

            ////VAN UPDATE//
            if((double)van.getStored()/van.getCapacity()==0){
                van.switchFrame(0);
            }
            else if((double)van.getStored()/van.getCapacity()<=0.25){
                van.switchFrame(1);
            }
            else if((double)van.getStored()/van.getCapacity()<=0.5){
                van.switchFrame(2);
            }
            else if((double)van.getStored()/van.getCapacity()<=0.75){
                van.switchFrame(3);
            }
            else {
                van.switchFrame(4);
            }

            //TANK UPDATE
            muTank.switchFrame(0);
            csTank.switchFrame(0);
            hclTank.switchFrame(0);

            postit.switchFrame(0);

            if(!GameFrameController.hasLabExploded()){
                if(CookerManagerThread.isCooking()){
                    muCooker.switchFrame(currentFrameIndex);
                    csCooker.switchFrame(currentFrameIndex);
                    hclCooker.switchFrame(currentFrameIndex);


                    currentFrameIndex++;
                    if(currentFrameIndex>2){
                        currentFrameIndex=1;
                    }
                }
                else{
                    muCooker.switchFrame(0);
                    csCooker.switchFrame(0);
                    hclCooker.switchFrame(0);

                    currentFrameIndex++;
                    if(currentFrameIndex>2){
                        currentFrameIndex=1;
                    }
                }
            }
            else{
                muCooker.switchFrame(0);
                csCooker.switchFrame(0);
                hclCooker.switchFrame(0);

                fire.setVisible(true);
                fire.switchFrame(currentFrameIndex++);

                if(currentFrameIndex>2){
                    currentFrameIndex=1;
                }
            }


            try{ sleep(100); }catch (InterruptedException e){ }
        }
    }
}
