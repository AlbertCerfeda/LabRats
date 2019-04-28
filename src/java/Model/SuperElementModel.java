package Model;

import java.awt.*;

public class SuperElementModel {//Superclass of every element that has to cook
    protected Image img;  //The image that is currently active for the sprite
    protected Image[] frames;  //All the frames of the animation

    ///Positioning for calculating if the player clicks on the sprite
    protected double x;
    protected double y;
    //////////////////////////////////////

    protected double capacity=100;  //It's maximum capacity
    protected double stored=0;  //The quantity stored in it

    public void setX(double x) {
        this.x=x;
    }

    public void setY(double y) {
        this.y=y;
    }

    public static boolean readyToCook = false;  //true if it has something stored, if its empty its false

}
