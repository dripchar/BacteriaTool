package Controller;

import Model.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class BetaChangeListener implements ChangeListener {

    JSlider slider;
    Model model;
    Label text;

    public BetaChangeListener(Model model, JSlider slider, Label text){
        this.model = model;
        this.slider = slider;
        this.text = text;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        double val = ((double)slider.getValue())/1000.0;
        this.model.getBacteria().setBeta(val);
        this.text.setText(Double.toString(val));
        this.model.updateChart();
    }
}
