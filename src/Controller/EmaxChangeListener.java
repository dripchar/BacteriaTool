package Controller;

import Model.Model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EmaxChangeListener implements ChangeListener {

    JSlider slider;
    Model model;

    public EmaxChangeListener(Model model, JSlider slider){
        this.model = model;
        this.slider = slider;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.model.getBacteria().setE_max(slider.getValue());
        this.model.updateChart();
    }
}
