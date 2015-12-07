package transform2;

import java.awt.Point;

import gui.utils.image.NamedImage;

public class CoordinatesTransform {
    public NamedImage getTransformedImage(NamedImage img1){
        
        NamedImage img2 = img1.deepishCopy();
        
        for(int i = 0; i < img1.getWidth(); i++){
            for(int j = 0; j < img1.getHeight(); i++){
                img2.setPixelColor(i, j, );
            }
        }
        
        return img1;
    }
    
    abstract protected Point getCorrespondingPixel();
}
