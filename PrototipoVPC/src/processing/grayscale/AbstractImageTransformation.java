package processing.grayscale;

import gui_utils.NamedImage;

import java.util.HashMap;

public abstract class AbstractImageTransformation {
    
    /**
     * Return the transformation table.
     * A wrapper for a call to either transformLazy() or transformExtensive().
     * @param img Image to be transformed.
     */
    public void transform(NamedImage img){
//        transformLazy(img);
        transformExtensive(img);
    }
    
    /**
     * Creates transformation table for each unique value in the image.
     * More efficient and scalable than transformExtensive().
     * @param img
     */
    protected void transformLazy(NamedImage img){
        
    }
    
    // TODO: 'Only viable'-- correct phrasing?
    /**
     * Creates transformation table for all possible color values.
     * Only viable in the case of grayscale images (256 possible values).
     * Less efficient or scalable than transformLazy().
     * @param img
     */
    protected void transformExtensive(NamedImage img){

        HashMap<Integer, Integer> tabla = new HashMap<Integer, Integer>();
        
        // Repeat for each of the colors.
        for (int vIn = 0; vIn < 255; vIn++){
            
            // For this color value, calculate the corresponding new color value.
            // This method will vary depending on the implementing class (Strategy design pattern).
            int vOut = getVOut(vIn, img);
            
            tabla.put(vIn, vOut);
        }
    }
    
    /**
     * Given a color value, return its corresponding new value.
     * This method will be implemented differently by extending classes,
     * leading to the different types of image transformations.
     * @param vIn   Given color value
     * @param img   Complete image data, needed for some transformations.
     * @return New color value that corresponds to the given one.
     */
    protected abstract int getVOut(int vIn, NamedImage img);
}
