package gui.dialog;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import gui.utils.image.NamedImage;
import i18n.I18n;
import main.MainWindow;
import transform2.ScaleBilinear;
import transform2.ScaleNearest;
import transform2.base.Scale;

public class ScaleDialog {
    
    final int MIN_VAL = 0;
    final int MAX_VAL = 9999;
    final int STEP_SIZE = 1;
    
    MainWindow parent = null;
    NamedImage image = null;
    
    JSpinner[] percentSpinners = null;
    JSpinner[] valuesSpinners = null;
    JRadioButton percentButton = null;
    JRadioButton valuesButton = null;
    JRadioButton nearestButton = null;
    JRadioButton bilinearButton = null;

    public ScaleDialog(MainWindow parent, NamedImage image) {
        
        this.parent = parent;
        this.image = image;
        
        createElements();
        
        show("GeometryMenu.Scale");
    }
    
    private void createElements() {
        
        // JSpinners para introducir datos
        percentSpinners = new JSpinner[2];
        percentSpinners[0] = new JSpinner(new SpinnerNumberModel(100,MIN_VAL,MAX_VAL,STEP_SIZE));
        percentSpinners[1] = new JSpinner(new SpinnerNumberModel(100,MIN_VAL,MAX_VAL,STEP_SIZE));
        
        valuesSpinners = new JSpinner[2];
        valuesSpinners[0] = new JSpinner(new SpinnerNumberModel(image.getWidth(),MIN_VAL,MAX_VAL,STEP_SIZE));
        valuesSpinners[1] = new JSpinner(new SpinnerNumberModel(image.getHeight(),MIN_VAL,MAX_VAL,STEP_SIZE)); 
        
        // JRadioButtons para seleccionar
        percentButton = new JRadioButton(I18n.getString("Dialog.ScalePercent"));
        percentButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                for (int i=0; i<2; i++) {
                    percentSpinners[i].setEnabled(true);
                    valuesSpinners[i].setEnabled(false);
                }
                percentButton.setSelected(true);
                valuesButton.setSelected(false);
            } 
        } );
        
        valuesButton = new JRadioButton(I18n.getString("DialogScale.Size"));
        valuesButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                for (int i=0; i<2; i++) {
                    valuesSpinners[i].setEnabled(true);
                    percentSpinners[i].setEnabled(false);
                }
                valuesButton.setSelected(true);
                percentButton.setSelected(false);
            } 
        } );
        
        nearestButton = new JRadioButton(I18n.getString("DialogScale.Nearest"));        
        bilinearButton = new JRadioButton(I18n.getString("DialogScale.Bilinear"));
        
        ButtonGroup interpolationGroup = new ButtonGroup();
        interpolationGroup.add(nearestButton);
        interpolationGroup.add(bilinearButton);
        
        // Definir elementos por defecto
        percentButton.setSelected(true);
        valuesButton.setSelected(false);
        for (int i=0; i<2; i++) {
            percentSpinners[i].setEnabled(true);
            valuesSpinners[i].setEnabled(false);
        }
        nearestButton.setSelected(true);
    }
    
    private JPanel createPanel() {
        
        JPanel panel = new JPanel();
        
        // Panel de datos
        JPanel inputPanel = new JPanel(new GridLayout(4,1));
        // Panel de selección de interpolación
        JPanel algorithmPanel = new JPanel(new GridLayout(2,1));
        algorithmPanel.setBorder(new TitledBorder(I18n.getString("DialogScale.Interpolation")));
        
        // Panel de Porcentajes
        JPanel percentPanel = new JPanel();
        percentPanel.add(new JLabel("X"));
        percentPanel.add(percentSpinners[0]);
        percentPanel.add(new JLabel("Y"));
        percentPanel.add(percentSpinners[1]);
        
        // Panel de valores
        JPanel valuesPanel = new JPanel();
        valuesPanel.add(new JLabel("X"));
        valuesPanel.add(valuesSpinners[0]);
        valuesPanel.add(new JLabel("Y"));
        valuesPanel.add(valuesSpinners[1]);
        
        // Añadir al panel de datos
        inputPanel.add(percentButton);
        inputPanel.add(percentPanel);
        inputPanel.add(valuesButton);
        inputPanel.add(valuesPanel);
        
     // Añadir al panel de interpolacion
        algorithmPanel.add(nearestButton);
        algorithmPanel.add(bilinearButton);
        
        panel.add(inputPanel);
        panel.add(Box.createHorizontalStrut(40));
        panel.add(algorithmPanel);
        
        return panel;
    }
    
    protected void show(String title) {
        
        JPanel panel = createPanel();
        
        int option = JOptionPane.showConfirmDialog(null, panel, 
                I18n.getString(title), 
                JOptionPane.OK_CANCEL_OPTION);
        
        if (option == JOptionPane.OK_OPTION) {
            
            Scale transform = null;
            float x, y;
            
            // Seleccionar datos
            if (percentButton.isSelected()) {
                x = (int)percentSpinners[0].getValue();
                y = (int)percentSpinners[1].getValue();
                if (nearestButton.isSelected()) {
                    transform = new ScaleNearest(image, (float)x, (float)y);
                } else {
                    transform = new ScaleBilinear(image, (float)x, (float)y);
                }        
            } else {
                x = (int)valuesSpinners[0].getValue();
                y = (int)valuesSpinners[1].getValue();
                if (nearestButton.isSelected()) {
                    transform = new ScaleNearest(image, x, y);
                } else {
                    transform = new ScaleBilinear(image, x, y);
                }       
            }
            
            NamedImage img = transform.getTransformedImage(image);
            parent.createImageFrame(img);
            
//            show(GUIStr.GEOMETRY_MENU_SCALE);
        }      
    }
}
