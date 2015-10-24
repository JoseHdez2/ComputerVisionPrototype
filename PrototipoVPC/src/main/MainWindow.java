package main;

import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import gui.menubar.TheMenuBar;
import gui.utils.MyInternalFrame;
import gui.utils.NamedImage;
import gui.utils.RegionSelector;
import i18n.GUIStr;
import i18n.I18n;

/**
 * @author jose
 *	Ventana principal.
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	final int WIDTH_DEFAULT = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2;
	final int HEIGHT_DEFAULT = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.5);
	
	JDesktopPane pane = new JDesktopPane();
	TheMenuBar menubar = new TheMenuBar(this);
	
	MainWindow(){
	    
		this.setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
		this.setTitle(I18n.getString(GUIStr.MAIN_WINDOW_TITLE));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.add(pane);
	
		this.setVisible(true);
	}

	 /**
     * Create new InternalFrame for image's transforms
     */
	public void createImageFrame(NamedImage image) {
	    MyInternalFrame frame = new MyInternalFrame(image);
        pane.add(frame);
        
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
	}
	
	/**
	 * Returns focused MyInternalFrame
	 * Will return 'null' if no MyInternalFrame is selected.
	 * @return Either a MyInternalFrame or null.
	 */
	private MyInternalFrame getFocusedFrame() {
	    	       
	    if (pane.getSelectedFrame() != null) {
	        return (MyInternalFrame)pane.getSelectedFrame();
	    } else {
	        return null;
	    }    	    
	}
	
	/**
	 * Returns the NamedImage of the currently focused MyInternalFrame.
	 * @return Either a NamedImage or null.
	 */
	public NamedImage getFocusedImage(){
	    
	    MyInternalFrame myIntFrame = getFocusedFrame();
       
	    if (myIntFrame != null) {
	        return myIntFrame.getNamedImage();
	    } else {
	        return null;
	    }
	}
	
	/**
	 *  Returns RegionSelectorevents of focused MyInternalFrame
	 * @return Either a RegionSelector or null.
	 */
	public RegionSelector getFocusedSelector() {
	    
	    MyInternalFrame myIntFrame = getFocusedFrame();
       
	    if (myIntFrame != null) {
	        return myIntFrame.getSelector();
	    } else {
	        return null;
	    }
	}
	
	/*
	 * Getters and setters.
	 */
	
	public JDesktopPane getPane() {
	    return pane;
    }
}
