package gui.dialogs;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.utils.image.NamedImage;
import i18n.GUIStr;
import i18n.I18n;
import main.MainWindow;

@SuppressWarnings("serial")
public class BrightnessContrastDialog extends JDialog {
    
    JSlider[] brightnessSlider = new JSlider[3]; //RGB [0,1,2]
    JSlider[] contrastSlider = new JSlider[3];
    JSpinner[] brightnessSpinner = new JSpinner[3];
    JSpinner[] contrastSpinner = new JSpinner[3];
    
    NamedImage image = null;
    
    public BrightnessContrastDialog(MainWindow parent, NamedImage image) {
        
        super(parent);
        this.image = image;
        
        this.setSize(650,220);
        this.setTitle(I18n.getString(GUIStr.IMAGE_MENU_BRIGHTNESS_CONTRAST));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0,2));
        
        createElements();   
    
        this.setVisible(true);
    }
    
    private void createElements() {
        
        JPanel panel = null;
        String[] rgb = new String[] {"R:", "G:", "B:"};
        
//        TODO: En imágenes a clor cada capa tiene su brillo y contraste!
        
        int brightness = (int)image.getBrigthness();
        int contrast = (int)image.getContrast();
        
        this.add(new JLabel("Brillo",SwingConstants.CENTER));
        this.add(new JLabel("Contraste",SwingConstants.CENTER));
        
        for (int i=0; i<=2; i++) {
            
            brightnessSlider[i] = new JSlider(JSlider.HORIZONTAL,0,255,brightness);
            brightnessSlider[i].addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                   updateBrightnessSlider(((JSlider)e.getSource()).getValue());
                }
             });
            
            contrastSlider[i] = new JSlider(JSlider.HORIZONTAL,0,255,contrast);
            contrastSlider[i].addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                   updateContrastSlider(((JSlider)e.getSource()).getValue());
                }
             });
            
            brightnessSpinner[i] = new JSpinner();
            contrastSpinner[i] = new JSpinner();
            
            panel = new JPanel();      
            panel.add(new JLabel(rgb[i]));
            panel.add(brightnessSlider[i]);
            panel.add(brightnessSpinner[i]);
            this.add(panel);
            
            panel = new JPanel();      
            panel.add(new JLabel(rgb[i]));
            panel.add(contrastSlider[i]);
            panel.add(contrastSpinner[i]);
            this.add(panel);
        }
        
//        this.add(new JButton("Aplicar"),BorderLayout.EAST));
    }
    
    private void updateBrightnessSlider(int value) {
        for (int i=0; i<=2; i++) {
            brightnessSlider[i].setValue(value);
        }
    }
    
    private void updateContrastSlider(int value) {
        for (int i=0; i<=2; i++) {
            contrastSlider[i].setValue(value);
        }
    }
    
}
