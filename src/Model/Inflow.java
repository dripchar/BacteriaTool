package Model;

public abstract class Inflow {
    double rate_in;
    double rate_antibiotic_in;
    Medium medium;

    public Inflow(double rate_in, double rate_antibiotic_in, Medium medium){
        this.rate_in = rate_in;
        this.rate_antibiotic_in = rate_antibiotic_in;
        this.medium = medium;
    }

    protected Inflow() {
    }

    public void setLambda(double rate_in) {
        this.rate_in = rate_in;
    }

    public void setTheta(double rate_antibiotic_in) {
        this.rate_antibiotic_in = rate_antibiotic_in;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }
}
