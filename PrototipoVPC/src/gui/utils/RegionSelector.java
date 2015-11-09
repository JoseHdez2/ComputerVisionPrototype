package gui.utils;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gui.menubar.StatusBar;

public class RegionSelector extends MouseAdapter {
    
    final MyLabel label;
    final StatusBar status; // TODO: posible mal diseño.
    final NamedImage image;
    Point origin = null;
    Point end = null;
    Point current = null;

    public RegionSelector(NamedImage img, MyLabel label, StatusBar status) {
        this.image = img;
        this.status = status;
        this.label = label;
        label.addMouseListener(this);
        label.addMouseMotionListener(this);
    }
    
    /**
     * Calculate correct X position of image even if 
     * JLabel is resized
     * @return Integer X coordinate
     */
    private Integer getX(MouseEvent e) {
        
        int minWidth = (label.getWidth() - label.getIcon().getIconWidth()) / 2;
        int maxWidth = minWidth + label.getIcon().getIconWidth();
        int x = e.getX();
        
        if (x >= minWidth && x <= maxWidth) {
            return x - minWidth;
        } else {
            return null;
        }
    }
    
    /**
     * Calculate correct Y position of image even if 
     * JLabel is resized
     * @return Integer Y coordinate
     */
    private Integer getY(MouseEvent e) {
        
        int minHeight = (label.getHeight() - label.getIcon().getIconHeight()) / 2;
        int maxHeight = minHeight + label.getIcon().getIconHeight();
        int y = e.getY();
        
        if (y >= minHeight && y <= maxHeight) {
            return y - minHeight;
        } else {
            return null;
        }
    }    
    
    /**
     * Calculate the point of image only if selected point
     * is in the image boundaries
     * @return Point Point with X and Y coordinates
     */
    private Point getPoint(MouseEvent e) {
        
        Integer x = getX(e);
        Integer y = getY(e);
        
        if (x != null && y != null) {
            return new Point(x,y);
        } else {
            return null;
        }
    }
    
    /**
     * Mouse event when the mouse button has been pressed
     */
    public void mousePressed(MouseEvent e) { 
        origin = getPoint(e);
        status.setPositionLabel(current);
    }
    
    /**
     * Mouse event when the mouse button has been released 
     * and paint selection
     */
    public void mouseReleased(MouseEvent e) { 
        end = getPoint(e);
        label.updateSelection(origin,end);
    }
    
    /**
     * Mouse event when the mouse button has been clicked (pressed and released)
     * and clear any selection
     */
    public void mouseClicked(MouseEvent e) {
        current = getPoint(e);
        origin = null;
        end = null;
        label.updateSelection(null,null);
    }
    
    /**
     * Mouse event when the mouse exits InternalFrame
     * and clear status bar
     */
    public void mouseExited(MouseEvent e) {
        status.setPositionLabel(null);
        status.setColorLabel(null);
    }
    
    /**
     * Mouse event when mouse cursor has been moved onto InternalFrame
     * and update status bar
     */
    public void mouseMoved(MouseEvent e) {
        current = getPoint(e);
        status.setPositionLabel(current);
        if (current != null)
            status.setColorLabel(image.getPixelColor((int)current.getX(),(int)current.getY()));
        else
            status.setColorLabel(null);
    }
    
    /**
     * Mouse event when a mouse button is pressed and then dragged (pressed+released+moved)
     * and update status bar
     */
    public void mouseDragged(MouseEvent e) {
        current = getPoint(e);
        status.setPositionLabel(current);
        if (current != null)
            status.setColorLabel(image.getPixelColor((int)current.getX(),(int)current.getY()));
        else
            status.setColorLabel(null);
    }
    
    /**
     * Getters and Setters
     */
    public Point getOrigin() {
        return origin;
    }
    
    public Point getEnd() {
        return end;
    }
    
    public Point getCurrent() {
        return current;
    }
     
}