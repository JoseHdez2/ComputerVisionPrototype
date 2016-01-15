package transform2;

import java.awt.Color;

import gui.utils.image.ColorHistogram;
import gui.utils.image.NamedImage;
import transform2.base.AbstractRotation;
import transform2.base.MyPoint;

public class Rotation extends AbstractRotation {
    
    int blanks;
    String interpolation = null;
    
    public Rotation(NamedImage img, double angle, String interpolation) {
        super(img, Math.toRadians(angle));
        blanks = 0;
        this.interpolation = interpolation;
    }
    
    private boolean validPixel(int x, int y) {
        return ((x> 0 && x<image.getWidth()-1) && (y> 0 && y<image.getHeight()-1));
    }
    
    protected Color getCorrespondingPixel(int x, int y) {
        
        // Traslacion de los indices(+) <-> coordenadas(+-)
        MyPoint p = indirectTransform(x + (int)traslationCoords.x(), y + (int)traslationCoords.y());
        
        if (!validPixel((int)p.x(), (int)p.y())) {
            blanks++;
            return Color.white;
        }
        
        return setInterpolation(p);
    }
    
    protected void removeFalseBlanks(NamedImage img) {
        ColorHistogram h = img.getPixelColorCount();
        img.setPixelColorCount(Color.white, h.get(Color.white)-blanks);
    }
    
    private Color setInterpolation(MyPoint point) {
        
        Color color = null;
        
        if (interpolation == "DialogScale.Nearest") {
            try {
                color = image.getPixelColor((int)point.x(), (int)point.y());
            } catch(Exception e){};
        } else {
            // A,B,C,D
            int a = image.getValueRGB((int)Math.floor(point.x()), (int)Math.ceil(point.y()), 0);
            int b = image.getValueRGB((int)Math.ceil(point.x()), (int)Math.ceil(point.y()), 0);
            int c = image.getValueRGB((int)Math.floor(point.x()), (int)Math.floor(point.y()), 0);
            int d = image.getValueRGB((int)Math.ceil(point.x()), (int)Math.floor(point.y()), 0);
            
            // Constantes p y q
            float p = (float)(point.x() - Math.floor(point.x()));
            float q = (float)(point.y() - Math.floor(point.y()));
            
            int colorValue = (int)(c + (d-c)*p + (a-c)*q + (b+c+-a-d)*p*q);
            
            // Only grayscale
            color = new Color(colorValue,colorValue,colorValue);
        }
        
        return color;
    }
}