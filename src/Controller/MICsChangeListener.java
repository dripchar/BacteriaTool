package Controller;

import Model.Model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MICsChangeListener implements ChangeListener {

    JSlider slider;
    Model model;

    public MICsChangeListener(Model model, JSlider slider){
        this.model = model;
        this.slider = slider;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.model.getBacteria().setMIC_S(slider.getValue());
        this.model.updateChart();
    }
}
