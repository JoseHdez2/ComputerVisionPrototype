package menubar;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import main.MainWindow;

public class FileMenu extends JMenu{
    
    MainWindow parentFrame;
    BufferedImage image;
    JDesktopPane pane;
    
    // Acciones del menú Archivo
    JMenuItem openAction = new JMenuItem("Abrir...");
    JMenuItem saveAction = new JMenuItem("Guardar");
    JMenuItem saveAsAction = new JMenuItem("Guardar como...");
    JMenuItem closeAction = new JMenuItem("Cerrar");
    JMenuItem quitAction = new JMenuItem("Salir");
    
    public FileMenu(MainWindow parentFrame, JDesktopPane pane, BufferedImage image){
        super("Archivo");
        this.parentFrame = parentFrame;
        this.image = image;
        this.pane = pane;
    
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

        this.add(openAction);
        this.addSeparator();
        this.add(saveAction);
        this.add(saveAsAction);
        this.addSeparator();        
        this.add(closeAction);
        this.add(quitAction);
    }
    
    // Acciones del menú Archivo
    
    private void openActionPerformed(ActionEvent e) {
        
        FileDialog openFile = new FileDialog(parentFrame, "Cargando", FileDialog.LOAD);
        openFile.setDirectory(System.getProperty("user.dir"));
        openFile.setVisible(true);
        String imagePath = openFile.getFile();
        
        String filename = openFile.getFile();
        parentFrame.createImageWindow(imagePath);

        if (filename == null)
            System.out.println("No se ha abierto ninguna imagen");
        else {
            System.out.println("Se ha abierto " + filename);
            
            try {
                image = ImageIO.read(new File(openFile.getDirectory() + File.separator + filename));
            } catch (IOException readImage) {
                readImage.printStackTrace();
            }
            
            JFrame imageWindow = new JFrame();
            imageWindow.setSize(image.getWidth(), image.getHeight());
            imageWindow.setTitle(filename);
            imageWindow.add(new JLabel(new ImageIcon(image)));
            imageWindow.setVisible(true);
        }
    }
    
    private void saveActionPerformed(ActionEvent e) { }
    private void saveAsActionPerformed(ActionEvent e) { }
    private void closeActionPerformed(ActionEvent e) { }
    private void quitActionPerformed(ActionEvent e) { 
        
        System.exit(0);
    }
    void primeraParteConstructor(){

    }
}
