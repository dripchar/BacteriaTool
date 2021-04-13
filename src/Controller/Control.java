package Controller;

import View.View;
import Model.Model;
import org.jfree.chart.JFreeChart;

import java.util.ArrayList;


public class Control {

    private Model model;
    private View view;


    public Control(Model m, View v){
        this.model = m;
        this.view = v;
    }

    public void makeGraph(){
        //Make sure model's equation is called before this function is invoked
        ArrayList<JFreeChart> line_graph = model.buildGraph();
        view.setChart1(line_graph.get(0));
        view.setChart2(line_graph.get(1));
        view.setChart3(line_graph.get(2));
        view.buildGUI();
    }

}
