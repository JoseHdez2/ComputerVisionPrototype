package main;


import gui.LookAndFeelManager;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		
		LookAndFeelManager.manage();
		
		JFrame jf = new MainWindow();
	}
}
