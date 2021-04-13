package Controller;

import Model.Model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MICrChangeListener implements ChangeListener {

    JSlider slider;
    Model model;

    public MICrChangeListener(Model model, JSlider slider){
        this.model = model;
        this.slider = slider;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.model.getBacteria().setMIC_R(slider.getValue());
        this.model.updateChart();
    }
}
