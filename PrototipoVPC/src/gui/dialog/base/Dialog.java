package gui.dialog.base;

import javax.swing.JFrame;

import i18n.I18n;
import main.MainWindow;

/**
 *  Pop-up window smaller than the main window.
 *  Allows for configuration of a small subsection of the program.
 */
@SuppressWarnings("serial")
public class Dialog extends JFrame{
    
    float widthRatioToParent = 0.75f;
    float heightRatioToParent = 0.75f;
    
    protected MainWindow parent = null;
    
    public Dialog(String title, MainWindow parent){
        this.parent = parent;
        int width = (int) (parent.getWidth() * widthRatioToParent);
        int height = (int) (parent.getHeight() * heightRatioToParent);
        this.setSize(width, height);
        this.setTitle(I18n.getString(title));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.setVisible(true);
    }
}
