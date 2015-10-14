package processing.grayscale;

import gui_utils.NamedImage;

import java.awt.image.BufferedImage;


public class HistogramEqualization extends AbstractImageTransformation{
   
    int bitsUsedToCodifyImage;
    int size;   // Number of pixels in image
    int M;
    
    @Override
    public void transform(NamedImage img){

        // TODO: Calculate bitsUsedToCodifyImage correctly.
        bitsUsedToCodifyImage = 8;
        size = img.getPixelCount();
        M = (int) Math.pow(2, bitsUsedToCodifyImage);
        
        super.transform(img);
    }
    
    // TODO: Mirar y corregir todo; solo son apuntes!!
    // The resulting image's histogram will be 'flat'.
    // The transformation for this is non-linear.
    
    public int getVOut(int vIn, NamedImage img){
        
        int vOut = 0;
        
        int covin = 0;
        for (int i = 0; i < vIn; i++){
           covin += img.getPixelColorCount().get(i);
        }
        
        vOut = Math.round(((M / size) * covin)) - 1;
        
        if (vOut < 0) vOut = 0;
        
        return vOut;
        
    }
        // Donde intuimos que hace mas falta la distancia para ver mejor.
        // (Donde hay mas pixeles, separa mas)
        // Ecualizado decide donde separa mas y donde junta.
        // Siempre sin excederse del limite total (rango de colores)
        // Mejora del contraste inteligente. Esta es la gran utilidad del ecualizado.
        // En TEORIA da un histograma plano... lo conseguiria si el color fuese una variable discreta.
        
        // Como TODOS los de un color seran a otro COLOR.. 
        // si hay picos que sobrepasan el nivel de ecualizado, yo no puedo cambiar

}
