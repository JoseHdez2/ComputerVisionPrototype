package transform2.base;

import java.awt.Color;

import gui.utils.image.NamedImage;

public abstract class CoordinatesTransform {
    
    public NamedImage getTransformedImage(NamedImage img1){
        
        NamedImage img2 = getCorrespondingImage(img1);
        
        for(int i = 0; i < img2.getWidth(); i++){
            for(int j = 0; j < img2.getHeight(); j++){
                
                Color color = getCorrespondingPixel(i,j);
                img2.setPixelColor(i,j,color);     
            }
        }
        
        return img2;
    }
    
    //abstract protected Point getCorrespondingPixel();
    
    /** Given a image get a new image with corresponding dimensions
     *  (Transpose: width <-> height, Scale: width*3.15,...)
     * @param img original
     * @return new image
     */
    protected abstract NamedImage getCorrespondingImage(NamedImage img);
    
    /** Given x and y coordinates get corresponding color
     * @param x
     * @param y
     * @return corresponding color
     */
    protected abstract Color getCorrespondingPixel(int x, int y);
}
