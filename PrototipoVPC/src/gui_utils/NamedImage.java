package gui_utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class NamedImage extends BufferedImage {
    private File file;
    private HashMap<Color, Integer> pixelColorCount = null;
    private Boolean needColorRecount;
    
    public NamedImage(BufferedImage bi, File file){
        super(bi.getColorModel(), bi.getRaster(), bi.getColorModel().isAlphaPremultiplied(), null);
        this.file = file;
    }
    
    /**
     * Count pixels for each color in the image. Store the result in the internal pixelColorCount hash. 
     */
    public void countPixels(){
        
        // TODO: Asegurarnos que BufferedImage nunca presenta informacion de conteo de colores falsa.
        if (pixelColorCount != null) return;
        
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
}