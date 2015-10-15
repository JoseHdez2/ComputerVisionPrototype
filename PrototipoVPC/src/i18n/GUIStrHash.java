package i18n;

import java.util.HashMap;
import java.util.Map;

public abstract class GUIStrHash { 
    
    private static final Map<GUIStr, String> hash;
    static
    {
        hash = new HashMap<GUIStr, String>();
        hash.put(GUIStr.MAIN_WINDOW_TITLE, "MainWindow.Title");
        hash.put(GUIStr.FILE_MENU, "FileMenu");
        hash.put(GUIStr.FILE_MENU_OPEN_ACTION, "FileMenu.OpenAction");
        hash.put(GUIStr.FILE_MENU_SAVE_ACTION, "FileMenu.SaveAction");
        hash.put(GUIStr.FILE_MENU_SAVE_AS_ACTION, "FileMenu.SaveAsAction");
        hash.put(GUIStr.FILE_MENU_CLOSE_ACTION, "FileMenu.CloseAction");
        hash.put(GUIStr.FILE_MENU_QUIT_ACTION, "FileMenu.QuitAction");
        hash.put(GUIStr.FILE_DIALOG_OPEN, "FileDialog.Open");
        hash.put(GUIStr.FILE_DIALOG_SAVE_AS, "FileDialog.SaveAs");
        hash.put(GUIStr.TRANSFORM_DIALOG_EQUALIZE, "TransformDialog.Equalize");
    }
    
    public static String get(GUIStr stringId){
        return hash.get(stringId);
    }
}

