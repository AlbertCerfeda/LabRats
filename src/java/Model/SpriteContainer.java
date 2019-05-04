package Model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SpriteContainer extends Sprite {
    /* Extends SuperSprites attributes (frames, position ecc.) and adds the capacity attributes
    */
    protected JLabel floatingInfoLabel;//The following label which indicates the storage informations

    protected int capacity;  //It's maximum capacity
    protected int stored;  //The quantity stored in itù

    public SpriteContainer(Image[] frames, String name, double xPercent, double yPercent, int capacity, int stored,JLabel label,JLabel spriteFloatingInfoLabel) {
        super(frames, name, xPercent, yPercent,label);
        this.capacity=capacity;
        this.stored=stored;
        this.floatingInfoLabel=spriteFloatingInfoLabel;

        Border border;
        border=BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),"Cojone");
        label.setBorder(border);

        spriteFloatingInfoLabel.setText("SAMPLE TEXT");
        spriteFloatingInfoLabel.setBounds(100,100,100,100);
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
        if (capacity==-1){
            return 0;
        }
        else{
            int difference=stored-capacity;
            if(difference>0){
                stored=capacity;
                return difference;
            }
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
