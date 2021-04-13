package Model;

public class Silo extends Container{

    public Silo(Inflow intake, double initial_volume, double initial_antibiotics) {
        super(intake, initial_volume, initial_antibiotics);
    }

    public Silo(){
        this.initial_volume = 150000.0;
        this.initial_antibiotics = 0.0;
        this.intake = new SiloInflow();
    }
}
