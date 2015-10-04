package main;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;
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
	
	MainWindow(){
		this.setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
		this.setTitle(STR_TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		createMenu();
		
		this.setVisible(true);
	}
	
	
	private void createMenu() {
		
		JMenuBar menu = new JMenuBar();
		this.setJMenuBar(menu);
        menu.add(new FileMenu(this, image));
		
	}
	
	


}
