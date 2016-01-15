package transform.point;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import transform.point.base.LUT;
import transform.point.base.ThreeChannelAIPT;
import util.Sys;

public class PiecewiseLinearTransformation extends ThreeChannelAIPT {

    HashMap<Integer, Integer> myLUT = new HashMap<Integer, Integer>();
    
    // TODO: hecho para imagenes en blanco y negro
    
    public PiecewiseLinearTransformation(ArrayList<Point> points) throws Exception{

        checkArguments(points);
        
        int p = 0;  // Indice de puntos.
        int min = 0, max = 0, H = 0, L = 0;
        
        // Para cada color...
        for (int i = 0; i < 255; i++){
            
            // Nos movemos buscando el tramo que cubre a este color
            // (Es decir, nos cambiamos a una nuevo tramo si hace falta)
            while (i > points.get(p).x){
                p++;
                min = points.get(p).x;
            }
            
            int A = (H - L) / (max - min);
            int B = L - A * min;
            
            // Una vez determinado el color correspondiente para este color, guardarlo en la LUT interna.
            // TODO: hacerlo
            // myLUT[i] = ???
        }
    }
    
    protected void checkArguments(ArrayList<Point> points) throws Exception{
        for (Point p : points){
            if (p.x < 0 || p.x > 255 || p.y < 0 || p.y > 255)
                Sys.exception("Point in piecewise out of bounds: %s", p);
        }
        
        for (int i = 0; i < points.size(); i++){
            if (i == 0) continue;
            if (points.get(i).x < points.get(i-1).x){
                Sys.exception("Points not in order or overlapping: p1=%s p2=%s", points.get(i-1), points.get(i));
            }
        }
    }
    
    @Override
    protected int getVOut(int vIn) {
        return myLUT.get(vIn);
    }

}
