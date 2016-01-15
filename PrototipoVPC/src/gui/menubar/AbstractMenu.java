package gui.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;

import gui.utils.image.NamedImage;
import i18n.I18n;
import main.MainWindow;
import transform.base.AbstractImageTransformation;
import transform2.base.CoordinatesTransform;

// TODO: Usar enums a nivel global del proyecto en vez de constantes String

@SuppressWarnings("serial")
public abstract class AbstractMenu extends JMenu{
    
    // TODO: Incluir funcionalidad setEnabled??
    
    MainWindow parentFrame;
    
    protected final static String __ = "Separator";
    
    public AbstractMenu(MainWindow parentFrame, String menuName, String[] actionNames){
        super(I18n.getString(menuName));
        this.parentFrame = parentFrame;
    
        // Eventos de menú
        for (String actName : actionNames){
            if (actName != "Separator"){
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
    
    // TODO: Should this go here? rn, used by both ImageMenu and TransformMenu.
    protected void transform(AbstractImageTransformation transformation){
        System.out.println(parentFrame.getFocusedImage());
        
        if (!assertImageSelected()) return;
        
        NamedImage image1 = parentFrame.getFocusedImage();
        
        NamedImage image2 = transformation.getTransformedImage(image1);
        
//        if (parentFrame.getOpt().isOverwrite()){
            // TODO: overwrite focused image.
//            parentFrame.getFocusedImage() = image2;
//        } else {
            parentFrame.createImageFrame(image2);
//        }
    }
    
    // TODO: merge with above function.
    protected void transform(CoordinatesTransform transformation){
        System.out.println(parentFrame.getFocusedImage());
        
        if (!assertImageSelected()) return;
        
        NamedImage image1 = parentFrame.getFocusedImage();
        
        NamedImage image2 = transformation.getTransformedImage(image1);
        
//        if (parentFrame.getOpt().isOverwrite()){
            // TODO: overwrite focused image.
//            parentFrame.getFocusedImage() = image2;
//        } else {
            parentFrame.createImageFrame(image2);
//        }
    }
    
    
    /**
     * Make sure an image is selected. Otherwise, show error and return.
     */
    protected boolean assertImageSelected(){
        if (parentFrame.getFocusedImage() == null){
            parentFrame.showErrorDialog("DialogError.NoSelectedImage");
            return false;
        }
        return true;
    }
   
    
    protected abstract void actionPerformedHandler(String actionName, ActionEvent e);
    
    
}
