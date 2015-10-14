package processing.grayscale;

import java.util.HashMap;


public class ImageTransform {
    
    // TODO: Mirar y corregir todo; solo son apuntes!!
    // The resulting image's histogram will be 'flat'.
    // The transformation for this is non-linear.
    public void equalizeHistogram(){
        
        int bitsUsedToCodifyImage = 8;
        int size = 0; // Number of pixels in image
        int M = (int) Math.pow(2, bitsUsedToCodifyImage);
        
        HashMap<Integer, Integer> tabla = new HashMap<Integer, Integer>();
        
        for (int vIn = 0; vIn < 255; vIn++){
            
            int vOut = 0;
            
            int covin = 0;
            for (int i = 0; i < vIn; i++){
                // covin += hist[i];
            }
            
            vOut = Math.round(((M / size) * covin)) - 1;
            
            if (vOut < 0) vOut = 0;
            
            tabla.put(vIn, vOut);
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
}
