package transform;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map.Entry;

import gui.utils.NamedImage;

public abstract class BrightnessAndContrast {
    
    static public float Brightness(NamedImage img) {
        
        HashMap<Integer, Integer> h = img.getPixelColorCount().getColorToInteger();
        int sum = 0;
        
        for(Entry<Integer,Integer> entry : h.entrySet()) {
            sum += entry.getValue() * entry.getKey();
        }
//        System.out.println((int)Math.round(a));   Output format like rounded int
        return (float)(sum/img.getPixelCount());
    }
    
    static public float Contrast(NamedImage img) {
        
        // TODO: no devuelve el valor correcto! corregir...
        
        HashMap<Integer, Integer> h = img.getPixelColorCount().getColorToInteger();
        int sum = 0;
        float brightness = img.getBrigthness(); 
        
        for(Entry<Integer,Integer> entry : h.entrySet()) {
            sum += entry.getValue() * Math.pow(entry.getKey() - brightness, 2);
        }
        
        float sum2 = (float)(sum/img.getPixelCount());
        return (float)(Math.sqrt(sum2/256));
    }    
    
 // TODO: Mirar y corregir todo; solo son apuntes!!
    // TODO: Only works for grayscale images.
    public void setBrightness(BufferedImage img, int newBrightness, int newContrast){
        int oldBrightness = 0;
        int oldContrast = 0;
        
        float A = newBrightness / oldBrightness;
        float B = newContrast - A * oldContrast;
        
        HashMap<Integer, Integer> tabla = new HashMap<Integer, Integer>();
        
        for (int vIn = 0; vIn < 255; vIn++){
            
            int vOut = (int)(A * vIn + B);
            
            // Handle out-of-range values.
            if (vOut < 0){
                vOut = 0;
                // TODO: register biggest value that gets this, if any.
            }
            if (vOut > 255){
                vOut = 255;
                // TODO: register biggest value that gets this, if any.  
            }
            // TODO: When there are out-of-range vOut values, we are giving a false result.
            
            tabla.put(vIn, vOut);
        }
        
        // Cuantos valores distintos da la tabla
        // Siempre seran igual o menos
    }
}
