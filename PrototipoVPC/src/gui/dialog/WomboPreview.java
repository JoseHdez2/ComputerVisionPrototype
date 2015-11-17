package gui.dialog;

import gui.dialog.base.ImageDialog;
import gui.utils.image.NamedImage;
import i18n.GUIStr;
import main.MainWindow;
import transform.point.base.AbstractImagePointTransformation;

/**
 *  WomboCombo tied to an image and a transformation.
 *  Previews a transformation with different parameters.
 */
public class WomboPreview extends ImageDialog{
    
    WomboCombo womcom;
    
    final GUIStr[] grayscaleWomboLabels = {GUIStr.TRIVIAL_B};
    final GUIStr[] colorWomboLabels = {GUIStr.TRIVIAL_R, GUIStr.TRIVIAL_G, GUIStr.TRIVIAL_B};
    
    public WomboPreview(MainWindow parent, NamedImage image, AbstractImagePointTransformation transform){
        super(null, parent, image);
        if(image.isGrayscale()){
           womcom = new WomboCombo(grayscaleWomboLabels, 1, new int[1]);
        } else {
           womcom = new WomboCombo(colorWomboLabels, 3, new int[3]);
        }
    }
}
