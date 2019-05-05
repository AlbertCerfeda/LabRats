package Model;

import Controller.GameFrameController;

import javax.swing.*;
import java.awt.*;

public class Sprite extends ImageIcon {
    /*
    This is the mother of all Sprites classes
    */

    protected Image[] frames;  //All the frames of the animation
    protected String name;
    protected JLabel label;

    ///Positioning for calculating if the player clicks on the sprite
    protected long x;
    protected long y;
    //////////////////////////////////////
    ///Describes the initial positioning using Percentages respect to the Background
    protected double xPercent;
    protected double yPercent;

    public Sprite(Image[] frames, String name,double xPercent,double yPercent,JLabel label) {
        super(frames[0]);
        this.frames=frames;
        this.name=name;
        this.xPercent=xPercent;
        this.yPercent=yPercent;
        this.label=label;
        Toolkit tk;
        tk=Toolkit.getDefaultToolkit();
        x=(long)(new ImageIcon(GameFrameController.media.getBackground()[0]).getIconWidth()*xPercent);
        y=(long)(new ImageIcon(GameFrameController.media.getBackground()[0]).getIconHeight()*xPercent);

        label.setBounds(
                (int)(new ImageIcon(GameFrameController.media.getBackground()[0]).getIconWidth()*xPercent),
                (int)(new ImageIcon(GameFrameController.media.getBackground()[0]).getIconHeight()*yPercent),
                /*width*/this.getIconWidth(),
                /*height*/this.getIconHeight()+30);
    }
    public void resetPosition(){
        x=(long)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*(xPercent/100));
        y=(long)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*(yPercent/100));
    }
    public void setX(int x){
        this.x=x;
        label.setBounds(x,label.getY(),label.getWidth(),label.getHeight());
    }
    public void setY(int y){
        this.y=y;
        label.setBounds(label.getX(),y,label.getWidth(),label.getHeight());
    }
    public void setXY(int x, int y){
        this.x=x;
        this.y=y;
        label.setBounds(x,y,label.getWidth(),label.getHeight());
    }
    public void setFrame(Image frame,JLabel label){
        label.setIcon(new ImageIcon(frame));
    }
    public Image[] getFrames() {
        return frames;
    }
    public void setFrames(Image[] frames) {
        this.frames=frames;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public double getX() {
        return x;
    }
    public void setX(long x) {
        this.x=x;
    }
    public double getY() {
        return y;
    }
    public void setY(long y) {
        this.y=y;
    }
    public double getxPercent() {
        return xPercent;
    }
    public void setxPercent(long xPercent) {
        this.xPercent=xPercent;
    }

    public double getyPercent() {
        return yPercent;
    }

    public void setyPercent(long yPercent) {
        this.yPercent=yPercent;
    }
}
