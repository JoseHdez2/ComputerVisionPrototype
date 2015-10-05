package main;


import javax.swing.JFrame;

import gui_utils.LookAndFeelManager;

public class Main {
	public static void main(String[] args) {
		
//	    LookAndFeelManager.manage();
		
		try {
		    //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    
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
