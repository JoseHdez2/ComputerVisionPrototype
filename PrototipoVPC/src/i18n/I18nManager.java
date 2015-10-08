package i18n;

import java.util.ResourceBundle;

public abstract class I18nManager {
    
    public static ResourceBundle manage(){

        if (System.getProperty("user.language") == "es")
            return ResourceBundle.getBundle("i18n.i18nBundle_es");
        else
            return ResourceBundle.getBundle("i18n.i18nBundle_en");
    }
}
