package Model;

import Controller.GameFrameController;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class CountdownRunnable implements Runnable{
    //public static int XXaXXFormat=1;
    public static final int XXsFORMAT=2;

    private String identifier;
    private JTextArea displayLabel;
    private int clockFormat;
    private String prefixMessage;

    private boolean stop=false;
    private boolean pause=false;

    private long milliseconds;
    private long remainingMilliseconds;

    private Thread thread;
    public CountdownRunnable(String identifier, long milliseconds, JTextArea displayLabel, String prefixMessage, int clockFormat) {
        this.identifier=identifier;
        this.milliseconds=milliseconds;
        this.displayLabel=displayLabel;
        this.clockFormat=clockFormat;
        this.prefixMessage=prefixMessage;

        Thread thread=new Thread(this);
        thread.setName(identifier);
        thread.start();
    }
    public void makeItStop(){
        stop=true;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void extendTime(long plusMilliseconds){
        milliseconds+=plusMilliseconds;
        remainingMilliseconds+=plusMilliseconds;
    }

    @Override
    public void run(){
        remainingMilliseconds=milliseconds;
        int sleep=1000;

        for(;stop==false&& remainingMilliseconds>0;){
            if (displayLabel!=null){
                displayLabel.setVisible(true);
            }
            if(pause!=true){
                if (displayLabel!=null){
                    displayLabel.setText(prefixMessage);
                    switch(clockFormat){
                        case XXsFORMAT:
                            displayLabel.setText(displayLabel.getText()+ remainingMilliseconds/1000 +"s");
                            break;
                    }
                }
                if(milliseconds%sleep!=0){
                    for(sleep=1000;milliseconds%sleep!=0&&sleep>0;sleep--){//Makes the sleep end exactly the timer

                    }
                }
                try{ sleep(sleep); }catch (InterruptedException e){ }
                remainingMilliseconds-=sleep;
            }
        }
        if(remainingMilliseconds<=0){
            GameFrameController.registerCountdownEnd(this);
        }
        if (displayLabel!=null){
            displayLabel.setVisible(false);
            displayLabel.setText("");
        }

    }

    public void pause() {
        pause=true;
    }
    public void resume() {
        pause=false;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public long getRemainingMilliseconds() {
        return remainingMilliseconds;
    }
}
