package transform;

import java.awt.Color;
import java.util.HashMap;

import transform.base.AbstractImagePointTransformation;

public class HistogramSpecification extends AbstractImagePointTransformation{
    
    HashMap<Color,Integer> desiredHistogram;
    
    public HistogramSpecification(HashMap<Color,Integer> desiredHistogram){
        this.desiredHistogram = desiredHistogram;
    }
    
    // |Co(Vin) - Co(Vout)| sea minimo
    // PONER EN CORRESPONDENCIA los histogramas acumulativos.

    final int PRACTICALLY_INFINITY = Integer.MAX_VALUE;
    
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

        

        
        // TODO Auto-generated method stub
        return 0;
    }
    
}
