package Controller;

import Model.SpriteContainer;

public class CookerManagerThread implements Runnable{

    private boolean cooking=false;
    public SpriteContainer mu;
    public SpriteContainer cs;
    public SpriteContainer hcl;

    public static String nextIngredient="cs";

    public CookerManagerThread(SpriteContainer mu, SpriteContainer cs, SpriteContainer hcl){
        this.mu=mu;
        this.cs=cs;
        this.hcl=hcl;
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
            GameFrameController.addSuccesfulIngredient();
        }
        else{
            //TODO: Boom and alerts police
            GameFrameController.makeLabExplode();
        }
    }
    @Override
    public void run() {
        long currentTime;
        long countdownEnd=-1;
        for(;;){
            currentTime=System.currentTimeMillis();
            if(checkProportions()){//If the proportions are right
                countdownEnd=-1;
                //TODO: Make the cooking label for the countdown invisible
                cooking=true;
            }
            else{//If the proportions aren't right
                cooking=false;
                if(countdownEnd==-1){//If the countdown isn't running yet it sets it running
                    countdownEnd=currentTime+(30*1000);

                    //TODO: Make the cooking label for the countdown visible
                }
                else if(countdownEnd-currentTime<=0){//If the countdown has already started and terminated
                    GameFrameController.makeLabExplode();
                    /*TODO: Boom and signal police to start the countdown
                      TODO: Make the cooking label for the countdown invisible*/
                }
            }



        }
    }
    public boolean checkProportions(){
        if(cs.getStored()*2.5==hcl.getStored() && cs.getStored()*2==hcl.getStored()){
            return true;
        }
        return false;
    }
}
