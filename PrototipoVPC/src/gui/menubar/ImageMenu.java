package gui.menubar;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import gui.dialog.BrightnessContrastWombo;
import gui.utils.RegionSelector;
import gui.utils.image.Entropy;
import gui.utils.image.NamedImage;
import i18n.I18n;
import main.MainWindow;
import transform.point.ColorToGrayscale;

@SuppressWarnings("serial")
public class ImageMenu extends AbstractMenu{
    
    final static String[] ACTION_NAMES =
        {
        "ImageMenu.CropSelection",
        "Separator",
        "ImageMenu.ToGrayscale",
        "Separator",
        "ImageMenu.Entropy",
        "ImageMenu.BrightnessContrast"
        };
    
    public ImageMenu(MainWindow parentFrame) {
        super(parentFrame, "ImageMenu", ACTION_NAMES);
    }
    
    
    @SuppressWarnings("incomplete-switch")
    @Override
    protected void actionPerformedHandler(String actionName, ActionEvent e) {

        switch(actionName){
        case "ImageMenu.CropSelection":
            cropSelectionActionPerformed(e);
            break;
        case "ImageMenu.ToGrayscale":
            toGrayscaleActionPerformed(e);
            break;
        case "ImageMenu.Entropy":
            entropyActionPerformed(e);
            break;
        case "ImageMenu.BrightnessContrast":
            brightnessAndContrastActionPerformed(e);
            break;
        }
    }
    
    private void cropSelectionActionPerformed(ActionEvent e) {
    
        NamedImage image = null;
        RegionSelector selection = parentFrame.getFocusedSelector();
        Point origin = selection.getOrigin();
        Point end = selection.getEnd();
        
            
        if (origin != null && end != null) {
            
            int x = (int)Math.min(origin.getX(),end.getX());
            int y = (int)Math.min(origin.getY(),end.getY());
            int width = (int)Math.max(origin.getX(),end.getX()) - x;
            int height = (int)Math.max(origin.getY(),end.getY()) - y;
            
            image = parentFrame.getFocusedImage();
            BufferedImage bi = image.getSubimage(x, y, width, height);
            NamedImage image2 = new NamedImage(bi,image.getFile());
            
            parentFrame.createImageFrame(image2);
        }
    }
    
    private void toGrayscaleActionPerformed(ActionEvent e){
        if (!assertImageSelected()) return;
        // TODO: Create OperationArgumentExceptionHandler class or something
        // That has this and assertImageSelected()
        if(parentFrame.getFocusedImage().isGrayscale()){
            parentFrame.showErrorDialog("DialogError.GrayscaleImage");
            return;
        }
        
        transform(new ColorToGrayscale());   
    }
    
    private void entropyActionPerformed(ActionEvent e){
        
        if (!assertImageSelected()) return;
        
        float entropy = Entropy.calculate(parentFrame.getFocusedImage());
        
        JOptionPane.showMessageDialog(parentFrame,
                I18n.getString("ImageMenu.EntropyText") + " " + entropy,
                I18n.getString("ImageMenu.Entropy"),
                JOptionPane.PLAIN_MESSAGE); 
    }
    
    private void brightnessAndContrastActionPerformed(ActionEvent e) {
    
        NamedImage image = parentFrame.getFocusedImage();
        BrightnessContrastWombo dialog = null;
        
        if (image == null)
            parentFrame.showErrorDialog("DialogError.NoSelectedImage");
        else 
            dialog = new BrightnessContrastWombo(parentFrame,image);    
    }
        
}
