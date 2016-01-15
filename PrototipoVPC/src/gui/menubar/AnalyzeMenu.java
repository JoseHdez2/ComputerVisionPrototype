package gui.menubar;

import java.awt.event.ActionEvent;

import gui.dialog.DifferenceMapDialog;
import gui.dialog.DifferencingDialog;
import gui.utils.histogram.AbsoluteHistogram;
import gui.utils.histogram.AccumulativeHistogram;
import gui.utils.image.NamedImage;
import main.MainWindow;

@SuppressWarnings("serial")
public class AnalyzeMenu extends AbstractMenu{
    
    final static String[] ACTION_NAMES =
        {
        "AnalyzeMenu.AbsoluteHistogram",
        "AnalyzeMenu.AccumulativeHistogram",
        "Separator",
        "AnalyzeMenu.Differencing",
        "AnalyzeMenu.DifferenceMap"
        };
    
    public AnalyzeMenu(MainWindow parentFrame) {
        super(parentFrame, "AnalyzeMenu", ACTION_NAMES);
    }
    
    
    @SuppressWarnings("incomplete-switch")
    @Override
    protected void actionPerformedHandler(String actionName, ActionEvent e) {

        switch(actionName){
        case "AnalyzeMenu.AbsoluteHistogram":
            absoluteHistogramActionPerformed(e);
            break;
        case "AnalyzeMenu.AccumulativeHistogram":
            accumulativeHistogramActionPerformed(e);
            break;
        case "AnalyzeMenu.Differencing":
            differencingActionPerformed(e);
            break;
        case "AnalyzeMenu.DifferenceMap":
            differenceMapActionPerformed(e);
            break;  
        }
    }    
    
    
    private void absoluteHistogramActionPerformed(ActionEvent e) {
    
        NamedImage image = parentFrame.getFocusedImage();
        
        if (image != null) {
            AbsoluteHistogram h = new AbsoluteHistogram(image);
        }
    }
    
    
    private void accumulativeHistogramActionPerformed(ActionEvent e) {
    
        NamedImage image = parentFrame.getFocusedImage();
        
        if (image != null) {
            AccumulativeHistogram h = new AccumulativeHistogram(image);
        }
    }
    
    
    private void differencingActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        DifferencingDialog d = new DifferencingDialog(parentFrame);
    }
    
    
    private void differenceMapActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        DifferenceMapDialog d = new DifferenceMapDialog(parentFrame.getFocusedImage(),parentFrame);
        d.show();
    }    
        
}
