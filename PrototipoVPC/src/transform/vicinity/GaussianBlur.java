package transform.vicinity;

import transform.vicinity.base.AbstractLinearFilter;
import transform.vicinity.base.Kernel;

// TODO: No he borrado la clase porque le tengo cariño <3
public class GaussianBlur extends AbstractLinearDoubleFilter{

    float sigma;
    
    public GaussianBlur(float sigma){
        this.sigma = sigma;
    }
    
    protected Kernel createHorizontalKernel(){
        float data[][] = 
            {   
                {4, 20, 135, 411, 801, 1000, 801, 411, 135, 20, 4},
            };
        return new Kernel(data);
    }
    
    protected Kernel createVerticalKernel(){
        float data[][] = 
            {   
                {4}, 
                {20}, 
                {135}, 
                {411}, 
                {801}, 
                {1000}, 
                {801}, 
                {411}, 
                {135}, 
                {20}, 
                {4},
            };
        return new Kernel(data);
    }
}
