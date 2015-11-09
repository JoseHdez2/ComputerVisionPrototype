package gui.utils;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;

import gui.menubar.StatusBar;
import gui.utils.image.NamedImage;

@SuppressWarnings("serial")
public class MyInternalFrame extends JInternalFrame{

    NamedImage namedImg = null;
    RegionSelector regionSelector = null;
    
    public MyInternalFrame(NamedImage namedImg, StatusBar statusbar){
      super(namedImg.getName(), true, true, true, true);
      
      // TODO: Asegurar que no necesitamos constructores mas flexibles/vacios
      this.namedImg = namedImg;
      MyLabel imgLabel = new MyLabel(new ImageIcon(namedImg));
      this.regionSelector = new RegionSelector(namedImg, imgLabel, statusbar);
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