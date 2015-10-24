package gui.utils;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class MyInternalFrame extends JInternalFrame{

    NamedImage namedImg = null;
    RegionSelector regionSelector = null;
    
    public MyInternalFrame(NamedImage namedImg){
      super(namedImg.getName(), true, true, true, true);
      
      // TODO: Asegurar que no necesitamos constructores mas flexibles/vacios
      this.namedImg = namedImg;
      MyLabel imgLabel = new MyLabel(new ImageIcon(namedImg));
      this.regionSelector = new RegionSelector(imgLabel);
      add(new JScrollPane(imgLabel));
      
      setSize(namedImg.getWidth(), namedImg.getHeight());
      setVisible(true);     
    }
    
    public void addNamedImage(NamedImage namedImg){
        this.namedImg = namedImg;
    }
    
    public NamedImage getNamedImage() {
        return namedImg;
    }
    
    public RegionSelector getSelector() {
        return regionSelector;
    }
    
}