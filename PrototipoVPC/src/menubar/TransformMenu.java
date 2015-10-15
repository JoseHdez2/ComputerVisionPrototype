package menubar;

import java.awt.event.ActionEvent;

import gui_utils.NamedImage;
import i18n.GUIStr;
import main.MainWindow;
import processing.grayscale.HistogramEqualization;
import processing.grayscale.ImageTransformer;


public class TransformMenu extends AbstractMenu {
    
    final static GUIStr[] ACTION_NAMES =
        {
        GUIStr.TRANSFORM_MENU_EQUALIZE_ACTION
        };
    
    public TransformMenu(MainWindow parentFrame){
        super(parentFrame, GUIStr.FILE_MENU, ACTION_NAMES);
    }

    @Override
    protected void actionPerformedHandler(GUIStr actionName, ActionEvent e) {

        switch(actionName){
        case TRANSFORM_MENU_EQUALIZE_ACTION:
            equalizeActionPerformed(e);
            break;
        }
    }
    
    /*
     * Menu actions
     */
    
    private void equalizeActionPerformed(ActionEvent e) {
        
        NamedImage image1 = parentFrame.getFocusedImage();
        
        ImageTransformer equalizer = new ImageTransformer(new HistogramEqualization());
        NamedImage image2 = equalizer.getTransformedImage(image1);
        parentFrame.createImageFrame(image2);
           
    }
}
