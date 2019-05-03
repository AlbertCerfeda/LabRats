package Controller;

import Model.SpriteContainer;

public class CookerManagerThread implements Runnable{

    private boolean cooking=false;
    public SpriteContainer mu;
    public SpriteContainer cs;
    public SpriteContainer hcl;

    public CookerManagerThread(SpriteContainer mu, SpriteContainer cs, SpriteContainer hcl){
        this.mu=mu;
        this.cs=cs;
        this.hcl=hcl;
    }

    @Override
    public void run() {

    }
    public void checkIfCanCook(){

    }
}
