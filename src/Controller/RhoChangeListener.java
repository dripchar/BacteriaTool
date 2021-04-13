package Controller;

import Model.Model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RhoChangeListener implements ChangeListener {

    JSlider slider;
    Model model;

    public RhoChangeListener(Model model, JSlider slider){
        this.model = model;
        this.slider = slider;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.model.getMedium().setRho(slider.getValue());
        this.model.updateChart();
    }
}
