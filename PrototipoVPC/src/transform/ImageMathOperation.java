package transform;

import gui.utils.NamedImage;

public abstract class ImageMathOperation {
    
    protected NamedImage img1, img2;
    
    public ImageMathOperation(NamedImage img1, NamedImage img2){
        
    }
    
    public NamedImage operate(NamedImage img1, NamedImage img2){
        
    }
    
    public NamedImage getResultImage(NamedImage img1, NamedImage img2){
        // Comprobar que img1,2 tienen el mismo tamaño 
    }
}
