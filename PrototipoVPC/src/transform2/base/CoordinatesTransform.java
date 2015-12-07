package transform2.base;

import java.awt.Color;

import gui.utils.image.NamedImage;

public abstract class CoordinatesTransform {
    
    public NamedImage getTransformedImage(NamedImage img1){
        
        NamedImage img2 = img1.deepishCopy();
        
        for(int i = 0; i < img2.getWidth(); i++){
            for(int j = 0; j < img2.getHeight(); j++){
                
                Color color = getCorrespondingPixel(i,j);
                img2.setPixelColor(i,j,color);     
            }
        }
        
        return img2;
    }
    
    //abstract protected Point getCorrespondingPixel();
    
    
    protected abstract Color getCorrespondingPixel(int x, int y);
}
