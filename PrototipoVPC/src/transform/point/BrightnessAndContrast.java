package transform.point;

import gui.utils.image.NamedImage;
import transform.point.base.ThreeChannelAIPT;



// TODO: Only works for grayscale images.

/**
 *  Set the brightness and contrast of an image.
 */
public class BrightnessAndContrast extends ThreeChannelAIPT{

    private float A, B;
    
    public BrightnessAndContrast(NamedImage img, int newBrightness, int newContrast){
        float oldBrightness = img.getBrightness();
        float oldContrast = img.getContrast();

        if (oldContrast == 0){
            A = 255;
        } else {
            A = newContrast / oldContrast;
        }
        
        B = newBrightness - A * oldBrightness;
        // if (B < 0) B = 0;    // TODO do we need to check this?
    }

    @Override
    protected int getVOut(int vIn) {
        //int vOut = (int)(A * vIn + B);
        int vOut = (int)Math.round(A * vIn + B);
        
        // Handle out-of-range values.
        // TODO: When there are out-of-range vOut values, we are giving a false result.
        if (vOut < 0){
            vOut = 0;   // TODO: register biggest value that gets this, if any.
        }
        if (vOut > 255){
            vOut = 255; // TODO: register biggest value that gets this, if any.  
        }
        return vOut;
    }
}
