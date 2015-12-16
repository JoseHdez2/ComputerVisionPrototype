package transform2.base;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gui.utils.image.NamedImage;


public abstract class AbstractRotation extends CoordinatesTransform {

    protected NamedImage image = null;
    protected double angle;
    protected MyPoint traslationCoords = null;
    // Los vertices del paralelograma que representa la imagen rotada.
    ArrayList<MyPoint> parallelogramPoints = new ArrayList<MyPoint>();
    
    public AbstractRotation(NamedImage img, double angle) {
        image = img;
        this.angle = angle;
        
        parallelogramPoints.add(directTransform(0,0));
        parallelogramPoints.add(directTransform(image.getWidth()-1,0));
        parallelogramPoints.add(directTransform(image.getWidth()-1,image.getHeight()-1));
        parallelogramPoints.add(directTransform(0,image.getHeight()-1));
    }
    
    protected NamedImage getCorrespondingImage(NamedImage img1) {
        
        double minX = Double.MAX_VALUE, maxX = 0; // Obtendremos el pto. superior izquierdo del rectangulo.
        double minY = Double.MAX_VALUE, maxY = 0; // Obtendremos el pto. inferior derecho del rectangulo.
        
        for (MyPoint p : parallelogramPoints){
            if (p.x < minX) minX = p.x;
            if (p.x > maxX) maxX = p.x;
            if (p.y < minY) minY = p.y;
            if (p.y > maxY) maxY = p.y;
        }

        traslationCoords = new MyPoint((int)minX, (int)minY);
        
        // Crear nueva imagen
        BufferedImage bi = new BufferedImage((int)(Math.abs(maxX-minX+1)), (int)(Math.abs(maxY-minY+1)), img1.getType());
        NamedImage img2 = new NamedImage(bi, img1.getFile());
        
        return img2;
    }
    
    /**
     * Direct transformation to get corresponding position of x and y
     * @param x
     * @param y
     * @return Point
     */
    protected MyPoint directTransform(int x, int y) {
        return new MyPoint(x * Math.cos(angle) - y * Math.sin(angle),
                        x * Math.sin(angle) + y * Math.cos(angle));
    }
    
    /**
     * Indirect transformation to get original position of x and y
     * @param x
     * @param y
     * @return Point
     */
    protected MyPoint indirectTransform(int x, int y) {
        return new MyPoint(x * Math.cos(angle) + y * Math.sin(angle),
                        -x * Math.sin(angle) + y * Math.cos(angle));
    }
}
