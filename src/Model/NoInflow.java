package Model;

public class NoInflow extends Inflow{

    public NoInflow(double rate_in, double rate_antibiotic_in, Medium medium) {
        super(rate_in, rate_antibiotic_in, medium);
    }

    public NoInflow(){
        this.rate_in = 0.1;
        this.rate_antibiotic_in = 0.0;
        this.medium = new NoMedium();
    }
}