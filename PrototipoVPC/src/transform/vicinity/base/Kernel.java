package transform.vicinity.base;

public class Kernel extends FloatMatrix{
    
    public Kernel(float[][] data){
        super(data);
    }
    
    public Kernel(int width, int height){
        super(width, height);
    }
    
    /**
     * @return Is valid FloatMatrix and has a central pixel. 
     */
    public boolean isValid(){
        if (!super.isValid()) return false;
        if (!hasCentralPixel()) return false;
        return true;
    }
    
    /**
     * @return Has odd number of both rows and columns.
     */
    public boolean hasCentralPixel(){
        if ((getWidth() % 2) == 0) return false;
        if ((getHeight() % 2) == 0) return false;
        return true;
    }
    
    /**
     * @return Equivalent kernel whose elements add up to 1.
     */
    public Kernel getNormalized(){
        int elementCount = this.getElementCount();
        Kernel normKernel = new Kernel(this.width, this.height);
        
        for(int i = 0; i < this.height; i++){
            for (int j = 0; j < this.width; j++){
                normKernel.set(i, j, this.get(i,j) * (1f / elementCount));
            }
        }
        
        return normKernel;
    }
    
    
    // TODO: Pa que sirve la funcion de abajo? Pa que sirve hacer la H'.
    /**
     * Same as rotating the kernel 180 degrees.
     * @return Corresponding prime Kernel (H').
     */
    public Kernel getPrimeKernel(){
        Kernel primeKernel = new Kernel(this.width, this.height);
        
        for(int i = 0; i < this.height; i++){
            for (int j = 0; j < this.width; j++){
                primeKernel.set(i, j, this.get(this.width - i, this.height - j));
            }
        }
        
        return primeKernel;
    }
    
    /**
     * @return Index of center row. Assumes true for {@link Kernel#isValid()}.
     */
    public int centerRow(){
        return this.height / 2;
    }
    
    /**
     * @return Index of center column. Assumes true for {@link Kernel#isValid()}.
     */
    public int centerCol(){
        return this.width / 2;
    }
}
