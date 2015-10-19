package gui.menubar;

import java.awt.event.ActionEvent;

import gui.utils.NamedImage;
import gui.utils.histogram.AbsoluteHistogram;
import gui.utils.histogram.AccumulativeHistogram;
import i18n.GUIStr;
import main.MainWindow;

@SuppressWarnings("serial")
public class AnalyzeMenu extends AbstractMenu{
    
    final static GUIStr[] ACTION_NAMES =
        {
        GUIStr.ANALYZE_MENU_ABSOLUTE_HISTOGRAM,
        GUIStr.ANALYZE_MENU_ACCUMULATIVE_HISTOGRAM

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
}
