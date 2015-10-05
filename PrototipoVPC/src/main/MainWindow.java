package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
	
	BufferedImage image = null;
	JDesktopPane pane = new JDesktopPane();
	
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
        menu.add(new FileMenu(this, pane, image));
		
	}
	
	public void createImageWindow(String completeImagePath){
	    
	    File file = new File(completeImagePath);
	    
	    try {
            image = ImageIO.read(file);
        } catch (IOException readImage) {
            readImage.printStackTrace();
        }
	    
        JFrame imageWindow = new JFrame();
        imageWindow.setSize(image.getWidth(), image.getHeight());
        imageWindow.setTitle(completeImagePath);
        imageWindow.add(new JScrollPane(new JLabel(new ImageIcon(image))));
        imageWindow.setVisible(true);
	};
	

	public void closeMyself(){

	}

	public void createImageFrame(BufferedImage image) {
        JInternalFrame imageWindow = new JInternalFrame("Mi ventanita", true, true, true, true);
//        imageWindow.setBounds(25, 25, 200, 100);
        imageWindow.setSize(image.getWidth(), image.getHeight());
        imageWindow.add(new JScrollPane(new JLabel(new ImageIcon(image))));
        imageWindow.setVisible(true);
        pane.add(imageWindow);
	}
}
