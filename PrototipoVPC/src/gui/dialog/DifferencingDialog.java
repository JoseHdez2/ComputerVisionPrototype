package gui.dialog;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gui.utils.MyInternalFrame;
import gui.utils.image.NamedImage;
import i18n.GUIStr;
import i18n.I18n;
import main.MainWindow;
import transform.point.BrightnessAndContrast;

public class DifferencingDialog {

    MainWindow parent = null;
    String[] images = null;
    JComboBox<String> comboBox1 = null;
    JComboBox<String> comboBox2 = null;
    
    public DifferencingDialog(MainWindow parent) {
        
        this.parent = parent;

        ArrayList<String> imagesList = new ArrayList<String>();
        for (JInternalFrame f: parent.getPane().getAllFrames()) {
            MyInternalFrame frame = (MyInternalFrame)f;
            imagesList.add(frame.getTitle());
        }
        
        images = new String[imagesList.size()];
        images = imagesList.toArray(images);
        
        comboBox1 = new JComboBox<>(images);
        comboBox2 = new JComboBox<>(images);
    }
    
    private JPanel createPanel() {
        
        JPanel panel = new JPanel();
        
        panel.add(new JLabel(I18n.getString(GUIStr.IMAGE_MENU) + " 1: "));
        panel.add(comboBox1);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(new JLabel(I18n.getString(GUIStr.IMAGE_MENU) + " 2: "));
        panel.add(comboBox2);
        
        return panel;
    }
    
    public void show() {
        
        JPanel panel = createPanel();
        
        int option = JOptionPane.showConfirmDialog(null, panel, 
                I18n.getString(GUIStr.ANALYZE_MENU_DIFFERENCING), 
                JOptionPane.OK_CANCEL_OPTION);
        
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
            
            //BrightnessAndContrast transform = new BrightnessAndContrast(image, brightnessWombo.get(0), contrastWombo.get(0));
            //NamedImage img = transform.getTransformedImage(image);

            //parent.createImageFrame(img);            
         }        
    }
}
