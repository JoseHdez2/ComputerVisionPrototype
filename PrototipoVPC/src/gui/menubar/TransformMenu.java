package gui.menubar;

import java.awt.event.ActionEvent;

import gui.utils.NamedImage;
import i18n.GUIStr;
import main.MainWindow;
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
    
    private void equalizeActionPerformed(ActionEvent e) {
        
        NamedImage image1 = parentFrame.getFocusedImage();
        
        NamedImage image2 = HistogramEqualization.getTransformedImage(image1);
        parentFrame.createImageFrame(image2);
           
    }
    
    private void negativeActionPerformed(ActionEvent e) {
        
        NamedImage image1 = parentFrame.getFocusedImage();
        
        NamedImage image2 = Negative.getTransformedImage(image1);
        parentFrame.createImageFrame(image2);
           
    }
}
