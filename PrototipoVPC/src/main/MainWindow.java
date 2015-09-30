package main;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author jose
 *	Ventana principal.
 */
public class MainWindow extends JFrame {
	final String TITLE = "ME - Digital Image Processor";
	final int WIDTH_DEFAULT = 500;
	final int HEIGHT_DEFAULT = 500;
	
	MainWindow(){
		this.setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
		this.setTitle(TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		createMenu();
		
		this.setVisible(true);
	}
	
	
	private void createMenu() {
		
		JMenuBar menu = new JMenuBar();
		this.setJMenuBar(menu);
		
		JMenu fileMenu = new JMenu("Archivo");
		menu.add(fileMenu);
		
		// Acciones del menú Archivo
		JMenuItem openAction = new JMenuItem("Abrir...");
		JMenuItem saveAction = new JMenuItem("Guardar");
		JMenuItem saveAsAction = new JMenuItem("Guardar como...");
		JMenuItem closeAction = new JMenuItem("Cerrar");
		JMenuItem quitAction = new JMenuItem("Salir");
		
		// Eventos de menú
        openAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openActionPerformed(e);
            }
        });
        
        saveAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveActionPerformed(e);
            }
        });
        
        saveAsAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveAsActionPerformed(e);
            }
        });
        
        closeAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeActionPerformed(e);
            }
        });
        
        quitAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quitActionPerformed(e);
            }
        });        
		
        
		fileMenu.add(openAction);
		fileMenu.addSeparator();
		fileMenu.add(saveAction);
		fileMenu.add(saveAsAction);
		fileMenu.addSeparator();		
		fileMenu.add(closeAction);
		fileMenu.add(quitAction);
	}
	
	
	// Acciones del menú Archivo
	
	private void openActionPerformed(ActionEvent e) {
		
		System.out.println("Abriendo imagen...");
		
		FileDialog openFile = new FileDialog(this, "Abrir imagen...", FileDialog.LOAD);
		openFile.setFilenameFilter((dir, name) -> name.endsWith(".jpg") || name.endsWith(".png"));
		openFile.setVisible(true);
		
        String filename = openFile.getFile();
        if (filename == null)
          System.out.println("No se ha abierto ninguna imagen");
        else
          System.out.println("Se ha abierto " + filename);
		
	}
	
	private void saveActionPerformed(ActionEvent e) { }
	private void saveAsActionPerformed(ActionEvent e) { }
	private void closeActionPerformed(ActionEvent e) { }
	private void quitActionPerformed(ActionEvent e) { }

}
