package transform;

import gui.utils.image.NamedImage;
import transform.base.AbstractImagePointTransformation;


public class HistogramEqualization extends AbstractImagePointTransformation{
   
    // Caso particular de especificacion de histograma
    // En cuyo caso queremos que el histograma se asemeje a un histograma plano.
    // TODO: Cargarnos esto? Que la ecualizacion sea una llamada parametrizada a especificacion.
    
    int bitsUsedToCodifyImage;
    int size;   // Number of pixels in image
    int M;
    
    public HistogramEqualization(NamedImage img) {
        bitsUsedToCodifyImage = 8;
        size = img.getPixelCount();
        M = (int) Math.pow(2, bitsUsedToCodifyImage);
        // TODO Auto-generated constructor stub
    }
    
    // TODO: Mirar y corregir todo; solo son apuntes!!
    // The resulting image's histogram will be 'flat'.
    // The transformation for this is non-linear.
    
    @Override
    protected int getVOut(int vIn) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    public static int getVOut(int vIn, NamedImage img){
        
        // TODO: Esto permite que la clase sea estatica...
        // pero crear estas variables cada vez que se llama a getVOut
        // parece muy ineficiente.
        

        
        int vOut = 0;
        
        int covin = 0;
        System.out.println("For vIn = " + vIn);
        for (int i = 0; i < vIn; i++){
            System.out.println("For i = " + i);
            covin += img.getPixelColorCount().get(i);
        }
        
//        vOut = Math.round(((M / size) * covin)) - 1;
        
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
