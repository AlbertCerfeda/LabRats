package Controller;

import Model.Media;
import View.GameFrame;

public class GameFrameController {
    public static Media media;
    public static GameFrame gf;


    public GameFrameController(GameFrame gf) {
        media = new Media();
        this.gf=gf;
    }

}
