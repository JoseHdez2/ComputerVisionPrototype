package gui.dialog.base;

import gui.utils.image.NamedImage;
import i18n.GUIStr;
import main.MainWindow;

/**
 *  Dialog that acts on an image.
 *  Usually used for parametrized transformations,
 *  allowing to preview the image in question.
 */
@SuppressWarnings("serial")
public class ImageDialog extends Dialog {

    protected NamedImage image = null;
    
    public ImageDialog(GUIStr title, MainWindow parent, NamedImage image){
        super(title, parent);
        this.image = image;
    }
}
