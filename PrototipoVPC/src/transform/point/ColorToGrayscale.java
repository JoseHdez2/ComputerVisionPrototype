package transform.point;

import java.awt.Color;

import transform.point.base.AbstractImagePointTransformation;

public class ColorToGrayscale extends AbstractImagePointTransformation{
    
    @Override
    protected int getVOut(int vIn) {
        // Return the identity-- This function shouldn't modify grayscale images!
        return vIn;
    }

    @Override
    protected Color getColorVOut(Color c) {

        int vOut = (int) ((c.getRed() * 0.2126) + (c.getGreen() * 0.7152) + (c.getBlue() * 0.0722));
        
        return new Color(vOut, vOut, vOut);
    }

}
