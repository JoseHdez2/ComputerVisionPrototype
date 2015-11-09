package gui.dialogs;

import javax.swing.JDialog;

import i18n.GUIStr;
import i18n.I18n;
import main.MainWindow;

@SuppressWarnings("serial")
public class BrightnessContrastDialog extends JDialog {

    
    public BrightnessContrastDialog(MainWindow parent) {
        
        super(parent);
        
        this.setSize(300,300);
        this.setTitle(I18n.getString(GUIStr.IMAGE_MENU_BRIGHTNESS_CONTRAST));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
        this.setVisible(true);
    }
}
