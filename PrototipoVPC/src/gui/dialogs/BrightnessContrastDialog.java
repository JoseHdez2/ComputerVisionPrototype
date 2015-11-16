package gui.dialogs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.utils.image.NamedImage;
import i18n.GUIStr;
import i18n.I18n;
import main.MainWindow;
import transform.point.BrightnessAndContrast;

@SuppressWarnings("serial")
public class BrightnessContrastDialog extends JFrame {
    
    JSlider[] brightnessSlider = new JSlider[3]; //RGB [0,1,2]
    JSlider[] contrastSlider = new JSlider[3];
    JSpinner[] brightnessSpinner = new JSpinner[3];
    JSpinner[] contrastSpinner = new JSpinner[3];
    
    NamedImage image = null;
    MainWindow parent = null;
    
    public BrightnessContrastDialog(MainWindow parent, NamedImage image) {
        
        super();
        this.image = image;
        this.parent = parent;
        
        this.setSize(650,240);
        this.setTitle(I18n.getString(GUIStr.IMAGE_MENU_BRIGHTNESS_CONTRAST));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.setLayout(new BorderLayout(0,1));
        
        JPanel elementsPanel = createElements();
        JPanel acceptPanel = new JPanel();
        JButton acceptButton = new JButton(I18n.getString(GUIStr.GENERAL_ACCEPT));
        acceptButton.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) { 
            setBrightnessAndContrast();
          } 
        } );
        acceptPanel.add(acceptButton);

        this.add(elementsPanel,BorderLayout.CENTER);
        this.add(acceptPanel,BorderLayout.SOUTH);
    
        this.setVisible(true);
    }
    
    /**
     * Create sliders and spinners for each color cap
     */
    private JPanel createElements() {
        
        JPanel gridPanel = new JPanel(new GridLayout(0,2));
        JPanel panel = null;
        String[] rgb = new String[] {"R:", "G:", "B:"};
        
//        TODO: En imágenes a color cada capa tiene su brillo y contraste!
        
        int brightness = (int)image.getBrightness();
        int contrast = (int)image.getContrast();
        
        gridPanel.add(new JLabel(I18n.getString(GUIStr.BRIGHTNESS_DIALOG_BRIGHTNESS),SwingConstants.CENTER));
        gridPanel.add(new JLabel(I18n.getString(GUIStr.BRIGHTNESS_DIALOG_CONTRAST),SwingConstants.CENTER));
        
        for (int i=0; i<=2; i++) {
            final int innerI = i;
            
            // Sliders
            brightnessSlider[i] = new JSlider(JSlider.HORIZONTAL,0,255,brightness);
            brightnessSlider[i].addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                   updateBrightness(brightnessSlider[innerI].getValue());
                }
             });
            
            contrastSlider[i] = new JSlider(JSlider.HORIZONTAL,0,255,contrast);
            contrastSlider[i].addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                   updateContrast(contrastSlider[innerI].getValue());
                }
             });
            
            // Spinner Boxes
            brightnessSpinner[i] = new JSpinner(new SpinnerNumberModel(brightness,0,255,1));
            brightnessSpinner[i].addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                   updateBrightness((int)brightnessSpinner[innerI].getValue());
                }
             });
            
            contrastSpinner[i] = new JSpinner(new SpinnerNumberModel(contrast,0,255,1));
            contrastSpinner[i].addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                   updateContrast((int)contrastSpinner[innerI].getValue());
                }
             });
            
            // Añadir al panel
            panel = new JPanel();      
            panel.add(new JLabel(rgb[i]));
            panel.add(brightnessSlider[i]);
            panel.add(brightnessSpinner[i]);
            gridPanel.add(panel);
            
            panel = new JPanel();      
            panel.add(new JLabel(rgb[i]));
            panel.add(contrastSlider[i]);
            panel.add(contrastSpinner[i]);
            gridPanel.add(panel);
        }
        
        return gridPanel;
    }
    
    /**
     * Update brightness value for sliders and spinners
     */
    private void updateBrightness(int value) {
        for (int i=0; i<=2; i++) {
            brightnessSlider[i].setValue(value);
            brightnessSpinner[i].setValue(value);
        }
    }
    
    /**
     * Update contrast value for sliders and spinners
     */
    private void updateContrast(int value) {
        for (int i=0; i<=2; i++) {
            contrastSlider[i].setValue(value);
            contrastSpinner[i].setValue(value);
        }
    }
    
    
    private void setBrightnessAndContrast() {
        
        // TODO: provisional con imagenes en b/n
        BrightnessAndContrast transform = new BrightnessAndContrast(image, brightnessSlider[0].getValue(), contrastSlider[0].getValue());
        NamedImage img = transform.getTransformedImage(image);
        
        System.out.println("transformado");
        
        parent.createImageFrame(img);
//        System.out.println(brightnessSlider[0].getValue());
//        System.out.println(contrastSlider[0].getValue());
//        System.out.println((int)img.getBrightness());
//        System.out.println((int)img.getContrast());
    }
    
}
