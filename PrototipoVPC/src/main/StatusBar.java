package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import i18n.I18n;

@SuppressWarnings("serial")
public class StatusBar extends JPanel{
    
    final JLabel separatorLabel = new JLabel(" | ");
    JLabel positionLabel = null;
    JLabel colorLabel = null;
    public JLabel colorModeLabel = null; //TODO: mal codigo, no hacer publico

    public StatusBar() {
        super();
        
        this.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.setPreferredSize(new Dimension(this.getWidth(), 24));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        createLabels();
    }
    
    /**
     * Create and adjust status labels
     */
    private void createLabels() {
        positionLabel = new JLabel("(x:-----, y:-----)");
        positionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        
        colorLabel = new JLabel("(R:--- G:--- B:---)");
        colorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        colorModeLabel = new JLabel("---");
        

        this.add(positionLabel);
        this.add(separatorLabel);
        this.add(colorLabel);
        this.add(separatorLabel);
        this.add(colorModeLabel);
    }
    
    /**
     * Update position label with the position of the cursor relative to the image origin.
     * @param current Position of the cursor relative to the image origin.
     */
    public void setPositionLabel(Point current) {
        if (current != null)
            positionLabel.setText(
                    String.format("(x:%5d, y:%5d)", (int)current.getX(), (int)current.getY()));
        else
            positionLabel.setText("(x:-----, y:-----)");
    }
    
    /**
     * Update color label with the color of the pixel under the cursor.
     * @param current Color of the pixel under the cursor.
     */
    public void setColorLabel(Color current) {
        if (current != null){
            colorLabel.setText(
                    String.format("(R:%3d G:%3d B:%3d)", 
                            current.getRed(), current.getGreen(), current.getBlue())
            );
        }
        else
            colorLabel.setText("(R:--- G:--- B:---)");
    }
    
    /**
     * Update color mode label with the color mode of the image under the cursor.
     * @param current Color mode of the image under the cursor.
     */
    public void setColorModeLabel(boolean isGrayscale){
        if (isGrayscale){
            colorModeLabel.setText(I18n.getString("StatusBar.ColorModeGrayscale"));
        } else {
            colorModeLabel.setText(I18n.getString("StatusBar.ColorModeRGB"));
        }
    }
}
