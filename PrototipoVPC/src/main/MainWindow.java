package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import gui.menubar.TheMenuBar;
import gui.utils.MyInternalFrame;
import gui.utils.RegionSelector;
import gui.utils.image.NamedImage;
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
	HashMap<String,Integer> openedImages = new HashMap<String,Integer>();
	
	JDesktopPane pane = new JDesktopPane();
	TheMenuBar menubar = new TheMenuBar(this);
	StatusBar statusbar = new StatusBar();
	Options opt = new Options();
	
	MainWindow(){
	    
		this.setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
		this.setLayout(new BorderLayout());
		this.setTitle(I18n.getString(GUIStr.MAIN_WINDOW_TITLE));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pane.setBackground(Color.LIGHT_GRAY);

		this.add(pane);
		this.add(statusbar, BorderLayout.SOUTH);
	
		this.setVisible(true);
	}

	 /**
     * Create new InternalFrame for image's transforms
     */
	public void createImageFrame(NamedImage image) {
	    
	    JInternalFrame[] frames = pane.getAllFrames();
	    boolean opened = false;
	    String name = image.getName();
	    String title;

	    // Comprobar si ya se ha abierto la imagen anteriormente
	    for (int i=0; i<frames.length; i++) {
	        MyInternalFrame f = (MyInternalFrame)frames[i];
	        
	        if (f.getNamedImage().getName().equals(name)) {
	            opened = true;
	        }   
	    }

	    // Cambiar el titulo del InternalFrame
	    if (opened == false) {
	        title = name;
	        openedImages.put(name,0);	        
	    }
	    else {
	        int index = openedImages.get(name) + 1;
	        openedImages.put(name,index);
	        title = image.getBasicName() + "(" + index + ")." + image.getExtension();
	    }
	    
	    MyInternalFrame frame = new MyInternalFrame(title, image, statusbar);
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
	
	public void showErrorDialog(GUIStr errorStr){
        JOptionPane.showMessageDialog(this, I18n.getString(errorStr), 
                I18n.getString(GUIStr.GENERAL_ERROR), JOptionPane.ERROR_MESSAGE);
	}
	
	/*
	 * Getters and setters.
	 */
	
	public JDesktopPane getPane() {
	    return pane;
    }

    public Options getOpt() {
        return opt;
    }
}
