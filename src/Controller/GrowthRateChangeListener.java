package Controller;

import Model.*;
import View.View;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GrowthRateChangeListener implements ChangeListener {

    JSlider slider;
    Model model;
    Label text;

    public GrowthRateChangeListener(Model model, JSlider slider, Label text){
        this.model = model;
        this.slider = slider;
        this.text = text;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        double val = ((double) slider.getValue())/100.0;
        this.model.getBacteria().setGrowthRate(val);
        this.text.setText(Double.toString(val));
        this.model.updateChart();
    }
}
