package gui.dialog.base;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gui.utils.MyInternalFrame;
import i18n.I18n;
import main.MainWindow;

public class SelectionDialog {

    String[] images = null;
    protected MainWindow parent = null;
    protected JComboBox<String> comboBox1 = null;
    protected JComboBox<String> comboBox2 = null;
    protected int option;
    
    public SelectionDialog(MainWindow parent) {
        
        this.parent = parent;

        ArrayList<String> imagesList = new ArrayList<String>();
        for (JInternalFrame f: parent.getPane().getAllFrames()) {
            MyInternalFrame frame = (MyInternalFrame)f;
            imagesList.add(frame.getTitle());
        }
        
        images = new String[imagesList.size()];
        images = imagesList.toArray(images);
        
        comboBox1 = new JComboBox<>(images);
        comboBox2 = new JComboBox<>(images);
    }
    
    private JPanel createPanel(String label1, String label2) {
        
        JPanel panel = new JPanel();
        
        panel.add(new JLabel(label1));
        panel.add(comboBox1);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(new JLabel(label2));
        panel.add(comboBox2);
        
        return panel;
    }
    
    protected void show(String title, String label1, String label2) {
        
        JPanel panel = createPanel(label1, label2);
        
        option = JOptionPane.showConfirmDialog(null, panel, 
                I18n.getString(title), 
                JOptionPane.OK_CANCEL_OPTION);
    }
}
