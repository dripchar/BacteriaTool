package Controller;

import Model.Model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class LambdaChangeListener implements ChangeListener {

    JSlider slider;
    Model model;
    Label text;

    public LambdaChangeListener(Model model, JSlider slider, Label text){
        this.model = model;
        this.slider = slider;
        this.text = text;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        double val = slider.getValue();
        this.model.getInflow().setLambda(val);
        this.text.setText(Double.toString(val));
        this.model.updateChart();
    }
}
