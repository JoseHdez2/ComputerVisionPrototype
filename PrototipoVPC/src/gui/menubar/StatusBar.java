package gui.menubar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class StatusBar extends JPanel{
    
    final JLabel separatorLabel = new JLabel(" | ");
    JLabel positionLabel = null;
    JLabel colorLabel = null;

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
        positionLabel = new JLabel("(x: y:)");
        positionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        
        colorLabel = new JLabel("(R: G: B:)");
        colorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        this.add(positionLabel);
        this.add(separatorLabel);
        this.add(colorLabel);
    }
    
    /**
     * Update label with x and y position selected
     */
    public void setPositionLabel(Point current) {
        if (current != null)
            positionLabel.setText("(x: " + (int)current.getX() +
                                 " y: " + (int)current.getY() + ")");
        else
            positionLabel.setText("(x: y:)");
    }
    
    /**
     * Update label color at x and y position selected
     */
    public void setColorLabel(Color current) {
        if (current != null)
            colorLabel.setText("(R: " + current.getRed() + 
                                " G: " + current.getGreen() +
                                " B: " + current.getBlue() + ")");
        else
            colorLabel.setText("(R: G: B:)");
    }    
}
