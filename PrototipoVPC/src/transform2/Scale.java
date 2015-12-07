package transform2;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;

import gui.utils.image.NamedImage;
import transform2.base.CoordinatesTransform;

public abstract class Scale extends CoordinatesTransform {
    
    NamedImage image = null;    // Imagen Original
    float xScale, yScale;
    
    public Scale(NamedImage img, float xScale, float yScale){
        image = img;
        setScale(xScale, yScale);
    }
    
    public Scale(NamedImage img, int img2x, int img2y){
        image = img;
        float xScale = img2x / img.getWidth();
        float yScale = img2y / img.getHeight();
        setScale(xScale, yScale);
    }
    
    private void setScale(float xScale, float yScale){
        this.xScale = xScale;
        this.yScale = yScale;
    }
    
    public NamedImage scaleImage(NamedImage img1){

        // Determinar tamaño de la nueva imagen
        Dimension d2 = scaleDimension(img1.getWidth(), img1.getHeight());
        
        BufferedImage bi = new BufferedImage(d2.width, d2.height, img1.getType());
        NamedImage img2 = new NamedImage(bi, img1.getFile());
        
        return img2;
    }
    
    /**
     * @param img1x
     * @param img1y
     * @return  (Image2's) Dimension after scaling Image1.
     */
    public Dimension scaleDimension(int img1x, int img1y){
        return new Dimension((int)this.xScale * img1x, (int)this.yScale * img1y);
    }
    
    /**
     * @param img1x
     * @param img1y
     * @return  Corresponding point in img2.
     */
    //abstract public Point map(int img1x, int img1y);
}
