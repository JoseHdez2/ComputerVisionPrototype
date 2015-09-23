package main;

import javax.swing.JFrame;

/**
 * @author jose
 *	Ventana principal.
 */
public class MainWindow extends JFrame {
	final String TITLE = "ME - Digital Image Processor";
	final int WIDTH_DEFAULT = 500;
	final int HEIGHT_DEFAULT = 500;
	
	MainWindow(){
		this.setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
		this.setTitle(TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
