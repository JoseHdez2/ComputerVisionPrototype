package transform2;

import java.awt.Color;

import gui.utils.image.NamedImage;
import transform2.base.Scale;

public class ScaleBilinear extends Scale {
    // 
    // P = R + (Q-R)q
    
    public ScaleBilinear(NamedImage img, float xScale, float yScale) {
        super(img, xScale, yScale);
    }
    
    public ScaleBilinear(NamedImage img, int img2x, int img2y) {
        super(img, img2x, img2y);
    }
    
    
    protected NamedImage getCorrespondingImage(NamedImage img) {
        return scaleImage(img);
    }
    
    protected Color getCorrespondingPixel(int x, int y) {
        
        Color color = null;
        try {
            color = image.getPixelColor(0,0);
        } catch(Exception e){};
        
        return color;
    }

}