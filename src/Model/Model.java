package Model;

import View.View;
import javafx.scene.chart.NumberAxis;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.NumberTickUnitSource;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.Dataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;

public class Model {


    private Antibiotic antibiotic;
    private Bacteria bacteria;
    private Container container;
    private Inflow inflow;
    private ArrayList<JFreeChart> charts;
    private View view;
    double time_max = 200.0;
    private JFreeChart chart1;
    private JFreeChart chart2;
    private JFreeChart chart3;
    Equation equation;


    public Model(Antibiotic a, Bacteria b, Container c, Inflow i){
        this.antibiotic = a;
        this.bacteria = b;
        this.container = c;
        this.inflow = i;
    }

    public void setView(View v){
        this.view = v;
    }

    private ArrayList<XYSeries> createDataset(){
        double S = 1.0; // # of sensitive bacteria
        double R = 1.0; // # of resistant bacteria
        double A = 0.0; // amount of antibiotics
        XYSeries r_dataset = new XYSeries("Resistant Bacteria");
        XYSeries s_dataset = new XYSeries("Sensitive Bacteria");
        XYSeries p_dataset = new XYSeries("Ratio of Bacteria");
        XYSeries a_dataset = new XYSeries("Antibiotics in Tank");

        r_dataset.add(R, 0.0);
        s_dataset.add(S,0.0);
        s_dataset.add(R/(R+S),0.0);
        a_dataset.add(0.0, A);


        for(double time=0.1; time<400.0; time+=0.1){

            double N = equation.sumBacteria(S, R);
            double Vt = equation.getVt(this.container.initial_volume, this.inflow.rate_in, time);
            double Nmax = equation.getNmaxt(this.inflow.medium.carry_capacity, Vt);
            double At = equation.getAt(time, this.container.initial_antibiotics, this.inflow.rate_antibiotic_in,
                    this.antibiotic.decay_rate);
            double Es = equation.getEs(this.bacteria.E_max, At, Vt, this.bacteria.hill_coeff, this.bacteria.MIC_S);
            double Er = equation.getEr(this.bacteria.E_max, At, Vt, this.bacteria.hill_coeff, this.bacteria.MIC_R);

            S += equation.SensitiveFunction(time, this.bacteria.growth_rate, N, Nmax, Es, S, this.bacteria.gene_transfer_rate, R,
            this.inflow.rate_in, this.inflow.medium.percent_Rbact, this.inflow.medium.bact_conc);


            R += equation.ResistantFunction(time, this.bacteria.growth_rate, this.bacteria.resistance_fitness_cost,
                    N, Nmax, Er, R, this.bacteria.gene_transfer_rate, S, this.inflow.rate_in, this.inflow.medium.percent_Rbact,
                    this.inflow.medium.bact_conc);

            A+= getInflow().rate_antibiotic_in*24.0/10.0 - this.antibiotic.decay_rate*24.0/10;

            r_dataset.add(time, R);
            s_dataset.add(time, S);
            p_dataset.add(time, R/(R+S));
            a_dataset.add(time, A);

        }
        r_dataset.add(400.0, R);
        s_dataset.add(400.0, S);
        p_dataset.add(400.0, R/(R+S));
        a_dataset.add(400.0, A);

        ArrayList<XYSeries> list = new ArrayList();
        list.add(r_dataset);
        list.add(s_dataset);
        list.add(p_dataset);
        list.add(a_dataset);
        return list;
    }

    private XYSeries createAntibioticDataset(){
        double S = 1.0; // # of sensitive bacteria
        double R = 1.0; // # of resistant bacteria
        XYSeries a_dataset = new XYSeries("Resistant Bacteria");


        for(double rate_antibiotics_in=0.0; rate_antibiotics_in<=20000; rate_antibiotics_in++) {
            S=1.0; R=1.0;
            for (double time = 0.1; time < 90.0*24.0/10.0; time += .1) {

                double N = equation.sumBacteria(S, R);
                double Vt = equation.getVt(this.container.initial_volume, this.inflow.rate_in, time);
                double Nmax = equation.getNmaxt(this.inflow.medium.carry_capacity, Vt);
                double At = equation.getAt(time, this.container.initial_antibiotics, rate_antibiotics_in*24.0/10.0,
                        this.antibiotic.decay_rate);
                double Es = equation.getEs(this.bacteria.E_max, At, Vt, this.bacteria.hill_coeff, this.bacteria.MIC_S);
                double Er = equation.getEr(this.bacteria.E_max, At, Vt, this.bacteria.hill_coeff, this.bacteria.MIC_R);

                S += equation.SensitiveFunction(time, this.bacteria.growth_rate, N, Nmax, Es, S, this.bacteria.gene_transfer_rate, R,
                        this.inflow.rate_in, this.inflow.medium.percent_Rbact, this.inflow.medium.bact_conc);


                R += equation.ResistantFunction(time, this.bacteria.growth_rate, this.bacteria.resistance_fitness_cost,
                        N, Nmax, Er, R, this.bacteria.gene_transfer_rate, S, this.inflow.rate_in, this.inflow.medium.percent_Rbact,
                        this.inflow.medium.bact_conc);

            }
            a_dataset.add(rate_antibiotics_in, R/(R+S));
        }

        return a_dataset;
    }

    public ArrayList<JFreeChart> buildGraph(){
        ArrayList<JFreeChart> charts = new ArrayList<>();

        ArrayList<XYSeries> datasets = createDataset();

        XYSeriesCollection chart1_data = new XYSeriesCollection(datasets.get(0));
        chart1_data.addSeries(datasets.get(1));
        XYSeriesCollection ratio_dataset = new XYSeriesCollection(datasets.get(2));
        XYSeriesCollection antibiotic_dataset = new XYSeriesCollection(createAntibioticDataset());


        chart1 = ChartFactory.createXYLineChart(
                "Change of Sensitive and Resistant Bacteria with Respect to Time", // Chart title
                "Time (days)", // X-Axis Label
                "Number of Bacteria (CFU)", // Y-Axis Label
                chart1_data, PlotOrientation.VERTICAL,
                true,true,false
        );

        chart2 = ChartFactory.createXYLineChart(
                "Resistant Bacteria / Total Bacteria vs Time", // Chart title
                "Time (days)", // X-Axis Label
                "% Resistant Bacteria", // Y-Axis Label
                ratio_dataset, PlotOrientation.VERTICAL,
                true,true,false
        );

        chart3 = ChartFactory.createXYLineChart(
                "Rate Antibiotics In vs Proportion of Resistant Bacteria in Tank", // Chart title
                "Rate Antibiotics In (μg/hr)", // X-Axis Label
                "% Resistant Bacteria", // Y-Axis Label
                antibiotic_dataset, PlotOrientation.VERTICAL,
                true,true,false
        );

        chart1.getXYPlot().getRangeAxis().setLowerBound(0.0);
        chart1.getXYPlot().getRangeAxis().setUpperBound(Math.pow(10.0, 16.0));


        charts.add(chart1); charts.add(chart2); charts.add(chart3);

        return charts;
    }

    public void updateChart(){
        ArrayList<XYSeries> datasets = createDataset();

        XYSeriesCollection chart1_data = new XYSeriesCollection(datasets.get(0)); chart1_data.addSeries(datasets.get(1));
        XYSeriesCollection ratio_dataset = new XYSeriesCollection(datasets.get(2));
        XYSeriesCollection antibiotic_dataset = new XYSeriesCollection(datasets.get(3));


        chart1 = ChartFactory.createXYLineChart(
                "Change of Sensitive and Resistant Bacteria with Respect to Time", // Chart title
                "Time (days)", // X-Axis Label
                "Number of Bacteria (CFU)", // Y-Axis Label
                chart1_data, PlotOrientation.VERTICAL,
                true,true,false
        );

        chart2 = ChartFactory.createXYLineChart(
                "Resistant Bacteria / Total Bacteria vs Time", // Chart title
                "Time (days)", // X-Axis Label
                "% Resistant Bacteria", // Y-Axis Label
                ratio_dataset, PlotOrientation.VERTICAL,
                true,true,false
        );

        chart1.getXYPlot().getRangeAxis().setLowerBound(0.0);
        chart1.getXYPlot().getRangeAxis().setUpperBound(Math.pow(10.0, 16.0));

        this.view.setChart1(chart1);
        this.view.setChart2(chart2);
        this.view.updateChart();
    }

    public void setEquationType(Equation e){
        this.equation = e;
    }

    public Bacteria getBacteria(){
        return this.bacteria;
    }
    public Inflow getInflow() {return this.inflow;}
    public Medium getMedium(){return this.inflow.medium;}
    public Container getContainer(){return this.container;}
    public Antibiotic getAntibiotic(){return this.antibiotic;}
    public void setTime_max(double num){this.time_max = num;}
}
