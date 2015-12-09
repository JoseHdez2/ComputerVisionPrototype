package transform2.base;

import gui.utils.image.NamedImage;

public class AbstractMirror {

    protected NamedImage image = null;
    
    public AbstractMirror(NamedImage img) {
        image = img;
    }
    
    protected NamedImage getCorrespondingImage(NamedImage img) {
        return img.deepishCopy();
    }
}
