package gui_utils;

import java.awt.image.BufferedImage;
import java.io.File;

public class NamedImage extends BufferedImage {
    private File file;
    
    public NamedImage(BufferedImage bi, File file){
        super(bi.getColorModel(), bi.getRaster(), bi.getColorModel().isAlphaPremultiplied(), null);
        this.file = file;
    }
    
    /*
     * Interfaces con el File.
     */
    
    public String getName(){
        return file.getName();
    }
}