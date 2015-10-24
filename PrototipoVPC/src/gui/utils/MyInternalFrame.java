package gui.utils;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class MyInternalFrame extends JInternalFrame{

    NamedImage namedImg = null;
    JLabel imgLabel = null;
    
    public MyInternalFrame(NamedImage namedImg){
      super(namedImg.getName(), true, true, true, true);
      
      // TODO: Asegurar que no necesitamos constructores mas flexibles/vacios
      this.namedImg = namedImg;
      this.imgLabel = new JLabel(new ImageIcon(namedImg));
      
      setSize(namedImg.getWidth(), namedImg.getHeight());
      new RegionSelector(imgLabel);
      add(new JScrollPane(imgLabel));
      setVisible(true);     
    }
    
    public void addNamedImage(NamedImage namedImg){
        this.namedImg = namedImg;
    }
    
    public NamedImage getNamedImage() {
        return namedImg;
    }
    
    public JLabel getImageLabel() {
        return imgLabel;
    }
    
}
