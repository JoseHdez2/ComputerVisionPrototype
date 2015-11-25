package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gui.dialog.base.ImageDialog;
import gui.utils.image.NamedImage;
import i18n.GUIStr;
import i18n.I18n;
import main.MainWindow;
import transform.point.BrightnessAndContrast;

// TODO: caso de color

@SuppressWarnings("serial")
public class BrightnessContrastWombo extends ImageDialog{
    
    GUIStr[] rgb = {GUIStr.TRIVIAL_R, GUIStr.TRIVIAL_G, GUIStr.TRIVIAL_B};
    int[] initialBrightness = {(int) Math.round(image.getBrightness()), 0, 0};
    int[] initialContrast = {(int) Math.round(image.getContrast()), 0, 0};
    
    WomboCombo brightnessWombo = new WomboCombo(rgb, 3, initialBrightness, true);
    WomboCombo contrastWombo = new WomboCombo(rgb, 3, initialContrast, true);
    
    public BrightnessContrastWombo(MainWindow parent, NamedImage image) {
        super(GUIStr.BRIGHTNESS_DIALOG_BRIGHTNESS, parent, image);
        this.setSize(new Dimension(650,240));
        
        // Elements panel
        JPanel elementsPanel = new JPanel(new BorderLayout());
        
        JPanel titlesPanel = new JPanel(new GridLayout(1,2));
        titlesPanel.add(new JLabel(I18n.getString(GUIStr.BRIGHTNESS_DIALOG_BRIGHTNESS),SwingConstants.CENTER));
        titlesPanel.add(new JLabel(I18n.getString(GUIStr.BRIGHTNESS_DIALOG_CONTRAST),SwingConstants.CENTER));
        
        JPanel wombosPanel = new JPanel(new GridLayout(1,2));
        wombosPanel.add(brightnessWombo);
        wombosPanel.add(contrastWombo);
        
        elementsPanel.add(titlesPanel, BorderLayout.NORTH);
        elementsPanel.add(wombosPanel, BorderLayout.CENTER);
        
        // Accept panel
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
    }
    
    private void setBrightnessAndContrast() {
        
        // TODO: provisional con imagenes en b/n
        BrightnessAndContrast transform = new BrightnessAndContrast(image, brightnessWombo.get(0), contrastWombo.get(0));
        NamedImage img = transform.getTransformedImage(image);
        
        System.out.println("transformado");
        
        parent.createImageFrame(img);
    }
}