package Model;

import Controller.GameFrameController;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SpriteContainer extends Sprite {
    /* Extends SuperSprites attributes (frames, position ecc.) and adds the capacity attributes
    */
    protected JLabel floatingInfoLabel;//The following label which indicates the storage informations

    protected long capacity;  //It's maximum capacity
    protected long stored;  //The quantity stored in itù

    public SpriteContainer(Image[] normalFrames,Image[] highlightModeFrames, String name, double xPercent, double yPercent, int capacity, int stored,JLabel label) {
        super(normalFrames,highlightModeFrames, name, xPercent, yPercent,label);
        this.capacity=capacity;
        this.stored=stored;

        TitledBorder border;
        border=BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        border.setTitleJustification(TitledBorder.CENTER);

        Font font=new Font(Font.SANS_SERIF,Font.BOLD,30);
        border.setTitle("INFO");
        border.setTitleFont(font);
        border.setTitleJustification(TitledBorder.CENTER);
        label.setBorder(border);

        refreshBorder();
    }
    public void refreshBorder(){
        TitledBorder border=(TitledBorder)label.getBorder();
        Font font=border.getTitleFont();
        border.setTitle(getStored()+"/");
        if(name.contains("Tank")){
            font=new Font(font.getFamily(),font.getStyle(), (int)GameFrameController.media.getImageResizeRatio()*2);
            border.setTitleFont(font);
            border.setTitle(border.getTitle()+"-");
            border.setTitleColor(Color.green);
        }
        else{
            font=new Font(font.getFamily(),font.getStyle(), (int)GameFrameController.media.getImageResizeRatio()*4);
            border.setTitleFont(font);
            border.setTitle(border.getTitle()+getCapacity());
            if(stored/capacity<0.3){
                border.setTitleColor(Color.green);
            }
            else if(stored/capacity<1){
                border.setTitleColor(Color.yellow);
            }
            else{
                border.setTitleColor(Color.red);
            }
        }
        if (name.contains("Cooker")){
            border.setTitlePosition(TitledBorder.BELOW_BOTTOM);
        }
        label.setBorder(border);
    }
    public long getCapacity() {
        return capacity;
    }
    public void setCapacity(long capacity) {
        this.capacity=capacity;
        refreshBorder();
    }
    public long getStored() {
        return stored;
    }
    public void setStored(long stored) {
        this.stored=stored;
        refreshBorder();
    }
    public long addStored(long addedStorage){
        stored+=addedStorage;
        if (capacity==-1){
            refreshBorder();
            return 0;
        }
        else{
            long difference=stored-capacity;
            if(difference>0){
                stored=capacity;
                refreshBorder();
                return difference;
            }
        }
        refreshBorder();
        return 0;
    }
    public void removeStored(long removedStorage){
        stored-=removedStorage;
        if(stored<0){
            stored=0;
        }
        refreshBorder();
    }
}
