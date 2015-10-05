package main;

import gui_utils.MyInternalFrame;
import gui_utils.NamedImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;

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
	
//	BufferedImage image = null;
	JDesktopPane pane = new JDesktopPane();
	ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
	
	MainWindow(){
		this.setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
		this.setTitle(STR_TITLE);
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
	}
}
