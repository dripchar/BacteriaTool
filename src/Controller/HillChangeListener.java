package Controller;

import Model.Model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class HillChangeListener implements ChangeListener {

    JSlider slider;
    Model model;

    public HillChangeListener(Model model, JSlider slider){
        this.model = model;
        this.slider = slider;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.model.getBacteria().setHill_coeff(slider.getValue());
        this.model.updateChart();
    }
}
