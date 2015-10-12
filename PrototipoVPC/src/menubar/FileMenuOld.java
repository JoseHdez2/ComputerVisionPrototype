package menubar;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ResourceBundle;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import gui_utils.NamedImage;
import gui_utils.NamedImageCreator;
import i18n.GUIStr;
import i18n.I18n;
import main.MainWindow;

public class FileMenuOld extends JMenu{
    
    MainWindow parentFrame;
    
    // Acciones del menú Archivo
    JMenuItem openAction = new JMenuItem(I18n.getString(GUIStr.FILE_MENU_OPEN_ACTION));
    JMenuItem saveAction = new JMenuItem(I18n.getString(GUIStr.FILE_MENU_SAVE_ACTION));
    JMenuItem saveAsAction = new JMenuItem(I18n.getString(GUIStr.FILE_MENU_SAVE_AS_ACTION));
    JMenuItem closeAction = new JMenuItem(I18n.getString(GUIStr.FILE_MENU_CLOSE_ACTION));
    JMenuItem quitAction = new JMenuItem(I18n.getString(GUIStr.FILE_MENU_QUIT_ACTION));
    
    public FileMenuOld(MainWindow parentFrame){
        super(I18n.getString(GUIStr.FILE_MENU));
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
        
        saveAction.setEnabled(cond);
        saveAsAction.setEnabled(cond);
        closeAction.setEnabled(cond);
    }
    
    
    
    // Acciones del menú Archivo
    
    private void openActionPerformed(ActionEvent e) {
        
        
        FileDialog openFiles = new FileDialog(parentFrame, I18n.getString(GUIStr.FILE_DIALOG_OPEN), FileDialog.LOAD);
        openFiles.setFilenameFilter(new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png");
            }
        });
        openFiles.setDirectory(System.getProperty("user.dir"));
        openFiles.setMultipleMode(true);
        openFiles.setVisible(true);
         
        File files[] = openFiles.getFiles();
        
        for (File file : files) {
            NamedImage image = NamedImageCreator.create(file);
            parentFrame.createImageFrame(image);
        }
            
        if (files.length > 0)
            setEnabledActions(true);
    }
    
    private void saveActionPerformed(ActionEvent e) { 
        
        JDesktopPane pane = parentFrame.getPane();
        
        if (pane.getSelectedFrame() != null) {
            // TODO: Implementar el guardado
        }
        
    }
    private void saveAsActionPerformed(ActionEvent e) { 
        
        FileDialog saveFile = new FileDialog(parentFrame, I18n.getString(GUIStr.FILE_DIALOG_SAVE_AS), FileDialog.SAVE);
        
    }
    
    private void closeActionPerformed(ActionEvent e) { 
        // TODO: que se actualice la vista cada vez que se abra el FileMenuOld
        // Para poder (des)habilitar segun haya una imagen en el foco.
        JDesktopPane pane = parentFrame.getPane();
        
        if (pane.getSelectedFrame() != null){
            pane.getSelectedFrame().dispose();
        } else {
            setEnabledActions(false);
        }

//        if (pane.getAllFrames().length == 0)
//            setEnabledActions(false);
    }
    
    
    private void quitActionPerformed(ActionEvent e) { 
        
        System.exit(0);
    }
}
