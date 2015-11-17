package gui.utils.image;

import java.util.HashMap;
import java.util.Map.Entry;

public abstract class Entropy {
    
    /**
     * Calculate entropy for passed image
     * @return entropy in float
     */
    static public float calculate(NamedImage img) {
        
        HashMap<Integer, Integer> h = img.getPixelColorCount().getColorToInteger();
        float entropy = 0;
        
        for(Entry<Integer,Integer> entry : h.entrySet()) {            
            float p = (float) entry.getValue() / img.getPixelCount();
            entropy -= p * (Math.log(p) / Math.log(2));
        }
        
        return entropy;
    }

}