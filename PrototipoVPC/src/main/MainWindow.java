package main;

import java.util.ResourceBundle;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import gui_utils.MyInternalFrame;
import gui_utils.NamedImage;
import i18n.I18nManager;
import menubar.FileMenu;

/**
 * @author jose
 *	Ventana principal.
 */
public class MainWindow extends JFrame {

	final int WIDTH_DEFAULT = 500;
	final int HEIGHT_DEFAULT = 500;
	
//	BufferedImage image = null;
	JDesktopPane pane = new JDesktopPane();
	ResourceBundle i18n = I18nManager.manage();
//	ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
	
	MainWindow(){
	    
		this.setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
		this.setTitle(i18n.getString("MainWindow.Title"));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.add(pane);
	
		createMenu();
	
		this.setVisible(true);
	}

	private void createMenu() {
		JMenuBar menu = new JMenuBar();
		this.setJMenuBar(menu);
        menu.add(new FileMenu(this));
	}

	public void createImageFrame(NamedImage image) {
	    MyInternalFrame frame = new MyInternalFrame(image);
        pane.add(frame);
        
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
	}
	
	
	
	public JDesktopPane getPane() {
	    return pane;
	}
}
