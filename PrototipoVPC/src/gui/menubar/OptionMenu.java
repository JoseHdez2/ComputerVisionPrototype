package gui.menubar;

import java.awt.event.ActionEvent;

import i18n.GUIStr;
import main.MainWindow;

public class OptionMenu extends AbstractMenu{

    final static GUIStr[] ACTION_NAMES =
        {
        GUIStr.OPTIONS_MENU
        };
    
    // TODO: Have options be radio buttons.
    
    public OptionMenu(MainWindow parentFrame) {
        super(parentFrame, GUIStr.OPTIONS_MENU, ACTION_NAMES);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void actionPerformedHandler(GUIStr actionName, ActionEvent e) {
        switch(actionName){
        case OPTIONS_MENU:
            optionsActionPerformed(e);
            break;
        }
        
    }

    private void optionsActionPerformed(ActionEvent e){
        
    }
}
