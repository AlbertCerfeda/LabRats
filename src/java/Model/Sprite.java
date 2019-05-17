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
        resetPosition();

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
    public void setHighlightMode(boolean set){
        highlighted=set;
    }
    public void setX(long x){
        this.x=x;
        label.setLocation((int)x,(int)y);
    }
    public void setY(long y){
        this.y=y;
        label.setLocation((int)x,(int)y);
    }
    public void setXY(long x, long y){
        this.x=x;
        this.y=y;
        label.setLocation((int)x,(int)y);
    }
    public Point getOriginalXY(){
        Point result= new Point();
        result.setLocation((long)(new ImageIcon(GameFrameController.media.getBackground()[0]).getIconWidth()*xPercent),(long)(new ImageIcon(GameFrameController.media.getBackground()[0]).getIconHeight()*yPercent));
        return result;
    }
    public void switchFrame(int index){
        Image newFrame=normalFrames[index];
        if(highlighted){
            if(highlightedModeFrames!=null){
                newFrame=highlightedModeFrames[index];
            }
        }
        else{
            newFrame=normalFrames[index];
        }
        super.setImage(newFrame);
    }
    public void setVisible(boolean visible){
        label.setVisible(visible);
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
    public long getX() {
        return x;
    }
    public long getY() {
        return y;
    }
}
