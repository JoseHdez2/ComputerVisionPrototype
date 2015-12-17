package gui.dialog;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import gui.utils.image.NamedImage;
import i18n.GUIStr;
import i18n.I18n;
import main.MainWindow;
import transform2.Rotation;
import transform2.Rotation90;
import transform2.base.AbstractRotation;
import transform2.base.MyPoint;

public class RotationDialog {
    
    MainWindow parent = null;
    NamedImage image = null;
    
    JRadioButton[] angleButtons = null;
    JRadioButton[] motionButtons = null;
    JRadioButton[] interpolationButtons = null;
    JSpinner angleSpinner = new JSpinner(new SpinnerNumberModel(0,Integer.MIN_VALUE,Integer.MAX_VALUE,1));
    

    public RotationDialog(MainWindow parent, NamedImage image) {
        
        this.parent = parent;
        this.image = image;
        
        createElements();
        
        show(GUIStr.GEOMETRY_MENU_ROTATION);
    }    

    
    private void createElements() {
        
        // Crear botones de ángulos
        angleButtons = new JRadioButton[4];
        for (int i=0; i<3; i++)
            angleButtons[i] = new JRadioButton(String.valueOf(90*(i+1)) + "º");
        angleButtons[3] = new JRadioButton();
        
        // Crear botones de sentidos
        motionButtons = new JRadioButton[2];
        motionButtons[0] = new JRadioButton(I18n.getString(GUIStr.DIALOG_ROTATION_CLOCKWISE));
        motionButtons[1] = new JRadioButton(I18n.getString(GUIStr.DIALOG_ROTATION_ANTICLOCKWISE));
        
        // Crear botones de interpolacion
        interpolationButtons = new JRadioButton[2];
        interpolationButtons[0] = new JRadioButton(I18n.getString(GUIStr.DIALOG_SCALE_NEAREST));        
        interpolationButtons[1] = new JRadioButton(I18n.getString(GUIStr.DIALOG_SCALE_BILINEAR));
        
        // Eventos de JRadioButton
        ButtonGroup angleGroup = new ButtonGroup();
        for (int i=0; i<4; i++)
            angleGroup.add(angleButtons[i]);
        
        ButtonGroup motionGroup = new ButtonGroup();
        for (int i=0; i<2; i++)
            motionGroup.add(motionButtons[i]);
        
        ButtonGroup interpolationGroup = new ButtonGroup();
        for (int i=0; i<2; i++)
            interpolationGroup.add(interpolationButtons[i]);
        
        // Eventos especificos
        angleButtons[3].addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                for (int i=0; i<2; i++) {
                    interpolationButtons[i].setEnabled(true);
                    motionButtons[i].setEnabled(false);
                }
            } 
        } );
        
        for (int i=0; i<3; i++) {
            angleButtons[i].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                    for (int j=0; j<2; j++) {
                        interpolationButtons[j].setEnabled(false);
                        motionButtons[j].setEnabled(true);
                    }
                } 
            } );
        }

        // Definir elementos por defecto
        angleButtons[0].setSelected(true);
        motionButtons[1].setSelected(true);
        interpolationButtons[0].setSelected(true);
        for (int j=0; j<2; j++) {
            interpolationButtons[j].setEnabled(false);
        }
    }
    
    private JPanel createPanel() {
        
        JPanel panel = new JPanel();
        
        // Panel de angulo
        JPanel anglePanel = new JPanel(new GridLayout(4,1));
        anglePanel.setBorder(new TitledBorder(I18n.getString(GUIStr.DIALOG_ROTATION_ANGLE)));
        // Panel de sentido
        JPanel motionPanel = new JPanel(new GridLayout(2,1));
        motionPanel.setBorder(new TitledBorder(I18n.getString(GUIStr.DIALOG_ROTATION_MOTION)));
        // Panel de selección de interpolación
        JPanel interpolationPanel = new JPanel(new GridLayout(2,1));
        interpolationPanel.setBorder(new TitledBorder(I18n.getString(GUIStr.DIALOG_SCALE_INTERPOLATION)));
        
        JPanel rightPanel = new JPanel(new GridLayout(2,1));
        rightPanel.add(motionPanel);
        rightPanel.add(interpolationPanel);
        
        // Panel de diferente angulo
        JPanel inputPanel = new JPanel();
        inputPanel.add(angleButtons[3]);
        inputPanel.add(angleSpinner);
        
        // Añadir al panel de angulo
        for (int i=0; i<3; i++)
            anglePanel.add(angleButtons[i]);
        anglePanel.add(inputPanel);
        
        // Añadir al panel de sentido
        for (int i=0; i<2; i++)
            motionPanel.add(motionButtons[i]);
        
        // Añadir al panel de interpolacion
        for (int i=0; i<2; i++)
            interpolationPanel.add(interpolationButtons[i]);       
        
        panel.add(anglePanel);
        panel.add(Box.createHorizontalStrut(40));
        panel.add(rightPanel);
        
        return panel;
    }
    
    protected void show(GUIStr title) {
        
        JPanel panel = createPanel();
        
        int option = JOptionPane.showConfirmDialog(null, panel, 
                I18n.getString(title), 
                JOptionPane.OK_CANCEL_OPTION);
        
        if (option == JOptionPane.OK_OPTION) {
            
            AbstractRotation transform = null;
            int angle = (int)angleSpinner.getValue();
            
            // Encontrar angulo seleccionado
            int angleSelected = 0;
            for (int i=0; i<4; i++)
                if (angleButtons[i].isSelected())
                    angleSelected = i;
            
            if (angleSelected == 3) {
                if (interpolationButtons[0].isSelected()) {
                    transform = new Rotation(image, angle, GUIStr.DIALOG_SCALE_NEAREST);
                } else {
                    transform = new Rotation(image, angle, GUIStr.DIALOG_SCALE_BILINEAR);
                }
            } else {
                if (motionButtons[0].isSelected()) {
                    transform = new Rotation90(image, 90*(angleSelected+1));
                } else {
                    transform = new Rotation90(image, -90*(angleSelected+1));
                }    
            }
            
            NamedImage img = transform.getTransformedImage(image);
            parent.createImageFrame(img);
            
//            show(GUIStr.GEOMETRY_MENU_ROTATION);
        }      
    }
}
