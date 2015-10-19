package gui.menubar;

import java.awt.event.ActionEvent;

import gui.utils.NamedImage;
import gui.utils.histogram.AbsoluteHistogram;
import gui.utils.histogram.AcumulativeHistogram;
import i18n.GUIStr;
import main.MainWindow;

@SuppressWarnings("serial")
public class AnalyzeMenu extends AbstractMenu{
    
    final static GUIStr[] ACTION_NAMES =
        {
        GUIStr.ANALYZE_MENU_ABSOLUTE_HISTOGRAM,
        GUIStr.ANALYZE_MENU_ACUMULATIVE_HISTOGRAM

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
        case ANALYZE_MENU_ACUMULATIVE_HISTOGRAM:
            accumulativeHistogramActionPerformed(e);
            break;
        }
    }    
    
    
    private void absoluteHistogramActionPerformed(ActionEvent e) {
    
        NamedImage image = parentFrame.getFocusedImage();
        
        if (image != null) {
            new AbsoluteHistogram(image);
        }
    }
    
    
    private void accumulativeHistogramActionPerformed(ActionEvent e) {
    
        NamedImage image = parentFrame.getFocusedImage();
        
        if (image != null) {
            new AcumulativeHistogram(image);
        }
    }
}
