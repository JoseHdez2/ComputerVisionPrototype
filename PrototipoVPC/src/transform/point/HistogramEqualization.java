package transform.point;

import java.awt.Color;

import gui.utils.image.ColorHistogram;
import gui.utils.image.NamedImage;
import transform.point.base.AbstractImagePointTransformation;


// TODO: Cargarnos esto? Que la ecualizacion sea una llamada parametrizada a especificacion.

/**
 * Caso particular de especificacion de histograma,
 * en el que queremos que el histograma se asemeje al histograma plano.
 *
 */
public class HistogramEqualization extends AbstractImagePointTransformation{
    
    int bitsUsedToCodifyImage;
    int size;   // Number of pixels in image
    int M;
    ColorHistogram accumulativeHistogram;
    
    public HistogramEqualization(NamedImage img) {
        bitsUsedToCodifyImage = 8; //TODO: esto se usa?
        size = img.getPixelCount();
        M = (int) Math.pow(2, bitsUsedToCodifyImage);
        accumulativeHistogram = img.getPixelColorCount().getAccumulative();
    }
    
    // TODO: esta para imagenes en blanco y negro
    
    @Override
    protected int getVOut(int vIn) {

        Integer coVin = accumulativeHistogram.get(new Color(vIn,vIn,vIn));
        System.out.println(String.format("coVin[%d]=%d", vIn, coVin));
        
        int vOut = Math.round(((M / size) * coVin)) - 1;
        
        if (vOut < 0) vOut = 0;
        
        return vOut;
    }
}
