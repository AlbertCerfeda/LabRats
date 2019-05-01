package Model;

import java.awt.*;

public class SpriteContainer extends Sprite {
    /* Extends SuperSprites attributes (frames, position ecc.) and adds the capacity attributes
    */
    protected double capacity=100;  //It's maximum capacity
    protected double stored=0;  //The quantity stored in itù

    public SpriteContainer(Image[] frames, String name, double xPercent, double yPercent, double capacity, double stored) {
        super(frames, name, xPercent, yPercent);
        this.capacity=capacity;
        this.stored=stored;
    }

    public double getCapacity() {
        return capacity;
    }
    public void setCapacity(double capacity) {
        this.capacity=capacity;
    }
    public double getStored() {
        return stored;
    }
    public void setStored(double stored) {
        this.stored=stored;
    }
}
