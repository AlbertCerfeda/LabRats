package Controller;

import Model.SpriteContainer;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.RunnableScheduledFuture;

import static java.lang.Thread.sleep;

public class VanThread implements Runnable {
    SpriteContainer van;
    JProgressBar progressBar;
    private boolean left=false;

    public VanThread(SpriteContainer van,JProgressBar progressBar) {
        this.van=van;
        this.progressBar=progressBar;


        Thread a= new Thread(); //Todo: Fix this weird bug
        a.setName("VanThread");
        a.run();
    }

    @Override
    public void run() {
        for(;;){
            if(!left){
                //Decreases the progress bar
                progressBar.setValue(progressBar.getValue()-4);

                if (progressBar.getValue()<=0){
                    progressBar.setValue(0);
                    progressBar.setVisible(false);
                }
                try{sleep(300);}catch (InterruptedException e){}
            }
        }
    }
    private void leavingVanAnimation(){
        progressBar.setVisible(false);
        van.setVisible(false);
        System.out.println("LEFT");
    }
    private void returningVanAnimation(){
        progressBar.setVisible(true);
        van.setVisible(true);
        System.out.println("RETURNED");
    }
    public void registerClick(){

        progressBar.setValue(progressBar.getValue()+6);

        if(progressBar.getValue()>=progressBar.getMaximum()){
            leavingVanAnimation();
            left=true;

            int sleep= new Random().nextInt(79);
            sleep+=40;
            sleep*=1000;
            try{sleep(sleep);}catch (InterruptedException e){}
            returningVanAnimation();
            left=false;
        }
    }
}
