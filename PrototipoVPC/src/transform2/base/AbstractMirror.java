package transform2.base;

import gui.utils.image.NamedImage;

public abstract class AbstractMirror extends CoordinatesTransform {

    protected NamedImage image = null;
    
    public AbstractMirror(NamedImage img) {
        image = img;
    }
    
    protected NamedImage getCorrespondingImage(NamedImage img) {
        return img.deepishCopy();
    }
    
}
