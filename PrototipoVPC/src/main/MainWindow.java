package main;

import gui_utils.ImagePanel;
import java.awt.image.BufferedImage;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;

import menubar.FileMenu;

/**
 * @author jose
 *	Ventana principal.
 */
public class MainWindow extends JFrame {
	final String STR_TITLE = "ME - Digital Image Processor";
//	final String STR_
	final int WIDTH_DEFAULT = 500;
	final int HEIGHT_DEFAULT = 500;
	
	BufferedImage image = null;
	JDesktopPane pane = new JDesktopPane();
	
	MainWindow(){
		this.setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
		this.setTitle(STR_TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		createFrame("Img1");
		createFrame("Img2");
		createFrame("Img3");
		this.add(pane);
	
		createMenu();
	
		this.setVisible(true);
	}

	private void createMenu() {
		
		JMenuBar menu = new JMenuBar();
		this.setJMenuBar(menu);
        menu.add(new FileMenu(this, pane, image));
		
	}
	
	public void createImageWindow(String imagePath){
	    JInternalFrame jif = new JInternalFrame("Imagen", true);
//	    JInFrame jf = new JFrame("Imagen");
	    ImagePanel ip = new ImagePanel(imagePath);
	    jif.add(ip);
	};
	

	public void closeMyself(){

	}

	public void createFrame(String name) {
	
	    JInternalFrame frame = new JInternalFrame(name, true, true, true, true);
	    pane.add(frame);
	    
	    frame.setBounds(25, 25, 200, 100);
//	    frame.setSize(image.getWidth(), image.getHeight());
	    frame.setVisible(true);
	    
	    try {
	        frame.setSelected(true);
	    } catch (java.beans.PropertyVetoException e) {}
	}
}
