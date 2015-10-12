package i18n;

import java.util.HashMap;
import java.util.ResourceBundle;

public abstract class I18n {
    
    // TODO: Usar esto como punto global de traduccion de strings GUI a enums???
    
    // TODO: Ahora mismo TIENE que coincidir las Strings de en.properties con
    // las constantes String en cada una de las clases (ej. FileMenu, ...).
    
    private static ResourceBundle manage(){
        // TODO: Restrictivo para el que quiera un idioma distinto al de su OS.
        // TODO: Hacer una configuracion para que el usuario decida.
        if (System.getProperty("user.language") == "es")
            return ResourceBundle.getBundle("i18n.i18nBundle_es");
        else
            return ResourceBundle.getBundle("i18n.i18nBundle_en");
    }
    
    public static String getString(GUIStr stringId){
        return manage().getString(GUIStrHash.get(stringId));
    }
}
