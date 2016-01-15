package gui.menubar;

import java.awt.event.ActionEvent;

import gui.dialog.LinearTransformationDialog;
import gui.dialog.SpecificationDialog;
import i18n.GUIStr;
import main.MainWindow;
import transform.point.HistogramEqualization;
import transform.point.Negative;
import transform.vicinity.MeanBlur;


@SuppressWarnings("serial")
public class TransformMenu extends AbstractMenu {
    
    final static GUIStr[] ACTION_NAMES =
        {
        GUIStr.TRANSFORM_MENU_EQUALIZE_ACTION,
        GUIStr.TRANSFORM_MENU_NEGATIVE_ACTION,
        GUIStr.TRANSFORM_MENU_HISTOGRAM_EQUALIZATION,
        GUIStr.TRANSFORM_MENU_HISTOGRAM_SPECIFICATION,
        GUIStr.SEPARATOR,
        GUIStr.TRANSFORM_MENU_LINEAR_TRANSFORMATION,
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
        case TRANSFORM_MENU_HISTOGRAM_EQUALIZATION:
            histogramEqualizationActionPerformed(e);
            break;
        case TRANSFORM_MENU_HISTOGRAM_SPECIFICATION:
            histogramSpecificationActionPerformed(e);
            break;            
        case TRANSFORM_MENU_LINEAR_TRANSFORMATION:
            filterLinearTransformationActionPerformed(e);
            break;
        }
    }
    
    /*
     * Menu actions
     */
    
    private void equalizeActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        transform(new HistogramEqualization(parentFrame.getFocusedImage()));
    }
    
    private void negativeActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        transform(new Negative());   
    }
    
    private void histogramEqualizationActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        transform(new HistogramEqualization(parentFrame.getFocusedImage()));   
    }
    
    private void histogramSpecificationActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        SpecificationDialog d = new SpecificationDialog(parentFrame);
    }    
    
    private void filterLinearTransformationActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        LinearTransformationDialog d = new LinearTransformationDialog(GUIStr.TRANSFORM_MENU_LINEAR_TRANSFORMATION, parentFrame, parentFrame.getFocusedImage());
        // transform(new MeanBlur());   
    }
}
