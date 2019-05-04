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
        }
        else{
            //TODO: Boom and alerts police
        }
    }
    @Override
    public void run() {

    }
    public void checkIfCanCook(){

    }
}
