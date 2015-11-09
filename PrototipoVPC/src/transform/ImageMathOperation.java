package transform;

import java.awt.image.BufferedImage;
import java.io.File;

import gui.utils.image.NamedImage;

public abstract class ImageMathOperation {
    
    protected NamedImage img1, img2;
    
    public ImageMathOperation(NamedImage img1, NamedImage img2){
        
    }
    
    public NamedImage operate(NamedImage img1, NamedImage img2){
        // TODO: esta linea peta
        return new NamedImage(new BufferedImage(0,0,0), new File("buf cuidado"));
    }
    
    public NamedImage getResultImage(NamedImage img1, NamedImage img2){
        // TODO: Comprobar que img1,2 tienen el mismo tamaño
        // TODO: esta linea peta
        return new NamedImage(new BufferedImage(0,0,0), new File("buf cuidado"));
    }
}
