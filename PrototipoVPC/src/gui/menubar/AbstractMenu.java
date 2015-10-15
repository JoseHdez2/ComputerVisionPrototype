package gui.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;

import i18n.GUIStr;
import i18n.I18n;
import main.MainWindow;

// TODO: Usar enums a nivel global del proyecto en vez de constantes String

public abstract class AbstractMenu extends JMenu{
    
    // TODO: Incluir funcionalidad setEnabled??
    
    MainWindow parentFrame;
    
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
    
    // TODO: Problema: Hacer un iterador que solo itere por los 
    /*
    public Iterator<MyMenuItem> myMenuItemIterator(){
        Iterator<MyMenuItem> it = new Iterator<MyMenuItem>() {

            private int currentIndex = 0;

            public Iterator<MyMenuItem>(){
                
            }
            
            public boolean hasNext() {
                return currentIndex < getComponentCount()
                return currentIndex < currentSize && arrayList[currentIndex] != null;
            }

            public MyMenuItem next() {
                return arrayList[currentIndex++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
    */
}
