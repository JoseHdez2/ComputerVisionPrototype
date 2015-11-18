package gui.menubar;

import java.awt.event.ActionEvent;

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
        GUIStr.SEPARATOR,
        GUIStr.TRANSFORM_MENU_FILTER_MEAN_BLUR,
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
        case TRANSFORM_MENU_FILTER_MEAN_BLUR:
            filterMeanBlurActionPerformed(e);
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
    
    private void filterMeanBlurActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        transform(new MeanBlur());   
    }
}
