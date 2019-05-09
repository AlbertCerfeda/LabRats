package Model;

import Controller.GameFrameController;

import javax.swing.*;
import java.awt.*;

public class Sprite extends ImageIcon {
    /*
    This is the mother of all Sprites classes
    */

    protected Image[] normalFrames;  //All the frames of the animation
    protected Image[] highlightedModeFrames;  //All the frames of the animation
    protected boolean highlighted=false;

    protected String name;
    protected JLabel label;

    ///Positioning for calculating if the player clicks on the sprite
    protected long x;
    protected long y;
    //////////////////////////////////////
    ///Describes the initial positioning using Percentages respect to the Background
    protected double xPercent;
    protected double yPercent;

    public Sprite(Image[] normalFrames,Image[] highlightedModeFrames, String name,double xPercent,double yPercent,JLabel label) {
        super(normalFrames[0]);
        this.normalFrames=normalFrames;
        this.highlightedModeFrames=highlightedModeFrames;
        this.name=name;
        this.xPercent=xPercent;
        this.yPercent=yPercent;
        this.label=label;
        Toolkit tk;
        tk=Toolkit.getDefaultToolkit();
        x=(long)(new ImageIcon(GameFrameController.media.getBackground()[0]).getIconWidth()*xPercent);
        y=(long)(new ImageIcon(GameFrameController.media.getBackground()[0]).getIconHeight()*yPercent);

        label.setBounds(
                (int)(new ImageIcon(GameFrameController.media.getBackground()[0]).getIconWidth()*xPercent),
                (int)(new ImageIcon(GameFrameController.media.getBackground()[0]).getIconHeight()*yPercent),
                /*width*/this.getIconWidth(),
                /*height*/this.getIconHeight()+20);
    }
    public void resetPosition(){
        setX((int)(new ImageIcon(GameFrameController.media.getBackground()[0]).getIconWidth()*xPercent));
        setY((int)(new ImageIcon(GameFrameController.media.getBackground()[0]).getIconHeight()*yPercent));
    }
    public void setHiglightMode(boolean set){
        highlighted=set;
    }
    public void setX(int x){
        this.x=x;
        label.setLocation(x,(int)y);
    }
    public void setY(int y){
        this.y=y;
        label.setLocation((int)x,y);
    }
    public void setXY(int x, int y){
        this.x=x;
        this.y=y;
        label.setLocation(x,y);
    }

    public void switchFrame(int index){
        Image newFrame;
        if(highlighted){
            newFrame=highlightedModeFrames[index];
        }
        else{
            newFrame=normalFrames[index];
        }
        label.setIcon(new ImageIcon(newFrame));
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public double getxPercent() {
        return xPercent;
    }
    public void setxPercent(double xPercent) {
        this.xPercent=xPercent;
    }

    public double getyPercent() {
        return yPercent;
    }

    public void setyPercent(double yPercent) {
        this.yPercent=yPercent;
    }
}
