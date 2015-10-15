package processing.grayscale;

import java.awt.Color;

import gui.utils.NamedImage;

public abstract class AbstractImageTransformation {
    
    /**
     * Return the transformation table.
     * A wrapper for a call to either transformLazy() or transformExtensive().
     * @param img Image to be transformed.
     */
    public TransformationTable transform(NamedImage img){
//        return transformLazy(img);
        return transformExtensive(img);
    }
    
    /**
     * Creates transformation table for each unique value in the image.
     * More efficient and scalable than transformExtensive().
     * @param img
     */
    protected TransformationTable transformLazy(NamedImage img){
        
        TransformationTable transTable = new TransformationTable();
        
        // Repeat for each of the colors.
        for (int vIn = 0; vIn < 255; vIn++){
            
            // For this color value, calculate the corresponding new color value.
            // This method will vary depending on the implementing class (Strategy design pattern).
            int vOut = getVOut(vIn, img);
            
            transTable.put(new Color(vIn, vIn, vIn), new Color(vOut, vOut, vOut));
        }
        
        return transTable;
    }
    
    // TODO: 'Only viable'-- correct phrasing?
    /**
     * Creates transformation table for all possible color values.
     * Only viable in the case of grayscale images (256 possible values).
     * Less efficient or scalable than transformLazy().
     * @param img
     */
    protected TransformationTable transformExtensive(NamedImage img){

        TransformationTable transTable = new TransformationTable();
        
        // Repeat for each of the colors.
        for (int vIn = 0; vIn < 255; vIn++){
            
            // For this color value, calculate the corresponding new color value.
            // This method will vary depending on the implementing class (Strategy design pattern).
            int vOut = getVOut(vIn, img);
            
            transTable.put(new Color(vIn, vIn, vIn), new Color(vOut, vOut, vOut));
        }
        
        return transTable;
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
