package Model;

public abstract class Antibiotic {

    double decay_rate;

    public Antibiotic(double decay_rate){
        this.decay_rate = decay_rate;
    }

    protected Antibiotic() {
    }


    public void setDecay_rate(double decay_rate) {
        this.decay_rate = decay_rate;
    }
}
