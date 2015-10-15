package main;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import gui.menubar.TheMenuBar;
import gui.utils.MyInternalFrame;
import gui.utils.NamedImage;
import i18n.GUIStr;
import i18n.I18n;

/**
 * @author jose
 *	Ventana principal.
 */
public class MainWindow extends JFrame {

	final int WIDTH_DEFAULT = 500;
	final int HEIGHT_DEFAULT = 500;
	
	JDesktopPane pane = new JDesktopPane();
	TheMenuBar menubar = new TheMenuBar(this);
	
	MainWindow(){
	    
		this.setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
		this.setTitle(I18n.getString(GUIStr.MAIN_WINDOW_TITLE));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.add(pane);
	
		this.setVisible(true);
	}

	public void createImageFrame(NamedImage image) {
	    MyInternalFrame frame = new MyInternalFrame(image);
        pane.add(frame);
        
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
	}
	
	/**
	 * Returns the NamedImage of the currently focused MyInternalFrame.
	 * Will return 'null' if no MyInternalFrame is selected.
	 * @return Either a NamedImage or null.
	 */
	public NamedImage getFocusedImage(){
	    
       MyInternalFrame myIntFrame = null;
       
       if (pane.getSelectedFrame() != null) {
           myIntFrame = (MyInternalFrame)pane.getSelectedFrame();
           return myIntFrame.getNamedImage();
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
