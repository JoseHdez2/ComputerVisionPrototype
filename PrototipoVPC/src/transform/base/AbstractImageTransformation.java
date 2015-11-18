package transform.base;

import gui.utils.image.NamedImage;

public abstract class AbstractImageTransformation {

    /**
     * Take an input image and output the transformed image.
     * @param img1 Input image.
     * @return Output (transformed) image.
     */
    public abstract NamedImage getTransformedImage(NamedImage img1);
}
