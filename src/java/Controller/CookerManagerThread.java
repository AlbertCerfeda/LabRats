package Controller;

import Model.SpriteContainer;

public class CookerManagerThread implements Runnable{

    private static boolean cooking=false;
    public SpriteContainer mu;
    public SpriteContainer cs;
    public SpriteContainer hcl;
    public SpriteContainer tray;
    public SpriteContainer fridge;
    public SpriteContainer van;

    public static String nextIngredient="cs";

    public CookerManagerThread(SpriteContainer mu, SpriteContainer cs, SpriteContainer hcl, SpriteContainer tray, SpriteContainer fridge, SpriteContainer van){
        this.mu=mu;
        this.cs=cs;
        this.hcl=hcl;
        this.tray=tray;
        this.fridge=fridge;
        this.van=van;
        Thread thread=new Thread(this);
        thread.setName("CookerManager");
        thread.start();
    }
    public static boolean isCorrectIngredient(String element){
        if (element==nextIngredient){
            return true;
        }
        else{
            return false;
        }
    }
    public static void addIngredient(String element){
        if (isCorrectIngredient(element)){
            switch(nextIngredient){
                case "cs":
                    nextIngredient="hcl";
                    break;
                case "hcl":
                    nextIngredient="mu";
                    break;
                case "mu":
                    nextIngredient="cs";
                    break;
            }
            GameFrameController.addSuccessfulIngredient();
        }
        else{
            GameFrameController.makeLabExplode();
        }
    }

    public static boolean isCooking() {
        return cooking;
    }

    @Override
    public void run() {
        for(;;){
            if(!GameFrameController.hasLabExploded()){
                /////////////////////////
                //Proportions Part
                    System.out.print("");
                    if(cs.getStored()>0||hcl.getStored()>0||mu.getStored()>0){
                        if(checkProportions()){//If the proportions are right
                            if(GameFrameController.isProportionsCountdownActive()){
                                GameFrameController.getProportionsCountdownRunnable() .makeItStop();
                                GameFrameController.setProportionsCountdownRunnable(null);
                            }
                            if(tray.getStored()+GameFrameController.getUnitsCookedForCookCycle()<=tray.getCapacity()){
                                cooking=true;
                            }
                            else{
                                cooking=false;
                                GameFrameController.getTrayCountdownRunnable().pause();
                            }
                        }
                        else{//If the proportions aren't right
                            cooking=false;
                            if(!GameFrameController.isProportionsCountdownActive()){//If the countdown isn't running yet it sets it running
                                GameFrameController.proportionsAreWrong();
                            }
                        }
                    }
                    else{
                        cooking=false;
                    }

                /////////////////////////
                if(cooking){

                    //If the countdowns were paused, it resumes them


                    if(GameFrameController.isTraysCountdownActive()){
                        GameFrameController.getTrayCountdownRunnable().resume();
                        //If the tray countdown is active
                        //Updates the total cooking countdown on the tray
                        if( GameFrameController.getMillisForCookCycle()!=GameFrameController.getTrayCountdownRunnable().getMilliseconds()){
                            GameFrameController.getTrayCountdownRunnable().extendTime(GameFrameController.getTrayCountdownRunnable().getMilliseconds()-GameFrameController.getMillisForCookCycle());
                        }
                    }
                    else{
                        GameFrameController.resetCountdownRunnable(GameFrameController.TRAY_COUNTDOWN);
                    }
                    if(GameFrameController.isTraysCountdownActive()){
                        GameFrameController.getTrayCountdownRunnable().resume();
                    }
                    else{
                        GameFrameController.resetCountdownRunnable(GameFrameController.TRAY_COUNTDOWN);
                    }
                }
                else{
                    if(GameFrameController.isTraysCountdownActive()) GameFrameController.getTrayCountdownRunnable().pause();
                }
            }
            else{
                cooking=false;
                if(GameFrameController.isTraysCountdownActive()) GameFrameController.getTrayCountdownRunnable().makeItStop();
                if(GameFrameController.isTraysCountdownActive()) GameFrameController.getTrayCountdownRunnable().makeItStop();
            }
        }
    }
    public boolean checkProportions(){


            if(cs.getStored()*3==hcl.getStored() && cs.getStored()*2==mu.getStored()){
                return true;
            }
            return false;
    }
    public void cookCycleDone(){
        cs.removeStored(1);
        hcl.removeStored(3);
        mu.removeStored(2);
        tray.addStored(GameFrameController.getUnitsCookedForCookCycle());
    }
}
