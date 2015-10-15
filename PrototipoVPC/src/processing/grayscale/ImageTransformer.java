package processing.grayscale;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

import gui_utils.NamedImage;

public class ImageTransformer {
    // TODO: Consider putting functionality into AbstractImageTransformation.
    // Have AbstractImageTransformation give us the transformation table.
    
    AbstractImageTransformation transformation;
    
    public ImageTransformer(AbstractImageTransformation transformation){
        
        this.transformation = transformation;
    }
    
    public NamedImage getTransformedImage(NamedImage img){
        
        TransformationTable transTable = transformation.transform(img);
        
        return createTransformedImage(img, transTable);
    }
    
    private NamedImage createTransformedImage(NamedImage img1, TransformationTable tt){
        
        NamedImage img2 = deepishCopy(img1);
        
        int imageWidth = img2.getWidth();
        int imageHeight = img2.getHeight();
        
        for (int i = 0; i < imageWidth; i++){
            for (int j = 0; j < imageHeight; j++){

                Color oldPixelColor = new Color(img1.getRGB(i, j));
                
                Color newPixelColor = tt.get(oldPixelColor);
                
                img2.setRGB(i, j, newPixelColor.getRGB());
            }
        }
        
        return img2;
    }
    
    static NamedImage deepishCopy(NamedImage ni) {
        
        ColorModel cm = ni.getColorModel();
        
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        
        WritableRaster raster = ni.copyData(null);
        
        BufferedImage bi = new BufferedImage(cm, raster, isAlphaPremultiplied, null);
        
        return new NamedImage(bi, ni.getFile());
   }
}
