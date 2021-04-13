package Controller;

import Model.Model;
import org.jfree.text.TextBox;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class AlphaChangeListener implements ChangeListener {

    JSlider slider;
    Model model;
    Label text;

    public AlphaChangeListener(Model model, JSlider slider, Label text){
        this.model = model;
        this.slider = slider;
        this.text = text;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        double val = ((double)slider.getValue())/100.0;
        this.model.getBacteria().setAlpha(val);
        this.text.setText(Double.toString(val));

        this.model.updateChart();
    }
}
