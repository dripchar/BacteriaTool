package Model;

public class Slurry extends Medium{

    public Slurry(double carry_capacity, double bact_conc, double percent_Rbact) {
        super(carry_capacity, bact_conc, percent_Rbact);
    }

    public Slurry(){
        this.carry_capacity = Math.pow(10.0, 10.0);
        this.bact_conc = 2.0*Math.pow(10.0, 7.0);
        this.percent_Rbact = 0.4;
    }
}
