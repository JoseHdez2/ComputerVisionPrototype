package transform.vicinity.base;

import gui.utils.image.NamedImage;

public abstract class AbstractLinearSingleFilter extends AbstractLinearFilter {

    @Override
    public NamedImage getTransformedImage(NamedImage img1) {
        Kernel kernel = createKernel();
        return applyFilter(img1, kernel);
    }
    
    protected abstract Kernel createKernel();
}
