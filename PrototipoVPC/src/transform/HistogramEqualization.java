package transform;

import gui.utils.NamedImage;


public abstract class HistogramEqualization extends AbstractImageTransformation{
   
    int bitsUsedToCodifyImage;
    int size;   // Number of pixels in image
    int M;
    
    // TODO: Mirar y corregir todo; solo son apuntes!!
    // The resulting image's histogram will be 'flat'.
    // The transformation for this is non-linear.
    
    public static int getVOut(int vIn, NamedImage img){
        
        // TODO: Esto permite que la clase sea estatica...
        // pero crear estas variables cada vez que se llama a getVOut
        // parece muy ineficiente.
        
        int bitsUsedToCodifyImage = 8;
        int size = img.getPixelCount();
        int M = (int) Math.pow(2, bitsUsedToCodifyImage);
        
        int vOut = 0;
        
        int covin = 0;
        System.out.println("For vIn = " + vIn);
        for (int i = 0; i < vIn; i++){
            System.out.println("For i = " + i);
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
