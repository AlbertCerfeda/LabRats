package Model;

import java.awt.*;

public class SpriteContainerElement extends SpriteContainer{
    /*
    Represents a cooking ingredient
    Extends the attributes of a sprite (frames, position ecc.) with container capabilities (stored, maxcapacity ecc)
    */

    public boolean readyToCook = false;  //true if it has something stored, if its empty its false

    public SpriteContainerElement(Image[] frames, String name, double xPercent, double yPercent, double capacity, double stored) {
        super(frames, name, xPercent, yPercent, capacity, stored);
    }
}
