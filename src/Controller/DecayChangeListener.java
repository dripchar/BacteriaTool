package Controller;

import Model.Model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DecayChangeListener implements ChangeListener {

    JSlider slider;
    Model model;

    public DecayChangeListener(Model model, JSlider slider){
        this.model = model;
        this.slider = slider;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.model.getAntibiotic().setDecay_rate(slider.getValue());
        this.model.updateChart();
    }
}
