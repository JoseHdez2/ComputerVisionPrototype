package transform.point.base;

import java.awt.Color;
import java.awt.image.WritableRaster;

import gui.utils.image.ColorHistogram;
import gui.utils.image.NamedImage;
import transform.base.AbstractImageTransformation;

public abstract class AbstractImagePointTransformation extends AbstractImageTransformation {
    
    /**
     * Take an input image and output the transformed image.
     * @param img1 Input image.
     * @return Output (transformed) image.
     */
    public NamedImage getTransformedImage(NamedImage img1){
        LUT lut = new LUT();
        if (img1.isGrayscale()) lut = createGrayscaleLUT();
        else lut = createColorLUT(img1.getPixelColorCount());
        return createTransformedImage(img1, lut);
    }
    
    /**
     * Having created a look-up table, take the input image and create the output image.
     * @param img1  Input image.
     * @param lut   Look-up table.
     * @return  Output (transformed) image.
     */
    protected NamedImage createTransformedImage(NamedImage img1, LUT lut){
        
        NamedImage img2 = img1.deepishCopy();
        
        WritableRaster raster = img2.getRaster();
        int imageWidth = img2.getWidth();
        int imageHeight = img2.getHeight();
        
        for (int i = 0; i < imageWidth; i++){
            for (int j = 0; j < imageHeight; j++){

                Color oldPixelColor = null;
                
                if (img2.isGrayscale())
                    oldPixelColor = new Color(raster.getSample(i,j,0),raster.getSample(i,j,0),raster.getSample(i,j,0));
                else
                    oldPixelColor = new Color(raster.getSample(i,j,0),raster.getSample(i,j,1),raster.getSample(i,j,2));
                
                Color newPixelColor = lut.get(oldPixelColor);

                raster.setSample(i,j,0,newPixelColor.getRed());
                if (!img2.isGrayscale()) {
                    raster.setSample(i,j,1,newPixelColor.getGreen());
                    raster.setSample(i,j,2,newPixelColor.getBlue());
                }
            }
        }        
        
        return img2;
    }
    
    /**
     * Creates transformation table for each unique value in the image.
     * @param img
     */
    protected LUT createGrayscaleLUT(){
        
        LUT transTable = new LUT();
        
        // Repeat for each of the colors.
        for (int vIn = 0; vIn <= 255; vIn++){
            
            // For this color value, calculate the corresponding new color value.
            // This method will vary depending on the transformation(implementing class).
            int vOut = getVOut(vIn);
            
            //System.out.println(vIn + " -> " + vOut);
            
            transTable.put(new Color(vIn, vIn, vIn), new Color(vOut, vOut, vOut));
        }
        
        return transTable;
    }
    
    protected LUT createColorLUT(ColorHistogram colors){
                
        LUT transTable = new LUT();
        
        for (Color c : colors.keySet())
            transTable.put(c, getColorVOut(c));
        
        return transTable;
    }
    
    /**
     * Given a grayscale value, return its corresponding new value.
     * This method will be implemented differently by extending classes,
     * leading to the different types of image transformations.
     * NOTE: Other needed parameters will be implicit and provided in
     * the Transformation's constructor.
     * @param vIn   Given color value
     * @return New color value that corresponds to the given one.
     */
    protected abstract int getVOut(int vIn);
    
    /**
     * Given a color, return its corresponding new color.
     * This should be overwritten if RGB transformation is not the same
     * as applying the grayscale transformation to each color channel.
     * @param c Input color
     * @return Output color.
     */
    protected abstract Color getColorVOut(Color c);
}
