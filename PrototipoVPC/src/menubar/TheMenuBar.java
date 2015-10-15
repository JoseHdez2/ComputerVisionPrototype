package menubar;

import javax.swing.JMenuBar;

import main.MainWindow;

public class TheMenuBar extends JMenuBar {
    
    public TheMenuBar(MainWindow mainWindow){
        super();
        mainWindow.setJMenuBar(this);
        this.add(new FileMenu(mainWindow));
        this.add(new TransformMenu(mainWindow));
    }
}
