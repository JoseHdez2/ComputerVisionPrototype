package transform.point;

import java.awt.Color;
import java.util.HashMap;

import gui.utils.image.NamedImage;
import transform.point.base.ThreeChannelAIPT;

public class HistogramSpecification extends ThreeChannelAIPT{
    
    HashMap<Color,Integer> desiredHistogram;
    
    HashMap<Integer,Integer> accHOriginal = null;
    HashMap<Integer,Integer> accHReference = null;
    
    int originalSize = 0;
    int referenceSize = 0;
    
    
    public HistogramSpecification(NamedImage img1, NamedImage img2) {
        
        originalSize= img1.getWidth()*img1.getHeight();
        referenceSize = img2.getWidth()*img2.getHeight();
        
        accHOriginal = img1.getPixelColorCount().getAccumulative().getColorToInteger();
        accHReference = img2.getPixelColorCount().getAccumulative().getColorToInteger();
    }
    
    public HistogramSpecification(HashMap<Color,Integer> desiredHistogram){
        this.desiredHistogram = desiredHistogram;
    }
    
    // |Co(Vin) - Co(Vout)| sea minimo
    // PONER EN CORRESPONDENCIA los histogramas acumulativos.

    //final int PRACTICALLY_INFINITY = Integer.MAX_VALUE;
    
    protected void bleble(){
//        HashMap<Color, Integer> accumulativeDesiredHistogram = desiredHistogram.getAccumulative();
//        HashMap<Color, Integer> oldHistogram;
//        
//        accumulativeDesiredHistogram = accumulativeDesiredHistogram.getNormalized();
//        oldHistogram = oldHistogram.getNormalized();
//        
//
//        int nearestMatch = 0;
//        int nearestMatchValue = Integer.MAX_VALUE;
//        for (int i = 0; i < 255; i++){
//            for (int j = 0; j < 255; j++){
//                int thisMatchValue = Math.abs(accumulativeDesiredHistogram.get(i) - oldHistogram.get(i));
//                // TODO < or <= ? Biased towards lowest value! Significant?
//                if (thisMatchValue < nearestMatchValue){
//                    nearestMatch = j;
//                    nearestMatchValue = thisMatchValue;
//                }
//            }
//        }
        
    }
    
    // Problema: Las dos escalas (de ambos histogramas) deben ser (casi) iguales!
    // Solucion: Histograma acumulativo NORMALIZADO. Se obtiene dividiendo entre el SIZE de la imagen.
    @Override
    protected int getVOut(int vIn) {

        int vOut = vIn;
        int j = 255;
        
        while ((j >= 0) && (((float)accHOriginal.get(vIn)/originalSize) <= ((float)accHReference.get(j)/referenceSize))) {
            vOut = j;
            j -= 1;
        }
        
        return vOut;
    }
    
}
