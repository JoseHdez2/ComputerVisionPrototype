package gui.dialog;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import i18n.GUIStr;

public class WomboCombo extends JPanel{
    
    // Whether or not all slider-spinner couples use the same value.
    // Useful for grayscale images, where RGB components are the same.
    boolean boundWombos;
    // TODO: Detect grayscale images and use 1 subwombo instead of 3.
    
    final int MIN_VAL = 0;
    final int MAX_VAL = 255;
    final int STEP_SIZE = 1;
    
    GUIStr title;
    int subwombos;
    int[] values;
    JSlider[] sliders = null;
    JSpinner[] spinners = null;
    
    public WomboCombo(GUIStr title, int subWombos, int[] values, boolean boundWombos){
        this.title = title;
        this.subwombos = subWombos;
        
        values = new int[subWombos];
        sliders = new JSlider[subWombos];
        spinners = new JSpinner[subWombos];
        
        for(int i = 0; i < subwombos; i++){
            final int innerI = i; // TODO: ???????
            sliders[i] = new JSlider(JSlider.HORIZONTAL, MIN_VAL, MAX_VAL, values[i]);
            sliders[i].addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                   updateValue(innerI, sliders[innerI].getValue());
                }
             });
            spinners[i] = new JSpinner(new SpinnerNumberModel(values[i],MIN_VAL,MAX_VAL,STEP_SIZE));
            spinners[i].addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                   updateValue(innerI, sliders[innerI].getValue());
                }
             });
        }
        
        // If subWombos are bound, update all to the first value (in case they are different).
        if(boundWombos) 
            for(int j = 0; j < subwombos; j++)
                updateSubWombo(j,values[0]);
    }
    
    /**
     * Unless specified, wombos will be unbound.
     */
    public WomboCombo(GUIStr title, int subWombos, int[] values){
        this(title, subWombos, values, false);
    }
    
    /**
     * Update one or all subWombos, depending on whether subWombos are bound or not.
     * @param i SubWombo index. (Ignored in case of bound subWombos)
     */
    private void updateValue(int i, int value){
        if(boundWombos)
            for(int j = 0; j < subwombos; j++)
                updateSubWombo(j,value);
        else
            updateSubWombo(i, value);
    }
    
    /**
     * Update a slider-spinner pair (subWombo).
     * @param i Index of pair.
     */
    private void updateSubWombo(int i, int value){
        sliders[i].setValue(value);
        spinners[i].setValue(value);
    }
    
    /*
     * Getters and setters.
     */
    
    public int get(int i){
        return sliders[i].getValue();
    }
    
    public void set(int i, int value){
        updateValue(i, value);
    }
}
