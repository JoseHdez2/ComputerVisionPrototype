package gui.dialog;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import gui.dialog.base.SelectionDialog;
import gui.utils.MyInternalFrame;
import gui.utils.image.NamedImage;
import i18n.I18n;
import main.MainWindow;
import transform.point.HistogramSpecification;

public class SpecificationDialog extends SelectionDialog {
    
    public SpecificationDialog(MainWindow parent) {
        super(parent);
        
        show();
    }
    
    private void show() {
    
        super.show("TransformMenu.HistogramSpecification",
                    I18n.getString("HistogramSpecification.Text1"),
                    I18n.getString("HistogramSpecification.Text2"));
        
        
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
            
            HistogramSpecification transform = new HistogramSpecification(img1, img2);
            NamedImage img = transform.getTransformedImage(img1);
           
            parent.createImageFrame(img);            
         }        
    }
}