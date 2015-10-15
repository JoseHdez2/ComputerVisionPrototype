package gui.menubar;

import javax.swing.JMenuBar;

import main.MainWindow;

@SuppressWarnings("serial")
public class TheMenuBar extends JMenuBar {
    
    public TheMenuBar(MainWindow mainWindow){
        super();
        mainWindow.setJMenuBar(this);
        this.add(new FileMenu(mainWindow));
        this.add(new TransformMenu(mainWindow));
    }
}
