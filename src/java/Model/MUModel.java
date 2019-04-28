package Model;

import Controller.GameFrameController;

import java.awt.*;

public class MUModel extends SuperElementModel{


    public MUModel(){
        this.frames=GameFrameController.media.getMu();
        img=frames[0];
    }
}