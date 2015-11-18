package transform.vicinity;

import transform.vicinity.base.AbstractLinearFilter;
import transform.vicinity.base.Kernel;

public class MeanBlur extends AbstractLinearFilter{

    @Override
    protected Kernel createKernel() {
        float data[][] = 
            {   
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
            };
        Kernel kernel = new Kernel(data);
        return kernel;
    }

}
