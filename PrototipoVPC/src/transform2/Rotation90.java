package transform2;

import java.awt.Color;

import gui.utils.image.NamedImage;
import transform2.base.AbstractRotation;
import transform2.base.MyPoint;

public class Rotation90 extends AbstractRotation {
    
    public Rotation90(NamedImage img, double angle) {
        super(img, Math.toRadians(angle));
    }
    
    protected Color getCorrespondingPixel(int x, int y) {
        
        // Traslacion de los indices(+) <-> coordenadas(+-)
        MyPoint p = indirectTransform(x + (int)traslationCoords.x(), y + (int)traslationCoords.y());
        
        Color color = null;
        try {
            color = image.getPixelColor((int)p.x(), (int)p.y());
        } catch(Exception e){};
        
        return color;
    }
}