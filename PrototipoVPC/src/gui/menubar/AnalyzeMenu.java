package gui.menubar;

import java.awt.event.ActionEvent;

import gui.dialog.DifferencingDialog;
import gui.utils.histogram.AbsoluteHistogram;
import gui.utils.histogram.AccumulativeHistogram;
import gui.utils.image.NamedImage;
import i18n.GUIStr;
import main.MainWindow;

@SuppressWarnings("serial")
public class AnalyzeMenu extends AbstractMenu{
    
    final static GUIStr[] ACTION_NAMES =
        {
        GUIStr.ANALYZE_MENU_ABSOLUTE_HISTOGRAM,
        GUIStr.ANALYZE_MENU_ACCUMULATIVE_HISTOGRAM,
        GUIStr.ANALYZE_MENU_DIFFERENCING
        };
    
    public AnalyzeMenu(MainWindow parentFrame) {
        super(parentFrame, GUIStr.ANALYZE_MENU, ACTION_NAMES);
    }
    
    
    @SuppressWarnings("incomplete-switch")
    @Override
    protected void actionPerformedHandler(GUIStr actionName, ActionEvent e) {

        switch(actionName){
        case ANALYZE_MENU_ABSOLUTE_HISTOGRAM:
            absoluteHistogramActionPerformed(e);
            break;
        case ANALYZE_MENU_ACCUMULATIVE_HISTOGRAM:
            accumulativeHistogramActionPerformed(e);
            break;
        case ANALYZE_MENU_DIFFERENCING:
            differencingActionPerformed(e);
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
        
        DifferencingDialog d = new DifferencingDialog(parentFrame);
        d.show();
    }
        
}
