package Model;

public abstract class Medium {

    double carry_capacity;
    double bact_conc;
    double percent_Rbact;

    public Medium(double carry_capacity, double bact_conc, double percent_Rbact){
        this.carry_capacity = carry_capacity;
        this.bact_conc = bact_conc;
        this.percent_Rbact = percent_Rbact;
    }

    protected Medium() {
    }

    public void setMu(double carry_capacity) {
        this.carry_capacity = carry_capacity;
    }

    public void set_v(double bact_conc) {
        this.bact_conc = bact_conc;
    }

    public void setRho(double percent_Rbact) {
        this.percent_Rbact = percent_Rbact;
    }
}
