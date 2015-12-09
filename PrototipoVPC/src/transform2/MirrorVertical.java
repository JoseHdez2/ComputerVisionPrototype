package transform2;

import java.awt.Color;

import gui.utils.image.NamedImage;
import transform2.base.AbstractMirror;

public class MirrorVertical extends AbstractMirror {
    
    public MirrorVertical(NamedImage img) {
        super(img);
    }

    protected Color getCorrespondingPixel(int x, int y) {
        
        Color color = null;
        try {
            color = image.getPixelColor(x, image.getHeight()-1 - y);
        } catch(Exception e){};
        
        return color;
    }

}
