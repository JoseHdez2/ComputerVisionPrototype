package gui.dialog;

import gui.dialog.base.Dialog;
import i18n.GUIStr;
import main.MainWindow;

public class OptionsDialog extends Dialog {

    public OptionsDialog(MainWindow parent){
        super(GUIStr.OPTIONS_MENU, parent);
    }
}
