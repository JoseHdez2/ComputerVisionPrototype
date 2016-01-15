package gui.dialog;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import gui.dialog.base.ImageDialog;
import gui.utils.image.NamedImage;
import main.MainWindow;
import transform.base.AbstractImageTransformation;
import transform.point.PiecewiseLinearTransformation;
import util.Sys;

public class LinearTransformationDialog extends ImageDialog {

    ArrayList<ArrayList<JTextField>> points = new ArrayList<ArrayList<JTextField>>();
    JPanel panePoints = new JPanel();
    
    public LinearTransformationDialog(String title, MainWindow parent, NamedImage image) {
        super(title, parent, image);
        setTitle("Linear transformation");
        
        /*
         * Points panel 
         */
        
        panePoints.setLayout(new GridLayout(0,3));
        panePoints.setBorder(new TitledBorder("Transformation points"));
        add(panePoints);
        
        // Add initial two points
        for (int i = 0; i < 2; i++) addNewPoint(points.size());
        
        points.get(0).get(0).setText("0");
        points.get(0).get(0).setEditable(false);
        points.get(1).get(0).setText("255");
        points.get(1).get(0).setEditable(false);
        
        repaintPointPanel();
        
        /*
         * Control panel
         */
        
        JPanel paneControl = new JPanel();
        add(paneControl, BorderLayout.SOUTH);
        
        JPanel paneControl1 = new JPanel();
        paneControl1.setBorder(new TitledBorder("Point control"));
        paneControl.add(paneControl1, BorderLayout.NORTH);
        
        JButton btnAddPoint = new JButton("Add point");
        btnAddPoint.addActionListener(listenerAddPoint);
        paneControl1.add(btnAddPoint);
        
        JButton btnDelPoint = new JButton("Delete point");
        btnDelPoint.addActionListener(listenerDelPoint);
        paneControl1.add(btnDelPoint);
        
        JButton btnApply = new JButton("Apply transformation");
        btnApply.addActionListener(listenerApplyTrans);
        paneControl.add(btnApply, BorderLayout.SOUTH);
    }
    
    private void addNewPoint(Integer index){
        ArrayList<JTextField> newPoint = new ArrayList<JTextField>();
        
        newPoint.add(new JTextField(3)); newPoint.add(new JTextField(3));
        points.add(index, newPoint);
    }
    
    private void repaintPointPanel(){
        panePoints.removeAll();
        for (int i = 0; i < points.size(); i++){
            panePoints.add(new JLabel(String.format("Point %d:", i)));
            for (int j = 0; j < 2; j++){
                panePoints.add(points.get(i).get(j));
            }
        }
        panePoints.repaint();
        
    }
    
    ActionListener listenerAddPoint = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            if (points.size() <= 20){
                addNewPoint(points.size()-1);
                
                repaintPointPanel();
            }
        }
        
    };
    
    ActionListener listenerDelPoint = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            if (points.size() > 2){
                points.remove(points.size()-2); // Remove next to last point.
                
                repaintPointPanel();
            }
        }
        
    };
    
    ActionListener listenerApplyTrans = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                transform(getPoints());
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        
    };
    
    private ArrayList<Point> getPoints(){
        ArrayList<Point> pointList = new ArrayList<Point>();
        for (int i = 0; i < points.size(); i++){
            int x = Integer.parseInt(points.get(i).get(0).getText());
            int y = Integer.parseInt(points.get(i).get(1).getText());
            pointList.add(new Point(x, y));
        }
        
        Sys.out(pointList);
        
        return pointList;
    }
    
 // TODO: Should this go here? rn, used by both ImageMenu and TransformMenu.
    protected void transform(ArrayList<Point> points) throws Exception{
        
        if(this.parent.getFocusedImage() == null){
            this.parent.showErrorDialog("DialogError.NoSelectedImage");
            return;
        }
        
        PiecewiseLinearTransformation transformation = new PiecewiseLinearTransformation(points);
        
        NamedImage image1 = this.parent.getFocusedImage();
        
        NamedImage image2 = transformation.getTransformedImage(image1);
        
//        if (parentFrame.getOpt().isOverwrite()){
            // TODO: overwrite focused image.
//            parentFrame.getFocusedImage() = image2;
//        } else {
            this.parent.createImageFrame(image2);
//        }
    }
}
