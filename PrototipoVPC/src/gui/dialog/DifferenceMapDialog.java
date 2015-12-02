package gui.dialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import gui.utils.image.NamedImage;
import i18n.GUIStr;
import i18n.I18n;
import transform.point.math.ImageDifferencing;

public class DifferenceMapDialog {
    
    JSpinner spinner = new JSpinner(new SpinnerNumberModel(0,0,255,1));
    
    NamedImage image = null;
    
    public DifferenceMapDialog(NamedImage image) {
        
        this.image = image;
    }

    
    private JPanel createPanel() {
        
        JPanel panel = new JPanel();
        
        // Seleccionar umbral
        panel.add(new JLabel(I18n.getString(GUIStr.DIFFERENCE_MAP_THRESHOLD)));
        panel.add(spinner);
        
        return panel;
    }
    
    public void show() {
        
        JPanel panel = createPanel();
        
        int option = JOptionPane.showConfirmDialog(null, panel, 
                I18n.getString(GUIStr.ANALYZE_MENU_DIFFERENCE_MAP), 
                JOptionPane.OK_CANCEL_OPTION);
        
        if (option == JOptionPane.OK_OPTION) {
            
            //ImageDifferencing differencing = new ImageDifferencing(img1, img2);
            //NamedImage img = differencing.getDiff();

            //parent.createImageFrame(img);  
        }
    }
    
}
