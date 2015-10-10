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
import i18n.I18nManager;
import main.MainWindow;

public class FileMenu extends JMenu{
    
    MainWindow parentFrame;
    ResourceBundle i18n = I18nManager.manage();
    
    // Acciones del menú Archivo
    JMenuItem openAction = new JMenuItem(i18n.getString("FileMenu.OpenAction"));
    JMenuItem saveAction = new JMenuItem(i18n.getString("FileMenu.SaveAction"));
    JMenuItem saveAsAction = new JMenuItem(i18n.getString("FileMenu.SaveAsAction"));
    JMenuItem closeAction = new JMenuItem(i18n.getString("FileMenu.CloseAction"));
    JMenuItem quitAction = new JMenuItem(i18n.getString("FileMenu.QuitAction"));
    
    public FileMenu(MainWindow parentFrame){
        super(I18nManager.manage().getString("FileMenu"));
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
        
        
        FileDialog openFiles = new FileDialog(parentFrame, i18n.getString("FileDialog.Open"), FileDialog.LOAD);
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
            
        }
        
    }
    private void saveAsActionPerformed(ActionEvent e) { 
        
        FileDialog saveFile = new FileDialog(parentFrame, i18n.getString("FileDialog.Save"), FileDialog.SAVE);
        
    }
    
    private void closeActionPerformed(ActionEvent e) { 
        
        JDesktopPane pane = parentFrame.getPane();
        
        if (pane.getSelectedFrame() != null)
            pane.getSelectedFrame().dispose();

        if (pane.getAllFrames().length == 0)
            setEnabledActions(false);
    }
    
    
    private void quitActionPerformed(ActionEvent e) { 
        
        System.exit(0);
    }
}
