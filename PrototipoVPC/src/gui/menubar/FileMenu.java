package gui.menubar;

import java.awt.Component;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FilenameFilter;

import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

import gui.utils.NamedImage;
import gui.utils.NamedImageCreator;
import i18n.GUIStr;
import i18n.I18n;
import main.MainWindow;


@SuppressWarnings("serial")
public class FileMenu extends AbstractMenu {
    
    final static GUIStr[] ACTION_NAMES =
        {
        GUIStr.FILE_MENU_OPEN_ACTION,
        GUIStr.SEPARATOR,
        GUIStr.FILE_MENU_SAVE_ACTION,
        GUIStr.FILE_MENU_SAVE_AS_ACTION,
        GUIStr.SEPARATOR,
        GUIStr.FILE_MENU_CLOSE_ACTION,
        GUIStr.FILE_MENU_QUIT_ACTION
        };
    
    public FileMenu(MainWindow parentFrame){
        super(parentFrame, GUIStr.FILE_MENU, ACTION_NAMES);
    }

    @SuppressWarnings("incomplete-switch")
    @Override
    protected void actionPerformedHandler(GUIStr actionName, ActionEvent e) {

        switch(actionName){
        case FILE_MENU_OPEN_ACTION:
            openActionPerformed(e);
            break;
        case FILE_MENU_SAVE_ACTION:
            saveActionPerformed(e);
            break;
        case FILE_MENU_SAVE_AS_ACTION:
            saveAsActionPerformed(e);
            break;
        case FILE_MENU_CLOSE_ACTION:
            closeActionPerformed(e);
            break;
        case FILE_MENU_QUIT_ACTION:
            quitActionPerformed(e);
            break;
        }
    }
    
   
    
    private void setEnabledActions(boolean cond) {
        // TODO: No funciona.
        // TODO: Forma de iterar de forma directa sobre los menuItems.
        for (Component comp : this.getComponents()){
            
            if (!comp.getClass().getName().equals(MyMenuItem.class))
                continue;
            
            MyMenuItem menuItem = (MyMenuItem)comp;
            
            // TODO: Seria mejor con un case?
            if( menuItem.getStringId().equals(GUIStr.FILE_MENU_SAVE_ACTION) ||
                menuItem.getStringId().equals(GUIStr.FILE_MENU_SAVE_AS_ACTION) ||
                menuItem.getStringId().equals(GUIStr.FILE_MENU_CLOSE_ACTION)){
                
                menuItem.setEnabled(cond);
            }
        }
    }

    /*
     * Menu actions
     */
    
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
        
        NamedImage image = parentFrame.getFocusedImage();
        
        if (image != null) {
            try {
                ImageIO.write(image, image.getExtension(), image.getFile());
            }
            catch (Exception save) {
                save.printStackTrace();
            }            
        }
        
    }

    private void saveAsActionPerformed(ActionEvent e) { 
        
        FileDialog saveFile = new FileDialog(parentFrame, I18n.getString(GUIStr.FILE_DIALOG_SAVE_AS), FileDialog.SAVE);
        // TODO Terminar esto
    }
    
    private void closeActionPerformed(ActionEvent e) { 
        // TODO: que se actualice la vista cada vez que se abra el FileMenuOld
        // Para poder (des)habilitar segun haya una imagen en el foco.
        JDesktopPane pane = parentFrame.getPane();
        
        if (pane.getSelectedFrame() != null){
            pane.getSelectedFrame().dispose();
        } 
//        else {
//            setEnabledActions(false);
//        }

        if (pane.getAllFrames().length == 0)
            setEnabledActions(false);
    }
    
    
    private void quitActionPerformed(ActionEvent e) { 
        
        System.exit(0);
    }
}
