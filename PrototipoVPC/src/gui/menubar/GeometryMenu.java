package gui.menubar;

import java.awt.event.ActionEvent;

import gui.dialog.RotationDialog;
import gui.dialog.RotationPaintDialog;
import gui.dialog.ScaleDialog;
import main.MainWindow;
import transform2.MirrorHorizontal;
import transform2.MirrorVertical;
import transform2.Transpose;


@SuppressWarnings("serial")
public class GeometryMenu extends AbstractMenu {
    
    final static String vMirror = "GeometryMenu.VerticalMirror";
    final static String hMirror = "GeometryMenu.HorizontalMirror";
    final static String transpose = "GeometryMenu.Transpose";
    final static String scale = "GeometryMenu.Scale";
    final static String rotationPaint = "GeometryMenu.RotationPaint";
    final static String rotation = "GeometryMenu.Rotation";
    
    final static String[] ACTION_NAMES =
        { vMirror, hMirror, transpose, __, scale, rotationPaint, rotation };
    
    public GeometryMenu(MainWindow parentFrame){
        super(parentFrame, "GeometryMenu", ACTION_NAMES);
    }

    @Override
    protected void actionPerformedHandler(String actionName, ActionEvent e) {
        
        switch(actionName){
        case vMirror:
            verticalMirrorActionPerformed(e);
            break;
        case hMirror:
            horizontalMirrorActionPerformed(e);
            break;
        case transpose:
            transposeActionPerformed(e);
            break;  
        case scale:
            scaleActionPerformed(e);
            break;    
        case rotationPaint:
            rotationAndPaintActionPerformed(e);
            break;                            
        case rotation:
            rotationActionPerformed(e);
            break;                
        }
    }
    
    /*
     * Menu actions
     */
    
    private void verticalMirrorActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        transform(new MirrorVertical(parentFrame.getFocusedImage()));
    }
    
    private void horizontalMirrorActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        transform(new MirrorHorizontal(parentFrame.getFocusedImage()));   
    }
    
    private void transposeActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        transform(new Transpose(parentFrame.getFocusedImage()));   
    }    
    
    private void scaleActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        ScaleDialog d = new ScaleDialog(parentFrame,parentFrame.getFocusedImage());
    }
    
    private void rotationAndPaintActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        RotationPaintDialog d = new RotationPaintDialog(parentFrame,parentFrame.getFocusedImage());
    }        
    
    private void rotationActionPerformed(ActionEvent e) {
        if (!assertImageSelected()) return;
        RotationDialog d = new RotationDialog(parentFrame,parentFrame.getFocusedImage());
    }        
}
