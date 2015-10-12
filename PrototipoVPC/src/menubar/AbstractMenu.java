package menubar;

import i18n.GUIStr;
import i18n.I18n;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import main.MainWindow;

// TODO: Usar enums a nivel global del proyecto en vez de constantes String

public abstract class AbstractMenu extends JMenu{
    
    // TODO: Incluir funcionalidad setEnabled??
    
    MainWindow parentFrame;
    ArrayList<MyMenuItem> actions = new ArrayList<MyMenuItem>();
    
    public static final String SEPARATOR_STRING = "-";
    
    public AbstractMenu(MainWindow parentFrame, GUIStr menuName, GUIStr[] actionNames){
        super(I18n.getString(menuName));
        this.parentFrame = parentFrame;
    
        // Eventos de menú
        for (GUIStr actName : actionNames){
            if (actName != GUIStr.SEPARATOR){
                MyMenuItem action = new MyMenuItem(actName);
                action.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        actionPerformedHandler(actName, e);
                    }
                });
                this.add(action);
            } else {
                this.addSeparator();
            }
        }
    }
    
    protected abstract void actionPerformedHandler(GUIStr actionName, ActionEvent e);
    
    
}
