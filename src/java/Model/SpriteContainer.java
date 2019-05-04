package Model;

import java.awt.*;

public class SpriteContainer extends Sprite {
    /* Extends SuperSprites attributes (frames, position ecc.) and adds the capacity attributes
    */
    protected int capacity;  //It's maximum capacity
    protected int stored;  //The quantity stored in itù

    public SpriteContainer(Image[] frames, String name, double xPercent, double yPercent, int capacity, int stored) {
        super(frames, name, xPercent, yPercent);
        this.capacity=capacity;
        this.stored=stored;
    }

    public double getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity=capacity;
    }
    public double getStored() {
        return stored;
    }
    public void setStored(int stored) {
        this.stored=stored;
    }
    public int addStored(int addedStorage){
        stored+=addedStorage;
        int difference=stored-capacity;
        if(difference>0){
            stored=capacity;
            return difference;
        }
        return 0;
    }
    public void removeStored(int removedStorage){
        stored-=removedStorage;
        if(stored<0){
            stored=0;
        }
    }
}
