package transform2;

import java.awt.Color;

import gui.utils.image.NamedImage;
import transform2.base.CoordinatesTransform;

public class VerticalMirror extends CoordinatesTransform {
    
    NamedImage image = null;
    
    public VerticalMirror(NamedImage img) {
        image = img;
    }
    
    protected NamedImage getCorrespondingImage(NamedImage img) {
        return img.deepishCopy();
    }
    
    protected Color getCorrespondingPixel(int x, int y) {
        
        Color color = null;
        try {
            color = image.getPixelColor(x, image.getHeight()-1 - y);
        } catch(Exception e){};
        
        return color;
    }

}
