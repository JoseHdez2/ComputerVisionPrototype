package gui.utils.image;

import java.util.HashMap;
import java.util.Map.Entry;

public class BrightnessAndContrast {
    
    boolean outdatedBrightness;
    boolean outdatedContrast;
    
    float brightness;
    float contrast;
    
    public BrightnessAndContrast() {
        outdatedBrightness = true;
        outdatedContrast = true;
    }
    
    public float getBrightness(NamedImage img){
        if (outdatedBrightness){
            brightness = calculateBrightness(img);
        }
        return brightness;
    }
    
    public float getContrast(NamedImage img){
        if (outdatedContrast){
            contrast = calculateContrast(img);
        }
        return contrast;
    }
    
    private float calculateBrightness(NamedImage img) {
        
        outdatedBrightness = false;
        HashMap<Integer, Integer> h = img.getPixelColorCount().getColorToInteger();
        float sum = 0;
        
        for(Entry<Integer,Integer> entry : h.entrySet()) {
            sum += entry.getValue() * entry.getKey();
        }

        return (sum/img.getPixelCount());
    }
    
    private float calculateContrast(NamedImage img) {
        
        outdatedContrast = false;
        HashMap<Integer, Integer> h = img.getPixelColorCount().getColorToInteger();
        float sum = 0;
        float brightness = img.getBrightness(); 
        
        for(Entry<Integer,Integer> entry : h.entrySet()) {
            sum += entry.getValue() * Math.pow(entry.getKey() - brightness, 2);
        }
        
        sum /= img.getPixelCount();

        return (float)(Math.sqrt(sum));
    }    
}
