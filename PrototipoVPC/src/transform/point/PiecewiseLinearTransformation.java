package transform.point;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import transform.point.base.ThreeChannelAIPT;
import util.Sys;

public class PiecewiseLinearTransformation extends ThreeChannelAIPT {

    HashMap<Integer, Integer> myLUT = new HashMap<Integer, Integer>();
    
    int xLo, xHi, yHi, yLo; 
    float A, B;
    // TODO: hecho para imagenes en blanco y negro
    
    public PiecewiseLinearTransformation(ArrayList<Point> points) throws Exception{

        checkArguments(points);
        
        Point leftPoint = points.get(0);
        Point rightPoint = points.get(1);
        
        recalculateTramo(leftPoint, rightPoint);
        
        // Para cada color...
        for (int i = 0; i <= 255; i++){
            
            // Si nos pasamos del punto a la derecha, lo colocamos como izquierda y buscamos el siguiente a la derecha.
            // Como entramos a un nuevo tramo, recalculamos.
            if (i > rightPoint.x) {
                leftPoint = rightPoint;
                rightPoint = points.get(points.indexOf(rightPoint) + 1);
                recalculateTramo(leftPoint, rightPoint);
            }
            
            // Una vez determinado el color correspondiente para este color, guardarlo en la LUT interna.
            
            // y = A * x + B
            myLUT.put(i, (int)(A * i + B));
        }
        Sys.out(myLUT);
    }
    
    private void recalculateTramo(Point leftPoint, Point rightPoint){

        Sys.fout("Para tramo %s <--> %s", leftPoint, rightPoint);
        
        xLo = Math.min(leftPoint.x, rightPoint.x);    // Should always be left point, but w/e.
        xHi = Math.max(leftPoint.x, rightPoint.x);    // Should always be right point, but w/e.
        yLo = Math.min(leftPoint.y, rightPoint.y);
        yHi = Math.max(leftPoint.y, rightPoint.y);
        
        Sys.fout("xLo= %d, xHi = %d, yLo= %d, yHi = %d", xLo, xHi, yLo, yHi);
        
        int valueDiff = xHi - xLo;
        if (valueDiff == 0) valueDiff = 1;  // Avoid dividing by zero.
        A = (float)(yHi - yLo) / (float)valueDiff;    // A = (H - L) / (max - min);
        B = yLo - A * xLo;
        Sys.fout("A= %f, B = %f", A, B);
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
            else if (points.get(i).x == points.get(i-1).x){
                Sys.exception("Points with same X value: p1=%s p2=%s", points.get(i-1), points.get(i));
            }
        }
    }
    
    @Override
    protected int getVOut(int vIn) {
        return myLUT.get(vIn);
    }

}
