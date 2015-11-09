package transform;

import java.awt.image.BufferedImage;
import java.io.File;

import gui.utils.NamedImage;

public class ImageDifference {

    // devuelve mapa de cambios, las diferencias entre dos imagenes.
    
    public NamedImage getDiff(NamedImage img1, NamedImage img2){
        // diferencia (valor absoluto)
        // TODO: esa linea peta
        return new NamedImage(new BufferedImage(0,0,0), new File("buf cuidado"));
    }
    
}
