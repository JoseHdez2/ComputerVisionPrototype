package gui.menubar;

import java.awt.Component;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FilenameFilter;

import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

import gui.utils.image.NamedImage;
import gui.utils.image.NamedImageCreator;
import i18n.I18n;
import main.MainWindow;


@SuppressWarnings("serial")
public class FileMenu extends AbstractMenu {
    
    final static String open = "FileMenu.OpenAction";
    final static String save = "FileMenu.SaveAction";
    final static String saveAs = "FileMenu.SaveAsAction";
    final static String close = "FileMenu.CloseAction";
    final static String quit = "FileMenu.QuitAction";
    
    final static String[] ACTION_NAMES =
        {open, __, save, saveAs, __, close, quit};
    
    public FileMenu(MainWindow parentFrame){
        super(parentFrame, "FileMenu", ACTION_NAMES);
    }

    @SuppressWarnings("incomplete-switch")
    @Override
    protected void actionPerformedHandler(String actionName, ActionEvent e) {

        switch(actionName){
        case open:
            openActionPerformed(e);
            break;
        case save:
            saveActionPerformed(e);
            break;
        case saveAs:
            saveAsActionPerformed(e);
            break;
        case close:
            closeActionPerformed(e);
            break;
        case quit:
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
            if( menuItem.getStringId().equals(save) ||
                menuItem.getStringId().equals(saveAs) ||
                menuItem.getStringId().equals(close)){
                
                menuItem.setEnabled(cond);
            }
        }
    }

    /*
     * Menu actions
     */
    
    private void openActionPerformed(ActionEvent e) {
        
        FileDialog openFiles = new FileDialog(parentFrame, I18n.getString(open), FileDialog.LOAD);
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
        
        NamedImage image = parentFrame.getFocusedImage();
        
        FileDialog saveFile = new FileDialog(parentFrame, I18n.getString(saveAs), FileDialog.SAVE);
        if (image != null) {
            saveFile.setDirectory(image.getDirectory());
        }
        saveFile.setVisible(true);
        
        String filePath = saveFile.getDirectory() + saveFile.getFile();
        File file = new File(filePath);
        
        if ((image != null) && (file != null)) {
            try {
                ImageIO.write(image, image.getExtension(), file);
            }
            catch (Exception save) {
                save.printStackTrace();
            }
        }
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
