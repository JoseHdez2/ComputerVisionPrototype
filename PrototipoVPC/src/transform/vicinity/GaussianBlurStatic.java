package transform.vicinity;

import transform.vicinity.base.AbstractLinearFilter;
import transform.vicinity.base.Kernel;

public class GaussianBlurStatic extends AbstractLinearFilter{

    @Override
    protected Kernel createKernel() {
        float data[][] = 
            {   
                {4, 20, 135, 411, 801, 1000, 801, 411, 135, 20, 4},
            };
        Kernel kernel = new Kernel(data);
        return kernel;
    }

}
