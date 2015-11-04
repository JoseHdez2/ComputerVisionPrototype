package gui.menubar;

import java.awt.event.ActionEvent;

import gui.utils.NamedImage;
import i18n.GUIStr;
import main.MainWindow;
import transform.AbstractImagePointTransformation;
import transform.HistogramEqualization;
import transform.Negative;


@SuppressWarnings("serial")
public class TransformMenu extends AbstractMenu {
    
    final static GUIStr[] ACTION_NAMES =
        {
        GUIStr.TRANSFORM_MENU_EQUALIZE_ACTION,
        GUIStr.TRANSFORM_MENU_NEGATIVE_ACTION
        };
    
    public TransformMenu(MainWindow parentFrame){
        super(parentFrame, GUIStr.TRANSFORM_MENU, ACTION_NAMES);
    }

    @Override
    protected void actionPerformedHandler(GUIStr actionName, ActionEvent e) {

        switch(actionName){
        case TRANSFORM_MENU_EQUALIZE_ACTION:
            equalizeActionPerformed(e);
            break;
        case TRANSFORM_MENU_NEGATIVE_ACTION:
            negativeActionPerformed(e);
            break;
        }
    }
    
    /*
     * Menu actions
     */
    
    // If false, create new image in new frame.
    boolean OVERWRITE = false;
    
    private void transform(AbstractImagePointTransformation trans){
        NamedImage image1 = parentFrame.getFocusedImage();
        
        NamedImage image2 = trans.getTransformedImage(image1);
        
        if (OVERWRITE){
            // TODO: overwrite focused image.
//            parentFrame.getFocusedImage()
        } else {
            parentFrame.createImageFrame(image2);
        }
    }
    
    private void equalizeActionPerformed(ActionEvent e) {
        
        transform(new HistogramEqualization(parentFrame.getFocusedImage()));
    }
    
    private void negativeActionPerformed(ActionEvent e) {
        
        transform(new Negative());   
    }
}
