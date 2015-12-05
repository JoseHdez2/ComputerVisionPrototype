package gui.dialog;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import gui.dialog.base.SelectionDialog;
import gui.utils.MyInternalFrame;
import gui.utils.image.NamedImage;
import i18n.GUIStr;
import i18n.I18n;
import main.MainWindow;
import transform.point.math.ImageDifferencing;

public class DifferencingDialog extends SelectionDialog {
    
    public DifferencingDialog(MainWindow parent) {
        super(parent);
        
        show();
    }
    
    private void show() {
    
        super.show(GUIStr.ANALYZE_MENU_DIFFERENCING,
                    I18n.getString(GUIStr.IMAGE_MENU) + " 1: ",
                    I18n.getString(GUIStr.IMAGE_MENU) + " 2: ");
        
        
        if (option == JOptionPane.OK_OPTION) {
            
            NamedImage img1 = null;
            NamedImage img2 = null;
            
            for (JInternalFrame f: parent.getPane().getAllFrames()) {
                MyInternalFrame frame = (MyInternalFrame)f;
                
                if (frame.getTitle() == comboBox1.getSelectedItem())
                    img1 = frame.getNamedImage();
                if (frame.getTitle() == comboBox2.getSelectedItem())
                    img2 = frame.getNamedImage();
            }
            
            if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
                parent.showErrorDialog(GUIStr.DIALOG_ERROR_DIFFERENCING);
                return;
            }
            
            ImageDifferencing differencing = new ImageDifferencing(img1, img2);
            NamedImage img = differencing.getDiff();

            parent.createImageFrame(img);            
         }        
    }
}
