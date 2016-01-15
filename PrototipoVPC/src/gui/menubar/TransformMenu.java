package gui.menubar;

import java.awt.event.ActionEvent;

import gui.dialog.LinearTransformationDialog;
import gui.dialog.SpecificationDialog;
import main.MainWindow;
import transform.point.HistogramEqualization;
import transform.point.Negative;


@SuppressWarnings("serial")
public class TransformMenu extends AbstractMenu {
    
    final static String equalize = "TransformMenu.EqualizeAction";
    final static String negative = "TransformMenu.NegativeAction";
    final static String histEqualization = "TransformMenu.HistogramEqualization";
    final static String histSpecification = "TransformMenu.HistogramSpecification";
    final static String linearTransform = "TransformMenu.LinearTransformation";
    
    final static String[] ACTION_NAMES =
        { equalize, negative, histEqualization, histSpecification, __, linearTransform };
    
    public TransformMenu(MainWindow parentFrame){
        super(parentFrame, "TransformMenu", ACTION_NAMES);
    }

    @Override
    protected void actionPerformedHandler(String actionName, ActionEvent e) {
        
        switch(actionName){
        case equalize:
            equalizeActionPerformed(e);
            break;
        case negative:
            negativeActionPerformed(e);
            break;
        case histEqualization:
            histogramEqualizationActionPerformed(e);
            break;
        case histSpecification:
            histogramSpecificationActionPerformed(e);
            break;            
        case linearTransform:
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
        LinearTransformationDialog d = new LinearTransformationDialog(linearTransform, parentFrame, parentFrame.getFocusedImage());
        // transform(new MeanBlur());   
    }
}
