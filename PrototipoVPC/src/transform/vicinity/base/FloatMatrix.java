package transform.vicinity.base;

public class FloatMatrix {
    
    float[][] data;
    int width, height;
    
    public FloatMatrix(int width, int height){
        data = new float[height][width];
        this.width = width;
        this.height = height;
    }
    
    public FloatMatrix(float[][] data){
        this.data = data;
        this.width = data[0].length;
        this.height = data.length;
    }
    
    /**
     * @return This matrix has at least one row and one column. 
     */
    public boolean isValid(){
        if (width < 1 || height < 1) return false;
        else return true;
    }
    
    /**
     * @return Number of elements in the matrix (number of rows by number of columns).
     */
    public int getElementCount(){
        return this.width * this.height;
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
        data[i][j] = value;
    }

    /*
     * Getters and setters
     */
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
