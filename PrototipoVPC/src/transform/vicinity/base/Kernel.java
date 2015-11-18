package transform.vicinity.base;

import java.util.ArrayList;

public class Kernel extends ArrayList<ArrayList<Integer>>{
    
    boolean valid;
    
    public Kernel(){
        
    }
    
    public void updateValidity(){
        if (this.isEmpty()){
            valid = false;
        }
        if (isRectangular() && hasCenterPixel()){
            valid = true;
        }
        else valid = false;
    }
    
    /**
     * @return Kernel is not empty and all rows have the same number of elements.
     */
    public boolean isRectangular(){
        if (this.isEmpty()) return false;
        int expectedWidth = this.size();
        int expectedHeight = this.get(0).size();
        for(int i = 0; i < expectedHeight; i++){
            if (this.get(i).size() != expectedWidth) return false;
        }
        return true;
    }
    
    /**
     * NOTE: Assumes true for {@link Kernel#isRectangular()}.
     * @return Has odd number of both rows and columns.
     */
    public boolean hasCenterPixel(){
        if ((this.size() % 2) != 0) 
        if (this.get(0))
    }
    
    public Integer[] centerPixelCoords(){
        
    }
    
    /**
     * Same as rotating the kernel 180 degrees.
     * @return Corresponding prime Kernel (H').
     */
    public Kernel getPrimeKernel(){
        Kernel primeKernel = new Kernel();
    }
}
