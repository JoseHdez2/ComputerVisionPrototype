package main;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Main {
	public static void main(String[] args) {
		
		// Cambiar interfaz por defecto de la aplicación
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			
			LookAndFeelInfo[] themes = UIManager.getInstalledLookAndFeels();
			
			for (int i = 0; i < themes.length; i++) {
				// Windows
				if (themes[i].toString().contains("windows")) {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					break;
				}
				
				// OS X
				else if (themes[i].toString().contains("apple")) {
					UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
					break;
				}
				
				// Linux (GTK)
				else if (themes[i].toString().contains("gtk")) {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
					break;
				}
				
				// Por defecto
				else if (i == themes.length-1) 
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		}
		
		catch (Exception e) {
		 	e.printStackTrace();
		}
		
		JFrame jf = new MainWindow();
	}
}
