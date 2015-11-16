package transform.vicinity;

import java.awt.image.BufferedImage;
import java.io.File;

import gui.utils.image.NamedImage;

public class AbstractLinearFilter {
    
    private Kernel createKernel(){
        return new Kernel();
    }
    
    public NamedImage applyFilter(NamedImage img1){
        // TODO: peligro; linea falsa.
        NamedImage img2 = new NamedImage(new BufferedImage(0,0,0), new File("wepa"));
        return img2;
    }
    
    /*
     * pillar imagen
     * 
     * para cada pixel (hot spot) de la imagen1, 
     * 
     * centrar el filtro sobre el pixel
     * hacer la media de cada pixel del filtro que superpone al pixel de la imagen1.
     * 
     * se obtiene la imagen2.
     * 
     * 
     * ---
     * 
     * para trabajar con numeros enteros en los pesos en vez de floats,
     * 
     *  usamos un factor de escala, que sera la inversa de la suma de los pesos 
     *  (basicamente, normalizar.)
     *  
     *  que caracteriza a un filtro? la forma, el tamaño y los pesos.
     *  
     *  ---
     *  
     *  sirve para atenuar el ruido
     *  
     *  lo malo es que atenua todo: el ruido y lo que no es.
     */
}
