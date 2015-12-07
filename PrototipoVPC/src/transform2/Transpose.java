package transform2;

import java.awt.Color;
import java.awt.image.BufferedImage;

import gui.utils.image.NamedImage;
import transform2.base.CoordinatesTransform;

public class Transpose extends CoordinatesTransform {
    
    NamedImage image = null;
    
    public Transpose(NamedImage img) {
        image = img;
    }
    
    protected NamedImage getCorrespondingImage(NamedImage img) {

        BufferedImage bi = new BufferedImage(img.getHeight(),img.getWidth(),img.getType());
        NamedImage img2 = new NamedImage(bi,img.getFile());
        
        return img2;
    }
    
    protected Color getCorrespondingPixel(int x, int y) {
        
        Color color = null;
        try {
            color = image.getPixelColor(y,x);
        } catch(Exception e){};
        
        return color;
    }

}
