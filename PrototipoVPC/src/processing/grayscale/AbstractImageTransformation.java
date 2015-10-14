package processing.grayscale;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public abstract class AbstractImageTransformation {
    
    public void transform(BufferedImage img){

        HashMap<Integer, Integer> tabla = new HashMap<Integer, Integer>();
        
        for (int vIn = 0; vIn < 255; vIn++){
            
            int vOut = getVOut(vIn, img);
            
            tabla.put(vIn, vOut);
        }
    }
    
    public abstract int getVOut(int vIn, BufferedImage img);
}
