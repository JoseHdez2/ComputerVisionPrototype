package transform.vicinity.base;

import java.awt.image.BufferedImage;
import java.io.File;

import gui.utils.image.NamedImage;
import transform.base.AbstractImageTransformation;

public abstract class AbstractLinearFilter extends AbstractImageTransformation{

    

    @Override
    public NamedImage getTransformedImage(NamedImage img1) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    // superponer, multiplicar, sumar y asignar
    
    
    public NamedImage applyFilter(NamedImage img1){
        // TODO: peligro; linea falsa.
        Kernel kernel = createKernel();
        NamedImage img2 = new NamedImage(new BufferedImage(0,0,0), new File("wepa"));
        return img2;
    }

    
    protected abstract Kernel createKernel();
    
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
