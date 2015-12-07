package transform2;

import java.awt.Dimension;
import java.awt.Point;

import gui.utils.image.NamedImage;

public abstract class Scale {
    
    float xScale, yScale;
    
    public Scale(float xScale, float yScale){
        setScale(xScale, yScale);
    }
    
    public Scale(int img2x, int img2y, NamedImage img1){
        float xScale = img2x / img1.getWidth();
        float yScale = img2y / img1.getHeight();
        setScale(xScale, yScale);
    }
    
    private void setScale(float xScale, float yScale){
        this.xScale = xScale;
        this.yScale = yScale;
    }
    
    public NamedImage scaleImage(NamedImage img1){

        // Determinar tamaño de la nueva imagen
        Dimension d2 = scaleDimension(img1.getWidth(), img1.getHeight());
        
        return img1;
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
    abstract public Point map(int img1x, int img1y);
}
