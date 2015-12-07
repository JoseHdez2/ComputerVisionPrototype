package transform2;

import java.awt.Color;

import gui.utils.image.NamedImage;
import transform2.base.CoordinatesTransform;

public class HorizontalMirror extends CoordinatesTransform {
    
    NamedImage image = null;
    
    public HorizontalMirror(NamedImage img) {
        image = img;
    }
    
    protected Color getCorrespondingPixel(int x, int y) {
        
        Color color = null;
        try {
            color = image.getPixelColor(image.getWidth()-1 - x, y);
        } catch(Exception e){};
        
        return color;
    }

}