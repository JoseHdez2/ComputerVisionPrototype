package transform2;

import java.awt.Color;

import gui.utils.image.ColorHistogram;
import gui.utils.image.NamedImage;
import transform2.base.AbstractRotation;
import transform2.base.MyPoint;

public class Rotation extends AbstractRotation {
    
    int blanks;
    
    public Rotation(NamedImage img, double angle) {
        super(img, Math.toRadians(angle));
        blanks = 0;
    }
    
    private boolean validPixel(int x, int y) {
        return ((x>= 0 && x<image.getWidth()) && (y>= 0 && y<image.getHeight()));
    }
    
    protected Color getCorrespondingPixel(int x, int y) {
        
        // Traslacion de los indices(+) <-> coordenadas(+-)
        MyPoint p = indirectTransform(x + (int)traslationCoords.x(), y + (int)traslationCoords.y());
        
        if (!validPixel((int)p.x(), (int)p.y())) {
            blanks++;
            return Color.white;
        }
        
        Color color = null;
        try {
            color = image.getPixelColor((int)p.x(), (int)p.y());
        } catch(Exception e){};
        
        return color;
    }
    
    protected void removeFalseBlanks(NamedImage img) {
        ColorHistogram h = img.getPixelColorCount();
        img.setPixelColorCount(Color.white, h.get(Color.white)-blanks);
    }
}