package Main;

import Controller.Control;
import Model.*;
import View.View;

public class Main {

    public static void main(String[] args){
        System.out.println("beep boop");
        Model model = new Model(new Cephalosporins(), new EColi(), new Silo(), new SiloInflow());
        View view = new View(model);
        Control control = new Control(model, view);
        model.setView(view);
        model.setEquationType(new NottinghamEquation()); //Needs to happen before graph is made else dataset has no eqn
        view.setControl(control);

        control.makeGraph(); //Make graph and give view graph



    }

}
