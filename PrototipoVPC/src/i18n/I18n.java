package i18n;

import java.util.ResourceBundle;

public abstract class I18n {
    
    // TODO: Comprobar para un archivo .properties dado, que tiene todos los
    // strings especificados en GUIStrHash.
    
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
