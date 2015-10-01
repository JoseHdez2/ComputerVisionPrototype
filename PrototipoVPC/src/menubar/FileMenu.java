package menubar;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FileMenu extends JMenu{
    
    JFrame parentFrame;
    
    // Acciones del menú Archivo
    JMenuItem openAction = new JMenuItem("Abrir...");
    JMenuItem saveAction = new JMenuItem("Guardar");
    JMenuItem saveAsAction = new JMenuItem("Guardar como...");
    JMenuItem closeAction = new JMenuItem("Cerrar");
    JMenuItem quitAction = new JMenuItem("Salir");
    
    public FileMenu(JFrame parentFrame){
        super("Archivo");
    
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
        
        System.out.println("Abriendo imagen...");
        
        FileDialog openFile = new FileDialog(parentFrame, "Abrir imagen...", FileDialog.LOAD);
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
    void primeraParteConstructor(){
        
    }
}
