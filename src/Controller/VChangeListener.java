package Controller;

import Model.Model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VChangeListener implements ChangeListener {

    JSlider slider;
    Model model;

    public VChangeListener(Model model, JSlider slider){
        this.model = model;
        this.slider = slider;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
//        this.model.getMedium().set_v(slider.getValue());
//        this.model.updateChart();
        System.out.println("v changed!");
    }
}
