package transform.vicinity.base;

import gui.utils.image.NamedImage;

public abstract class AbstractLinearDoubleFilter extends AbstractLinearFilter {

    @Override
    public NamedImage getTransformedImage(NamedImage img1) {
        Kernel kernelHor = createHorizontalKernel();
        Kernel kernelVer = createVerticalKernel();
        NamedImage img2;
        img2 = this.applyFilter(img1, kernelHor);
        img2 = this.applyFilter(img2, kernelVer);
        return img2;
    }

    protected abstract Kernel createHorizontalKernel();
    
    protected abstract Kernel createVerticalKernel();

}
