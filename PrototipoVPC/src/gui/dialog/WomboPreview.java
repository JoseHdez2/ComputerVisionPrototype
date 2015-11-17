package gui.dialog;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.utils.image.NamedImage;
import i18n.GUIStr;
import transform.point.base.AbstractImagePointTransformation;

/**
 *  WomboCombo tied to an image and a transformation.
 *  Previews a transformation with different parameters.
 */
public class WomboPreview extends WomboCombo{
    
    static final GUIStr[] grayscaleWomboLabels = {GUIStr.TRIVIAL_B};
    static final GUIStr[] colorWomboLabels = {GUIStr.TRIVIAL_R, GUIStr.TRIVIAL_G, GUIStr.TRIVIAL_B};
    
    public WomboPreview(NamedImage image, AbstractImagePointTransformation transform){
//        super(colorWomboLabels, 1, new int[1]);
        super(colorWomboLabels, 3, new int[3]);
        
        if(image.isGrayscale()){
//            this.subWomboLabels = grayscaleWomboLabels;
//            this.addSubWombo(0, new int[0]);    //Replace color label.
            this.boundWombos = true;
            
        } else {
//            this.subwombos = 3;
        }
    }
    
    /**
     * Bind referenced subwombo with the parameters of a transformation over an image.
     * @param i
     */
    public void bindSubWombo(int i, NamedImage img1, NamedImage img2, AbstractImagePointTransformation trans){
        sliders[i].addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
               updateValue(i, sliders[i].getValue());
            }
        });
        spinners[i].addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
               updateValue(i, sliders[i].getValue());
            }
        });
    }
}
