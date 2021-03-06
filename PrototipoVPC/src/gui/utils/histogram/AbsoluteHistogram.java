package gui.utils.histogram;

import java.util.ArrayList;
import java.util.HashMap;

import gui.utils.image.NamedImage;
import i18n.I18n;

public class AbsoluteHistogram extends AbstractHistogram {

    public AbsoluteHistogram(NamedImage image) {
        super(I18n.getString("AnalyzeMenu.AbsoluteHistogram"), image.getName());
        
        ArrayList<Integer> pixelArray = getPixelArray(image);
        this.showHistogram(pixelArray);
    }
    
    /**
     * Devuelve un vector ordenado con los píxeles a partir
     * del conteo de pixeles de colores de la imagen
     * @return  el vector ordenado del nº pixeles/color
     */ 
    private ArrayList<Integer> getPixelArray(NamedImage image) {
        
        ArrayList<Integer> pixelArray = new ArrayList<Integer>();
        HashMap<Integer, Integer> pixelIntegerCount = image.getPixelColorCount().getColorToInteger();
        
        for (int i=0; i<=255; i++) {
            
            Integer pixel = pixelIntegerCount.get(i);
            
            if (pixel != null)
                pixelArray.add(pixel);
            else
                pixelArray.add(0);
        }
        
        return pixelArray;
    }

}
