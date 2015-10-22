package gui.utils.histogram;

import java.util.ArrayList;
import java.util.HashMap;

import gui.utils.ColorHistogram;
import gui.utils.NamedImage;
import i18n.GUIStr;
import i18n.I18n;

public class AccumulativeHistogram extends AbstractHistogram {

    public AccumulativeHistogram(NamedImage image) {
        super(I18n.getString(GUIStr.ANALYZE_MENU_ACCUMULATIVE_HISTOGRAM), image.getName());
        
        ArrayList<Integer> pixelArray = getPixelArray(image);
        this.showHistogram(pixelArray);
    }
    
    /**
     * Devuelve un vector ordenado con los píxeles a partir
     * del conteo de pixeles de colores de la imagen
     * @return  el vector ordenado del nº pixeles/color
     */ 
    private ArrayList<Integer> getPixelArray(NamedImage image) {
        
        ArrayList<Integer> pixelArray= new ArrayList<Integer>();
        ColorHistogram accHistogram = image.getPixelColorCount().getAccumulative();
        HashMap<Integer, Integer> pixelIntegerCount = accHistogram.getColorToInteger();

        for (int i=0; i<=255; i++) {
            pixelArray.add(pixelIntegerCount.get(i));
        }
        
        return pixelArray;
    }
}