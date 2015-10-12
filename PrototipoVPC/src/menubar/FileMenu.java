package menubar;

import i18n.GUIStr;

import java.awt.event.ActionEvent;

import main.MainWindow;

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

    @Override
    protected void actionPerformedHandler(GUIStr actionName, ActionEvent e) {
        // TODO Auto-generated method stub
        switch(actionName){
        
        }
    }
}
