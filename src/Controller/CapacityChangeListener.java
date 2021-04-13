package Controller;

import Model.Model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CapacityChangeListener implements ChangeListener {

    JSlider slider;
    Model model;

    public CapacityChangeListener(Model model, JSlider slider){
        this.model = model;
        this.slider = slider;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.model.getMedium().setMu(slider.getValue());
        this.model.updateChart();
    }
}
