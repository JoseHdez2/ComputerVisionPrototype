package transform.point.base;

import java.awt.Color;

/**
 *  Abstract Image Point Transformation that,
 *  in color transformations, acts the same for each color channel
 *  as it does for the grayscale channel.
 */
public abstract class ThreeChannelAIPT extends AbstractImagePointTransformation {
    
    protected Color getColorVOut(Color c){

        int vOutR = getVOut(c.getRed());
        int vOutG = getVOut(c.getGreen());
        int vOutB = getVOut(c.getBlue());
        
        return new Color(vOutR, vOutG, vOutB);
    }
}
