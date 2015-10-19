package gui.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class NamedImage extends BufferedImage {
    private File file;
    private HashMap<Color, Integer> pixelColorCount = new HashMap<Color, Integer>();
    private Boolean validColorCount = false;    // So that we only count pixels if needed.
    
    public NamedImage(BufferedImage bi, File file){
        super(bi.getColorModel(), bi.getRaster(), bi.getColorModel().isAlphaPremultiplied(), null);
        this.file = file;
    }
    
    /**
     * Returns the total number of pixels this image has. 
     * (this.getWidth() * this.getHeight() synonym)
     * @return  Number of pixels this image has.
     */
    public int getPixelCount(){
        // TODO seguro que getWidth() y getHeight() devuelven numero de pixeles nativos?? o de display?
        return this.getWidth() * this.getHeight();
    }
    
    /*
     * Interfaces con el File.
     */
    
    public String getName(){
        return file.getName();
    }
    
    public File getFile() {
        return file;
    }

    /**
     * Provides lazy evaluation simulation.
     * @return Number of pixels for each color in the image.
     */
    public HashMap<Color, Integer> getPixelColorCount() {
        if(!validColorCount){
            countPixelsByColor();
        }
        return pixelColorCount;
    }
    
    /**
     * Count number of pixels for each color in the image.
     * Store the result in the internal pixelColorCount hash.
     * This costly operation is only called from getPixelColorCount(),
     * (when the pixelColorCount is needed) simulating lazy evaluation.
     */
    private void countPixelsByColor(){
        
        // TODO: Asegurarnos que BufferedImage nunca presenta informacion de conteo de colores falsa.

        pixelColorCount.clear();
        
        int imageWidth = this.getWidth();
        int imageHeight = this.getHeight();
        
        for (int i = 0; i < imageWidth; i++){
            for (int j = 0; j < imageHeight; j++){
                // TODO: Demasiado ineficiente crear un Color cada vez?
                Color pixelColor = new Color(this.getRGB(i, j));
                if(!pixelColorCount.containsKey(pixelColor)){
                    pixelColorCount.put(pixelColor, 1);
                } else {
                    pixelColorCount.put(pixelColor, pixelColorCount.get(pixelColor) + 1);
                }
            }
        }
        
        validColorCount = true;
    }
}