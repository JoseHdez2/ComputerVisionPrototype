package transform2;

import java.awt.Color;

import gui.utils.image.ColorHistogram;
import gui.utils.image.NamedImage;
import transform2.base.AbstractRotation;
import transform2.base.MyPoint;

public class RotationAndPaint extends AbstractRotation {
    
    NamedImage img2 = null;
    int blanks;
    
    public RotationAndPaint(NamedImage img, double angle) {
        super(img, Math.toRadians(angle));
        blanks = 0;
    }
    
    private boolean validPixel(int x, int y) {
        return ((x> 0 && x<img2.getWidth()-1) && (y> 0 && y<img2.getHeight()-1));
    }
    
    private MyPoint translateCoords(MyPoint p) {
        return new MyPoint(p.x()-(int)traslationCoords.x(), p.y()-(int)traslationCoords.y());
    }
    
    protected void removeFalseBlanks(NamedImage img) {
        ColorHistogram h = img.getPixelColorCount();
        img.setPixelColorCount(Color.white, blanks);
    }
    
    public NamedImage getTransformedImage(NamedImage img1){
        
        img2 = getCorrespondingImage(img1);
        
        //Pintar fondo blanco
        for(int i = 0; i < img2.getWidth(); i++)
            for(int j = 0; j < img2.getHeight(); j++)
                img2.setPixelColor(i, j, Color.white);
                
        // Calcular
        for(int i = 0; i < img1.getWidth(); i++) {
            for(int j = 0; j < img1.getHeight(); j++) {
                
                // Transformacion directa
                MyPoint p = translateCoords(directTransform(i,j));
                
                if (validPixel((int)p.x(), (int)p.y())) {
                
                    Color color = null;
                    try {
                        color = img1.getPixelColor(i,j);
                    } catch(Exception e){};
                    
                    if (color == Color.white)
                        blanks++;
    
                    img2.setPixelColor((int)p.x(), (int)p.y(), color);
                }  
            }
        }
        
        removeFalseBlanks(img2);
        return img2;
    }
    
    protected Color getCorrespondingPixel(int x, int y) {
        return Color.white;
    }
}
  