package transform2;

import java.awt.Color;

import gui.utils.image.NamedImage;
import transform2.base.AbstractMirror;

public class MirrorHorizontal extends AbstractMirror {
    
    public MirrorHorizontal(NamedImage img) {
        super(img);
    }
    
    protected Color getCorrespondingPixel(int x, int y) {
        
        Color color = null;
        try {
            color = image.getPixelColor(image.getWidth()-1 - x, y);
        } catch(Exception e){};
        
        return color;
    }

}