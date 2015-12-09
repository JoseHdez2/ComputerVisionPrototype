package transform2;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Rotation {
    
    void unaFuncion(){
        
        // Los vertices del paralelograma que representa la imagen rotada.
        ArrayList<Point> boundingParallelogramPoints = new ArrayList<Point>();
        
        // Conseguimos los valores minimos y maximos de las coordenadas del paralelograma.
        // Esto es para crear el rectangulo que engloba a dicho paralelograma.
        int minX = Integer.MAX_VALUE, maxX = 0; // Obtendremos el pto. superior izquierdo del rectangulo.
        int minY = Integer.MAX_VALUE, maxY = 0; // Obtendremos el pto. inferior derecho del rectangulo.
        
        for (Point p : boundingParallelogramPoints){
            if (p.x < minX) minX = p.x;
            if (p.x > maxX) maxX = p.x;
            if (p.y < minY) minY = p.y;
            if (p.y > maxY) maxY = p.y;
        }
        
        // Habiendo calculado las coordenadas, creamos el rectangulo que engloba al paralelograma.
        Rectangle r = new Rectangle(new Point(minX, minY), new Dimension(maxX, maxY));
    }
}
