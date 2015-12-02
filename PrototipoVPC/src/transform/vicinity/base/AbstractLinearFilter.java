package transform.vicinity.base;

import java.awt.Color;
import java.awt.image.WritableRaster;

import gui.utils.image.NamedImage;
import transform.base.AbstractImageTransformation;

public abstract class AbstractLinearFilter extends AbstractImageTransformation{

    @Override
    public abstract NamedImage getTransformedImage(NamedImage img1);
    
    // superponer, multiplicar, sumar y asignar
    
    // TODO: Reescribir esta guarrada
    public NamedImage applyFilter(NamedImage img1, Kernel kernel){
        NamedImage img2 = img1.deepishCopy();
        
        if (!kernel.isValid()) System.err.println("Invalid Kernel");
        kernel = kernel.getNormalized();
        
        int imageWidth = img1.getWidth();
        int imageHeight = img1.getHeight();
        
        int kernelWidth = kernel.getWidth();
        int kernelHeight = kernel.getHeight();
        int kernelHalfWidth = kernel.getWidth() / 2;
        int kernelHalfHeight = kernel.getHeight() / 2;
        
        // Each pixel of the image will act as the kernel's pivot.
        for (int pivJ = 0; pivJ < imageHeight; pivJ++){
            for (int pivI = 0; pivI < imageWidth; pivI++){
                
                // Using kernel center as pivot, visit each kernel pixel.
                for (int kerJ = 0; kerJ <= kernelHeight; kerJ++ ){
                    
                    // Translate to real image pixel position
                    int imgJ = pivJ + (kerJ - kernelHalfHeight);
                    // Skip kernel columns outside the image.
                    if (img1.outOfBounds(0, imgJ)) continue;
                    
                    for (int kerI = 0; kerI < kernelWidth; kerI++){
                        
                        // Translate to real image pixel position
                        int imgI = (kerI - kernelHalfWidth);
                        // Skip kernel rows outside the image.
                        if (img1.outOfBounds(imgI, imgJ)) continue;
                        
                        if (img1.isGrayscale()){
                            int img1Gray = 0, img2Gray = 0;
                            try {
                                img1Gray = img1.getPixelColor(imgI, imgJ).getBlue();
                                img2Gray = img2.getPixelColor(imgI, imgJ).getBlue();
                            } catch (Exception e) {
                                e.printStackTrace(System.err);
                            }
                            System.out.println(String.format("pixI= %d, pixJ= %d", imgI, imgJ));
                            int newGray = (int)(img1Gray * kernel.get(imgI, imgJ)) + img2Gray;
                            Color newColor = new Color(newGray, newGray, newGray);
                            
                            img2.setRGB(imgI, imgJ, newColor.getRGB());
                        } else {
                            System.err.println("Filtros lineales para color aun no implementados.");
                        }
                    }
                }
            }
        }
        
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
