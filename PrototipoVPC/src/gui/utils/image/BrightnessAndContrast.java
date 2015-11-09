package gui.utils.image;

import java.util.HashMap;
import java.util.Map.Entry;

public class BrightnessAndContrast {
    
    boolean outdatedBrightness;
    boolean outdatedContrast;
    
    float brightness;
    float contrast;
    
    public float getBrightness(NamedImage img){
        if (outdatedBrightness){
            calculateBrightness(img);
        }
        return brightness;
    }
    
    public float getContrast(NamedImage img){
        if (outdatedContrast){
            calculateContrast(img);
        }
        return contrast;
    }
    
    private float calculateBrightness(NamedImage img) {
        
        HashMap<Integer, Integer> h = img.getPixelColorCount().getColorToInteger();
        int sum = 0;
        
        for(Entry<Integer,Integer> entry : h.entrySet()) {
            sum += entry.getValue() * entry.getKey();
        }
//        System.out.println((int)Math.round(a));   Output format like rounded int
        return (float)(sum/img.getPixelCount());
    }
    
    private float calculateContrast(NamedImage img) {
        
        // TODO: no devuelve el valor correcto! corregir...
        
        HashMap<Integer, Integer> h = img.getPixelColorCount().getColorToInteger();
        int sum = 0;
        float brightness = img.getBrigthness(); 
        
        for(Entry<Integer,Integer> entry : h.entrySet()) {
            sum += entry.getValue() * Math.pow(entry.getKey() - brightness, 2);
        }
        
        float sum2 = (float)(sum/img.getPixelCount());
//      return (float)(Math.sqrt(sum2/256)); TODO: en la formula se utiliza 1/N
        return (float)(Math.sqrt(sum2));
    }    
}
