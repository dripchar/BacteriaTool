package Model;

public class SiloInflow extends Inflow{

    public SiloInflow(double rate_in, double rate_antibiotic_in, Medium medium) {
        super(rate_in, rate_antibiotic_in, medium);
    }

    public SiloInflow(){
        this.rate_in = 6131.0;
        this.rate_antibiotic_in = 3422.0;
        this.medium = new Slurry();
    }
}
