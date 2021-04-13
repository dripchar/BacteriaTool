package Model;

public abstract class Container {

    Inflow intake;
    double initial_volume;
    double initial_antibiotics;

    public Container(Inflow intake, double initial_volume, double initial_antibiotics){
        this.intake = intake;
        this.initial_volume = initial_volume;
        this.initial_antibiotics = initial_antibiotics;
    }

    protected Container() {
    }

    public void setIntake(Inflow intake) {
        this.intake = intake;
    }

    public void setVi(double initial_volume) {
        this.initial_volume = initial_volume;
    }

    public void setAi(double initial_antibiotics) {
        this.initial_antibiotics = initial_antibiotics;
    }
}
