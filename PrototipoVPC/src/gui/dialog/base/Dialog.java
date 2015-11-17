package gui.dialog.base;

import javax.swing.JFrame;

import i18n.GUIStr;
import i18n.I18n;
import main.MainWindow;

/**
 *  Pop-up window smaller than the main window.
 *  Allows for configuration of a small subsection of the program.
 */
public class Dialog extends JFrame{
    
    float WIDTH_RATIO_TO_PARENT = 0.25f;
    float HEIGHT_RATIO_TO_PARENT = 0.25f;
    
    protected MainWindow parent = null;
    
    public Dialog(GUIStr title, MainWindow parent){
        this.parent = parent;
        int width = (int) (parent.getWidth() * WIDTH_RATIO_TO_PARENT);
        int height = (int) (parent.getHeight() * HEIGHT_RATIO_TO_PARENT);
        this.setSize(width, height);
        this.setTitle(I18n.getString(GUIStr.IMAGE_MENU_BRIGHTNESS_CONTRAST));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.setVisible(true);
    }
}
