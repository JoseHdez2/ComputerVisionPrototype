package main;


import javax.swing.JFrame;

import gui.utils.LookAndFeelManager;

public class Main {
	public static void main(String[] args) {
				
		try {
		    LookAndFeelManager.manage();
		    JFrame jf = new MainWindow();
		    
		    // Opciones de ventana (centrar, etc.)
		    jf.setLocationRelativeTo(null);
		    
		    // Test histogram
//		    File file = new File("/home/migue/Escritorio/peppers.png");
//            NamedImage image = NamedImageCreator.create(file);
//            Histogram h = new Histogram(image);
		    
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
		
	}
}
