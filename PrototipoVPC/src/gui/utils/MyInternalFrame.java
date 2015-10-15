package gui.utils;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class MyInternalFrame extends JInternalFrame{

    NamedImage namedImg = null;
    
    public MyInternalFrame(NamedImage namedImg){
      super(namedImg.getName(), true, true, true, true);
      // TODO: Asegurar que no necesitamos constructores mas flexibles/vacios
      this.namedImg = namedImg;
      setSize(namedImg.getWidth(), namedImg.getHeight());
      add(new JScrollPane(new JLabel(new ImageIcon(namedImg))));
      setVisible(true);
    }
    
    public void addNamedImage(NamedImage namedImg){
        this.namedImg = namedImg;
    }
    
    public NamedImage getNamedImage() {
        return namedImg;
    }
}
