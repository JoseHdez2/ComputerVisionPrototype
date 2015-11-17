package transform.point.base;

import gui.utils.image.NamedImage;

/**
 *  Transformations that need an image and an integer parameter.
 *  This class exists to make some existing transformations compatible with the WomboPreview class.
 */
public interface ParametrizedTransformation {
    abstract NamedImage getTransformedImage(NamedImage img1, int parameter);
}
