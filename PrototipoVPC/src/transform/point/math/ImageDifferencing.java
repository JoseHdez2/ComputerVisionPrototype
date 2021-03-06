package transform.point.math;

import java.awt.Color;
import java.awt.image.BufferedImage;

import gui.utils.image.NamedImage;
import gui.utils.image.NamedImageCreator;

public class ImageDifferencing {

    // devuelve mapa de cambios, las diferencias entre dos imagenes.
    private NamedImage img1 = null;
    private NamedImage img2 = null;
    
    public ImageDifferencing(NamedImage img1, NamedImage img2) {
        
        this.img1 = img1;
        this.img2 = img2;
    }
    
    /**
     * Returns new image difference between img1 and img2
     * @return Differencing NamedImage.
     */
    public NamedImage getDiff() {
    
        NamedImage image = NamedImageCreator.create(img1.getFile());    // Ojo con el File
        int[] rgb = new int[3];
        
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        
        for (int i=0; i<imageWidth; i++) {
            for (int j=0; j<imageHeight; j++) {
 
                // Calcular diferencia
                rgb[0] = Math.abs(img1.getValueRGB(i,j,0) - img2.getValueRGB(i,j,0));
                
                if (!image.isGrayscale()) {
                    rgb[1] = Math.abs(img1.getValueRGB(i,j,1) - img2.getValueRGB(i,j,1));
                    rgb[2] = Math.abs(img1.getValueRGB(i,j,2) - img2.getValueRGB(i,j,2));  
                }
                
                // Asignar pixel
                if (!image.isGrayscale()) {
                    image.setValueRGB(i,j, new int[]{rgb[0]});
                } else {
                    image.setValueRGB(i,j, new int[]{rgb[0],rgb[1],rgb[2]});
                }
            }
        }
        
        return image;
    }
    
    /**
     * Returns new image with map color difference by threshold value
     * @return NamedImage with colored changes.
     */
    public NamedImage getMap(int threshold) {
       
        // Generar nueva imagen a color
        BufferedImage bi = new BufferedImage(img1.getWidth(),img1.getHeight(),BufferedImage.TYPE_INT_RGB);
        NamedImage image = new NamedImage(bi,img1.getFile());
       
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
       
        for (int i=0; i<imageWidth; i++) {
            for (int j=0; j<imageHeight; j++) {
               
                Color oldColor = null;
                try {
                    oldColor = img1.getPixelColor(i, j);
                } catch(Exception e){};
                
                if (oldColor.getBlue() > threshold) {
                    image.setPixelColor(i, j, Color.red);
                } else {
                    image.setPixelColor(i, j, oldColor);
                }
            }
        }
        
        return image;
    }

}
