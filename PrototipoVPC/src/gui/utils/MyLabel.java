package gui.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyLabel extends JLabel{
    
    final int NULL = -1;
    
    int x = NULL;
    int y = NULL;
    int width = NULL;
    int height = NULL;

    public MyLabel(ImageIcon img) {
        super(img);
    }
    
    /**
     * PaintComponent override to paint graphics in image with dotted line
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Get 2D graphics for add dotted line
        Graphics2D g2d = (Graphics2D) g.create();
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{3}, 0);
        g2d.setStroke(dashed);
        g2d.setColor(Color.BLACK);
        
        // Paint
        if (x != NULL && y != NULL && width != NULL && height != NULL) {
            g2d.drawRect(x,y,width,height); 
            g2d.dispose();
        }          
    }
    
    /**
     * Update the selection of image and repaint selection of image
     * @param origin Point of mouse pressed
     * @param end Point of mouse released
     */
    public void updateSelection(java.awt.Point origin, java.awt.Point end) {
        
        if (origin != null && end != null) {
            
            int widthAdjustment = (getWidth() - getIcon().getIconWidth()) / 2;
            int heightAdjustment = (getHeight() - getIcon().getIconHeight()) / 2;
            
            x = (int)Math.min(origin.getX(),end.getX()) + widthAdjustment;
            y = (int)Math.min(origin.getY(),end.getY()) + heightAdjustment;
            width = (int)Math.max(origin.getX(),end.getX()) + widthAdjustment - x;
            height = (int)Math.max(origin.getY(),end.getY()) + heightAdjustment - y;
         
            repaint();
        } 
        
        else { 
            x = NULL;
            y = NULL;
            width = NULL;
            height = NULL;
        }
    }
}
