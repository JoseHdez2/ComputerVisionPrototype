package gui.menubar;

import java.awt.event.ActionEvent;

import gui.dialog.OptionsDialog;
import main.MainWindow;

public class OptionMenu extends AbstractMenu{

    final static String[] ACTION_NAMES =
        {
        "OptionsMenu"
        };
    
    // TODO: Have options be radio buttons.
    
    public OptionMenu(MainWindow parentFrame) {
        super(parentFrame, "OptionsMenu", ACTION_NAMES);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void actionPerformedHandler(String actionName, ActionEvent e) {
        switch(actionName){
        case "OptionsMenu":
            optionsActionPerformed(e);
            break;
        }
        
    }

    private void optionsActionPerformed(ActionEvent e){
        OptionsDialog optionsDialog = new OptionsDialog(parentFrame);
    }
}
