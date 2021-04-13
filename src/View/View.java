package View;

import Controller.*;
import Model.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;

//TODO: Write a manifesto on why the person who made GridBagLayout should be put on trial for war crimes

public class View {

    private Control control;
    private ChartPanel chartPanel1;
    private ChartPanel chartPanel2;
    private ChartPanel chartPanel3;
    private JFrame frame;
    private Model model;

    JPanel graph_pane;
    GridBagConstraints graph_c;
    private static final Insets LABEL_INSETS = new Insets(5, 0, 5, 0);
    private static final Insets LEFT_SLIDER_INSETS = new Insets(5, 0, 5, 10);
    private static final Insets LEFT_GRAPH_INSETS = new Insets(5, 5, 10, 5);
    private static final String helpMessage = "r is the growth rate of bacteria / hr  \n beta represents the gene " +
            "transfer term of resistant bacteria / hr \n alpha represents the resistance fitness cost as fraction of r" +
            "\n theta represents the rate of antibiotic inflow in micrograms / hr";



    public View(Model model){
        this.model = model;

    }

    //TODO: Maybe make this less ugly idk
    public void buildGUI(){
        frame = new JFrame("Rate of Resistant and Sensitive Bacteria Tool");
        JPanel slider_pane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JSlider r_slider = new JSlider(17, 90, 50);
        Label r_text = new Label("0.50");
        r_slider.addChangeListener(new GrowthRateChangeListener(this.model, r_slider, r_text));

        JSlider beta_slider = new JSlider(1, 999, 1);
        Label beta_text = new Label("0.001");
        beta_slider.addChangeListener(new BetaChangeListener(this.model, beta_slider, beta_text));

        //Slurry only flows in in this model
        JSlider lambda_slider = new JSlider(0, 100000, 6131); //TODO: This one shouldn't vary or have a slider
        Label lambda_text = new Label("6131");
        lambda_slider.addChangeListener(new LambdaChangeListener(this.model, lambda_slider, lambda_text));

//        JSlider v_slider = new JSlider(-10, 10, 0); //TODO: This one shouldn't vary or have a slider
//        v_slider.addChangeListener(new VChangeListener(this.model, v_slider));
//
//        JSlider rho_slider = new JSlider(-10, 10, 0); //TODO: This one shouldn't vary or have a slider
//        rho_slider.addChangeListener(new RhoChangeListener(this.model, rho_slider));

        JSlider alpha_slider = new JSlider(0, 30, 10);
        Label alpha_text = new Label("0.1");
        alpha_slider.addChangeListener(new AlphaChangeListener(this.model, alpha_slider, alpha_text));
//
//        JSlider vi_slider = new JSlider(-10, 10, 0); //TODO: This one shouldn't vary or have a slider
//        vi_slider.addChangeListener(new ViChangeListener(this.model, vi_slider));
//
//        JSlider ai_slider = new JSlider(-10, 10, 0); //TODO: This one shouldn't vary or have a slider
//        ai_slider.addChangeListener(new AiChangeListener(this.model, ai_slider));

        JSlider theta_slider = new JSlider(0, 10000, 3422);
        Label theta_text = new Label("3422.0");
        theta_slider.addChangeListener(new ThetaChangeListener(this.model, theta_slider, theta_text));

//        JSlider Emax_slider = new JSlider(-10, 10, 0); //TODO: This one shouldn't vary or have a slider
//        Emax_slider.addChangeListener(new EmaxChangeListener(this.model, Emax_slider));
//
//        JSlider H_slider = new JSlider(-10, 10, 0); //TODO: This one shouldn't vary or have a slider
//        H_slider.addChangeListener(new HillChangeListener(this.model, H_slider));
//
//        JSlider MICr_slider = new JSlider(-10, 10, 0); //TODO: This one shouldn't vary or have a slider
//        MICr_slider.addChangeListener(new MICrChangeListener(this.model, MICr_slider));
//
//        JSlider MICs_slider = new JSlider(-10, 10, 0); //TODO: This one shouldn't vary or have a slider
//        MICs_slider.addChangeListener(new MICsChangeListener(this.model, MICs_slider));
//
//        JSlider capacity_slider = new JSlider(-10, 10, 0); //TODO: This one shouldn't vary or have a slider
//        capacity_slider.addChangeListener(new CapacityChangeListener(this.model, capacity_slider));
//
//        JSlider decay_slider = new JSlider(-10, 10, 0); //TODO: This one shouldn't vary or have a slider
//        decay_slider.addChangeListener(new DecayChangeListener(this.model, decay_slider));

        JSlider time_max_slider = new JSlider(1, 400, 200);
        Label time_max_text = new Label("200.0");
        time_max_slider.addChangeListener(new TimeMaxChangeListener(this.model, time_max_slider, time_max_text));

        JButton helpButton = new JButton();
        helpButton.setBorderPainted(false);
        helpButton.setText("?");
        helpButton.setForeground(Color.BLUE);

        helpButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(null, helpMessage, "Variable Descriptions", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //GENERAL CONSTRAINT RULES
        c.weightx = 0;
        c.fill = GridBagConstraints.RELATIVE;

        //ROW 0
        c.insets = LABEL_INSETS;
        c.gridx = 0;
        c.gridy = 0;
        slider_pane.add(new Label("r"), c);

        c.insets = LEFT_SLIDER_INSETS;
        c.gridx = 1;
        c.gridy = 0;
        slider_pane.add(r_slider, c);

        c.gridx = 2;
        c.gridy = 0;
        slider_pane.add(r_text, c);

        c.insets = LABEL_INSETS;
        c.gridx = 0;
        c.gridy = 1;
        slider_pane.add(new Label("β"), c);

        c.insets = LEFT_SLIDER_INSETS;
        c.gridx = 1;
        c.gridy = 1;
        slider_pane.add(beta_slider, c);

        c.gridx = 2;
        c.gridy = 1;
        slider_pane.add(beta_text, c);

        //ROW 1
        /*
        c.insets = LABEL_INSETS;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(new Label("λ"), c);

        c.insets = LEFT_SLIDER_INSETS;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(lambda_slider, c);

        c.insets = LABEL_INSETS;
        c.gridx = 2;
        c.gridy = 1;
        pane.add(new Label("v"), c);

        c.insets = RIGHT_SLIDER_INSETS;
        c.gridx = 3;
        c.gridy = 1;
        pane.add(v_slider, c);


        //ROW 2
        c.insets = LABEL_INSETS;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(new Label("ρ"), c);

        c.insets = LEFT_SLIDER_INSETS;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(rho_slider, c);
*/
        c.insets = LABEL_INSETS;
        c.gridx = 0;
        c.gridy = 2;
        slider_pane.add(new Label("α"), c);

        c.insets = LEFT_SLIDER_INSETS;
        c.gridx = 1;
        c.gridy = 2;
        slider_pane.add(alpha_slider, c);

        c.gridx = 2;
        c.gridy = 2;
        slider_pane.add(alpha_text, c);

/*
        //ROW 3
        c.insets = LABEL_INSETS;
        c.gridx = 0;
        c.gridy = 3;
        pane.add(new Label("Vi"), c);

        c.insets = LEFT_SLIDER_INSETS;
        c.gridx = 1;
        c.gridy = 3;
        pane.add(vi_slider, c);

        c.insets = LABEL_INSETS;
        c.gridx = 2;
        c.gridy = 3;
        pane.add(new Label("Ai"), c);

        c.insets = RIGHT_SLIDER_INSETS;
        c.gridx = 3;
        c.gridy = 3;
        pane.add(ai_slider, c);
*/
        //ROW 4
        c.insets = LABEL_INSETS;
        c.gridx = 0;
        c.gridy = 3;
        slider_pane.add(new Label("θ"), c);

        c.insets = LEFT_SLIDER_INSETS;
        c.gridx = 1;
        c.gridy = 3;
        slider_pane.add(theta_slider, c);

        c.gridx = 2;
        c.gridy = 3;
        slider_pane.add(theta_text, c);

//        c.insets = LABEL_INSETS;
//        c.gridx = 0;
//        c.gridy = 4;
//        slider_pane.add(new Label("storage time"), c);
//
//        c.insets = LEFT_SLIDER_INSETS;
//        c.gridx = 1;
//        c.gridy = 4;
//        slider_pane.add(time_max_slider, c);
//
//        c.gridx = 2;
//        c.gridy = 4;
//        slider_pane.add(time_max_text, c);


/*
        c.insets = LABEL_INSETS;
        c.gridx = 2;
        c.gridy = 4;
        pane.add(new Label("Emax"), c);

        c.insets = RIGHT_SLIDER_INSETS;
        c.gridx = 3;
        c.gridy = 4;
        pane.add(Emax_slider, c);

        //ROW 5
        c.insets = LABEL_INSETS;
        c.gridx = 0;
        c.gridy = 5;
        pane.add(new Label("Hill"), c);

        c.insets = LEFT_SLIDER_INSETS;
        c.gridx = 1;
        c.gridy = 5;
        pane.add(H_slider, c);

        c.insets = LABEL_INSETS;
        c.gridx = 2;
        c.gridy = 5;
        pane.add(new Label("MICr"), c);

        c.insets = RIGHT_SLIDER_INSETS;
        c.gridx = 3;
        c.gridy = 5;
        pane.add(MICr_slider, c);


        //ROW 6
        c.insets = LABEL_INSETS;
        c.gridx = 0;
        c.gridy = 6;
        pane.add(new Label("MICs"), c);

        c.insets = LEFT_SLIDER_INSETS;
        c.gridx = 1;
        c.gridy = 6;
        pane.add(MICs_slider, c);

        c.insets = LABEL_INSETS;
        c.gridx = 2;
        c.gridy = 6;
        pane.add(new Label("μ"), c);

        c.insets = RIGHT_SLIDER_INSETS;
        c.gridx = 3;
        c.gridy = 6;
        pane.add(capacity_slider, c);


        //ROW 7
        c.insets = LABEL_INSETS;
        c.gridx = 1;
        c.gridy = 7;
        pane.add(new Label("γ"), c);

        c.insets = RIGHT_SLIDER_INSETS;
        c.gridx = 2;
        c.gridy = 7;
        pane.add(decay_slider, c);
*/
        c.gridx = 3;
        c.gridy= 3;
        slider_pane.add(helpButton, c);

        graph_pane = new JPanel(new GridBagLayout());
        graph_c = new GridBagConstraints();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        graph_c.gridx = 0; graph_c.gridy = 0; graph_c.insets = LEFT_GRAPH_INSETS;
        graph_pane.add(chartPanel1, graph_c);

        graph_c.gridx = 1; graph_c.gridy = 0; graph_c.insets = LEFT_GRAPH_INSETS;
        graph_pane.add(chartPanel2, graph_c);


        frame.getContentPane().add(chartPanel3, BorderLayout.NORTH);
        frame.getContentPane().add(graph_pane, BorderLayout.CENTER);


        frame.getContentPane().add(slider_pane, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

    }

    public void setChart1(JFreeChart chart){
        this.chartPanel1 = new ChartPanel(chart);
    }

    public void setChart2(JFreeChart chart){
        this.chartPanel2 = new ChartPanel(chart);
    }

    public void setChart3(JFreeChart chart){
        this.chartPanel3 = new ChartPanel(chart);
    }



    public void setControl(Control c){
        this.control = c;
    }

    public void updateChart(){
        graph_c.gridx = 0; graph_c.gridy = 0; graph_c.insets = LEFT_GRAPH_INSETS;
        graph_pane.add(chartPanel1, graph_c);

        graph_c.gridx = 1; graph_c.gridy = 0; graph_c.insets = LEFT_GRAPH_INSETS;
        graph_pane.add(chartPanel2, graph_c);


        frame.getContentPane().add(graph_pane, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }


}