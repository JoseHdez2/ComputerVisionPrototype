package transform2;

import java.awt.Color;

import gui.utils.image.NamedImage;
import transform2.base.AbstractRotation;
import transform2.base.MyPoint;

public class RotationAndPaint extends AbstractRotation {
    
    NamedImage image = null;
    
    public RotationAndPaint(NamedImage img, double angle) {
        super(img, Math.toRadians(angle));
    }
    
    private boolean validPixel(int x, int y) {
        return ((x> 0 && x<image.getWidth()-1) && (y> 0 && y<image.getHeight()-1));
    }
    
    /*
    private Point coordToInd(Point coord, Point offset){
        return new Point(coord.x - dim.x, coord.y - dim.y);
    }*/
    
    public NamedImage getTransformedImage(NamedImage img1){
        
        NamedImage img2 = getCorrespondingImage(img1);
        image = img2;
        
        for(int i = 0; i < img1.getWidth(); i++){
            for(int j = 0; j < img1.getHeight(); j++){
                
                // Transformacion directa
//                MyPoint p = directTransform(i - (int)traslationCoords.x(), j - (int)traslationCoords.y());
//                MyPoint p = directTransform(i + (int)traslationCoords.x(), j + (int)traslationCoords.y());
                MyPoint p = directTransform(i ,j);
                
                if (validPixel((int)p.x(), (int)p.y())) {
                
                    Color color = null;
                    try {
                        color = img1.getPixelColor(i,j);
                    } catch(Exception e){};
                    
                    if (color == null)
                        color = Color.white;

                    img2.setPixelColor((int)p.x(), (int)p.y(), color);
                }  
            }
        }
        
//        removeFalseBlanks(img2);
        return img2;
    }
    
    protected Color getCorrespondingPixel(int x, int y) {
        return Color.white;
    }
}
  