package main;


import gui_utils.LookAndFeelManager;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		
		LookAndFeelManager.manage();
		try {
		    JFrame jf = new MainWindow();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
		
	}
}
