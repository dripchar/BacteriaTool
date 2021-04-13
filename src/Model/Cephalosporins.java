package Model;

public class Cephalosporins extends Antibiotic{
    public Cephalosporins(double decay_rate) {
        super(decay_rate);
    }

    public Cephalosporins(){
        this.decay_rate = 0.0029;
    }
}
