package menubar;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import gui_utils.NamedImage;
import gui_utils.NamedImageCreator;
import main.MainWindow;

public class FileMenu extends JMenu{
    
    MainWindow parentFrame;

    JDesktopPane pane;
    
    // Acciones del menú Archivo
    JMenuItem openAction = new JMenuItem("Abrir...");
    JMenuItem saveAction = new JMenuItem("Guardar");
    JMenuItem saveAsAction = new JMenuItem("Guardar como...");
    JMenuItem closeAction = new JMenuItem("Cerrar");
    JMenuItem quitAction = new JMenuItem("Salir");
    
    public FileMenu(MainWindow parentFrame){
        super("Archivo");
        this.parentFrame = parentFrame;
    
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
        
        setEnabledActions(false);
    }
    
    
    private void setEnabledActions(boolean cond) {
        
        // TODO: poner a la condicion cuando esten implementadas
        saveAction.setEnabled(false);
        saveAsAction.setEnabled(false);
        closeAction.setEnabled(cond);
    }
    
    
    
    // Acciones del menú Archivo
    
    private void openActionPerformed(ActionEvent e) {
        
        
        FileDialog openFile = new FileDialog(parentFrame, "Cargando", FileDialog.LOAD);
        openFile.setDirectory(System.getProperty("user.dir"));
        openFile.setVisible(true);
        
        String completeImagePath = openFile.getDirectory() + File.separator + openFile.getFile();
        
        File file = new File(completeImagePath);
        
        NamedImage image = NamedImageCreator.create(file);
        
        parentFrame.createImageFrame(image);
        
        setEnabledActions(true);

        return;
        
    }
    
    private void saveActionPerformed(ActionEvent e) { }
    private void saveAsActionPerformed(ActionEvent e) { }
    
    private void closeActionPerformed(ActionEvent e) { 
        
        parentFrame.getPane().getSelectedFrame().dispose();

        if (parentFrame.getPane().getAllFrames().length == 0)
            setEnabledActions(false);
    }
    
    
    private void quitActionPerformed(ActionEvent e) { 
        
        System.exit(0);
    }
    
    void primeraParteConstructor(){

    }
}
