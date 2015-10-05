package gui_utils;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class MyInternalFrame extends JInternalFrame{

    NamedImage namedImg = null;
    
    public MyInternalFrame(NamedImage namedImg){
      super(namedImg.getName(), true, true, true, true);
      setSize(namedImg.getWidth(), namedImg.getHeight());
      add(new JScrollPane(new JLabel(new ImageIcon(namedImg))));
      setVisible(true);
    }
    
    public void addNamedImage(NamedImage namedImg){
        this.namedImg = namedImg;
    }
}
