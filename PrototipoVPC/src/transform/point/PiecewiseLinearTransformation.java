package transform.point;

import java.awt.Point;
import java.util.ArrayList;

import transform.point.base.LUT;
import transform.point.base.ThreeChannelAIPT;
import util.Sys;

public class PiecewiseLinearTransformation extends ThreeChannelAIPT {

    LUT myLUT = new LUT();
    
    // TODO: hecho para imagenes en blanco y negro
    
    public PiecewiseLinearTransformation(ArrayList<Point> points) throws Exception{

        checkArguments(points);
        
        for (int i = 0; i < 255; i++){
            int p = 0;
            
            // Nos movemos buscando la linea adecuada al punto
            while (i > points.get(p).getX()){
                p++;
            }
        }
    }
    
    protected void checkArguments(ArrayList<Point> points) throws Exception{
        for (Point p : points){
            if (p.getX() < 0 || p.getX() > 255 || p.getY() < 0 || p.getY() > 255)
                Sys.exception("Point in piecewise out of bounds: %s", p);
        }
        
        for (int i = 0; i < points.size(); i++){
            if (i == 0) continue;
            if (points.get(i).getX() < points.get(i-1).getX()){
                Sys.exception("Points not in order or overlapping: p1=%s p2=%s", points.get(i-1), points.get(i));
            }
        }
    }
    
    @Override
    protected int getVOut(int vIn) {
        // TODO Auto-generated method stub
        return 0;
    }

}
