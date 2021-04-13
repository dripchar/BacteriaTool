package Model;

public class NoMedium extends Medium{

    public NoMedium(double carry_capacity, double bact_conc, double percent_Rbact) {
        super(carry_capacity, bact_conc, percent_Rbact);
    }

    public NoMedium(){
        this.carry_capacity = Math.pow(10, 10);
        this.bact_conc = 0.0;
        this.percent_Rbact = 0.0;
    }
}
