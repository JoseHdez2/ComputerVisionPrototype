package gui.utils.image;

import java.awt.Color;
import java.util.HashMap;

public class ColorHistogram extends HashMap<Color, Integer> {
    
    /**
     * @return Accumulative histogram version of itself.
     */
    public ColorHistogram getAccumulative(){
        // TODO: Assumes grayscale histogram.
        
        ColorHistogram accHistogram = new ColorHistogram();
        
        Integer pixelsBelowOrEqualToThisColor = 0;
        for (int i = 0; i <= 255; i++){
            Color color = new Color(0,0,i);   // modo raro
//            Color color = new Color(i,i,i); // modo normal
            if (get(color) != null) {
                pixelsBelowOrEqualToThisColor += get(color);
            }    
//            accHistogram.put(color, pixelsBelowOrEqualToThisColor); // modo normal
            accHistogram.put(new Color(i,i,i), pixelsBelowOrEqualToThisColor); // modo correccion raro
        }
        
        return accHistogram;
    }
    
    public NormalizedColorHistogram getNormalized(){
        NormalizedColorHistogram normHistogram = new NormalizedColorHistogram();
        
        int size = getTotalPixelCount();
        
        for (int i = 0; i < 255; i++){
            // TODO: does this division turn float results into int? (does cast work?)
            normHistogram.put(new Color(i,i,i), (float) (get(new Color(i,i,i))/size));
        }
        
        return normHistogram;
    }
    
    /**
     * @return Total number of pixels this histogram counts.
     */
    public int getTotalPixelCount(){
        
        int totalPixelCount = 0;
        
        for (int pixelColorCount : this.values()){
            totalPixelCount += pixelColorCount;
        }
        
        return totalPixelCount;
    }
    
    /**
     * La cuenta de píxeles está ordenada por colores desordenados,
     * es necesario pasarlos a enteros (0..255) para mostrarlos ordenados
     * @return  Número de píxeles entre 0 y 255
     */    
    public HashMap<Integer, Integer> getColorToInteger() {
        // TODO: provisional para imágenes en blanco y negro
        
        HashMap<Integer, Integer> pixelIntegerCount = new HashMap<Integer,Integer>();
        
        for (Entry<Color, Integer> entry : this.entrySet()) {
            Color key = entry.getKey();
            Integer value = entry.getValue();
            
            pixelIntegerCount.put(key.getBlue(), value);  // Importante valor B al utilizar Raster!!!  
        }
        
        return pixelIntegerCount;
    }
}
