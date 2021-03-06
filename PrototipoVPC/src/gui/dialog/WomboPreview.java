package gui.dialog;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.utils.image.NamedImage;
import transform.point.base.AbstractImagePointTransformation;

/**
 *  WomboCombo tied to an image and a transformation.
 *  Previews a transformation with different parameters.
 */
@SuppressWarnings("serial")
public class WomboPreview extends WomboCombo{
    
    static final String[] grayscaleWomboLabels = {"Trivial.B"};
    static final String[] colorWomboLabels = {"Trivial.R", "Trivial.G", "Trivial.B"};
    
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
//               img2 = trans.getTransformedImage(img1);
               updateValue(i, sliders[i].getValue());
        }});
        spinners[i].addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
               updateValue(i, sliders[i].getValue());
            }
        });
    }
}
