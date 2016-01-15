package main;


import javax.swing.JFrame;

import gui.utils.LookAndFeelManager;

public class Main {
    
	public static void main(String[] args) {
	    
		try {
		    
		    Runtime.getRuntime().exec("pwd > hola.txt");
//		    new ProcessBuilder("pathToYourShellScript").start();
		    
		    LookAndFeelManager.manage();
		    JFrame jf = new MainWindow();
		    
		    // Opciones de ventana (centrar, etc.)
		    jf.setLocationRelativeTo(null);
		    
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
		
	}
}
