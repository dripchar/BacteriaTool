package Controller;

import Model.Model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AiChangeListener implements ChangeListener {

    JSlider slider;
    Model model;

    public AiChangeListener(Model model, JSlider slider){
        this.model = model;
        this.slider = slider;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.model.getContainer().setAi(slider.getValue());
        this.model.updateChart();
    }
}
