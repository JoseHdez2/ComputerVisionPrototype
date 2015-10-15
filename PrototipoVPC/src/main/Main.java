package main;


import java.io.File;

import gui.utils.LookAndFeelManager;
import gui.utils.NamedImage;
import gui.utils.NamedImageCreator;
import gui.utils.histogram.AbsoluteHistogram;
import gui.utils.histogram.AcumulativeHistogram;

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
//            AbsoluteHistogram h = new AbsoluteHistogram(image);
//            AcumulativeHistogram h = new AcumulativeHistogram(image);
		    
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
		
	}
}
