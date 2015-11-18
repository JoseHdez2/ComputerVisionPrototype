package transform.vicinity.base;

import java.util.ArrayList;

public class FloatMatrix {
    
    float[][] data;
    
    public FloatMatrix(int width, int height){
        data = new float[height][width];    // TODO is it like this?
    }
    
    /**
     * @param i Column (x position) of element to set, starting at zeroth.
     * @param j Row (y position) of element to set, starting at zeroth.
     * @return Value of the indexed element.
     */
    public float get(int i, int j){
        return data[i][j];
    }
    
    /**
     * @param i Column (x position) of element to set, starting at zeroth.
     * @param j Row (y position) of element to set, starting at zeroth.
     * @param value New value to set.
     */
    public void set(int i, int j, float value){
        data[i][j] =
    }
}
