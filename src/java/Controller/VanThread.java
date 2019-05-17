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


        Thread a= new Thread(this); //Todo: Fix this weird bug
        a.setName("VanThread");
        a.start();
    }

    @Override
    public void run(){
        for(;;){
            if(!left){ //Decreases the progress bar

                if(progressBar.getValue()>=progressBar.getMaximum()){
                    progressBar.setValue(0);
                    leavingVanAnimation();
                    left=true;


                    int sleep= new Random().nextInt(79);
                    sleep+=40;
                    sleep+=1000;

                    try{sleep(sleep/2);}catch (InterruptedException e){}
                    GameFrameController.getCookermanagerthread().sellMeth(van.getStored());
                    van.setStored(0);
                    try{sleep(sleep/2);}catch (InterruptedException e){}

                    returningVanAnimation();
                    left=false;
                }
                else if (progressBar.getValue()<=0){
                    progressBar.setValue(0);
                    progressBar.setVisible(false);
                }
                else{
                    progressBar.setVisible(true);
                    progressBar.setValue(progressBar.getValue()-4);
                }
                try{sleep(400);}catch (InterruptedException e){}
            }
        }
    }
    private void leavingVanAnimation(){
        progressBar.setVisible(false);
        for(long x=van.getX();x<GameFrameController.gf.getWidth();x+=3){
            van.setX(x);
            try{sleep(1);}catch (InterruptedException e){}
        }
        van.setVisible(false);
    }
    private void returningVanAnimation(){
        van.setVisible(true);
        for(long x=van.getX();x>=van.getOriginalXY().x;x-=3){
            van.setX(x);
            try{sleep(1);}catch (InterruptedException e){}
        }
        van.resetPosition();
        progressBar.setVisible(true);
    }
    public void registerClick(){
        progressBar.setValue(progressBar.getValue()+6);
    }
}
