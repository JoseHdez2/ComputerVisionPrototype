package main;


import javax.swing.JFrame;
import javax.swing.UIManager;

public class Main {
	public static void main(String[] args) {
		
//		LookAndFeelManager.manage();

		try {
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    JFrame jf = new MainWindow();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
		
	}
}
