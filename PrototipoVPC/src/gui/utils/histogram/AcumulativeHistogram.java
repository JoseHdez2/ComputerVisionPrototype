package gui.utils.histogram;

import java.util.ArrayList;
import java.util.HashMap;

import gui.utils.NamedImage;
import i18n.GUIStr;
import i18n.I18n;

public class AcumulativeHistogram extends AbstractHistogram {

    public AcumulativeHistogram(NamedImage image) {
        super(I18n.getString(GUIStr.ANALYZE_MENU_ACUMULATIVE_HISTOGRAM), image.getName());
        
        ArrayList pixelArray = getPixelArray(image);
        this.showHistogram(pixelArray);
    }
    
    /**
     * Devuelve un vector ordenado con los píxeles a partir
     * del conteo de pixeles de colores de la imagen
     * @return  el vector ordenado del nº pixeles/color
     */ 
    private ArrayList getPixelArray(NamedImage image) {
        
        ArrayList pixelArray = new ArrayList();
        HashMap<Integer, Integer> pixelIntegerCount = this.getColorToInteger(image.getPixelColorCount());
        int total = 0;
        
        for (int i=0; i<=255; i++) {
            
            Integer pixel = pixelIntegerCount.get(i);
            
            if (pixel != null) {
                pixelArray.add(pixel + total);
                total += pixel;                
            }
            else {
                pixelArray.add(0);
            }
        }
        
        return pixelArray;
    }

}
