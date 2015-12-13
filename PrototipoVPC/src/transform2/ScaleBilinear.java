package transform2;

import java.awt.Color;

import gui.utils.image.NamedImage;
import transform2.base.Scale;

public class ScaleBilinear extends Scale {
    // 
    // P = R + (Q-R)q
    
    public ScaleBilinear(NamedImage img, float xScale, float yScale) {
        super(img, xScale, yScale);
    }
    
    public ScaleBilinear(NamedImage img, int img2x, int img2y) {
        super(img, img2x, img2y);
    }
    
    
    protected NamedImage getCorrespondingImage(NamedImage img) {
        return scaleImage(img);
    }
    
    protected Color getCorrespondingPixel(int x, int y) {
        
        // Coordenadas
        float cx = (x/xScale);
        float cy = (y/yScale);
           
        // A,B,C,D
        int a = image.getValueRGB((int)Math.floor(cx), (int)Math.ceil(cy), 0);
        int b = image.getValueRGB((int)Math.ceil(cx), (int)Math.ceil(cy), 0);
        int c = image.getValueRGB((int)Math.floor(cx), (int)Math.ceil(cy), 0);
        int d = image.getValueRGB((int)Math.ceil(cx), (int)Math.ceil(cy), 0);
        
        // Constantes p y q
        float p = (float)(cx - Math.floor(cx));
        float q = (float)(cy - Math.floor(cy));
        
        int color = (int)(c + (d-c)*p + (a-c)*q + (b+c+-a-d)*p*q);
        
        // Only grayscale
        return new Color(color,color,color);
    }

}