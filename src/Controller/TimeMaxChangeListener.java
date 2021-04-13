package Controller;

import Model.Model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class TimeMaxChangeListener implements ChangeListener {

    JSlider slider;
    Model model;
    Label text;

    public TimeMaxChangeListener(Model model, JSlider slider, Label time_max_text){
        this.model = model;
        this.slider = slider;
        this.text = time_max_text;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //this.model.setTime_max(slider.getValue());
        text.setText(Double.toString(slider.getValue()));
        this.model.updateChart();
    }
}
