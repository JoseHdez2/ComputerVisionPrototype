package transform2;

import java.awt.Color;

import gui.utils.image.NamedImage;
import transform2.base.Scale;

public class ScaleNearest extends Scale {
    
    
    public ScaleNearest(NamedImage img, float xScale, float yScale) {
        super(img, xScale, yScale);
    }
    
    public ScaleNearest(NamedImage img, int img2x, int img2y) {
        super(img, img2x, img2y);
    }
    
    
    protected NamedImage getCorrespondingImage(NamedImage img) {
        return scaleImage(img);
    }
    
    protected Color getCorrespondingPixel(int x, int y) {
        
        Color color = null;
        try {
            color = image.getPixelColor((int)(x/xScale), (int)(y/yScale));
        } catch(Exception e){};
        
        return color;
    }

}