package Model;

public abstract class Bacteria {

    String name;
    public double growth_rate;
    double gene_transfer_rate;
    double resistance_fitness_cost;
    double E_max;
    double hill_coeff;
    double MIC_R;
    double MIC_S;

    public Bacteria(String name, double gene_transfer_rate, double growth_rate, double resistance_fitness_cost, double E_max, double hill_coeff,
                    double MIC_R, double MIC_S){
        this.name = name;
        this.gene_transfer_rate = gene_transfer_rate;
        this.growth_rate = growth_rate;
        this.resistance_fitness_cost = resistance_fitness_cost;
        this.E_max = E_max;
        this.hill_coeff = hill_coeff;
        this.MIC_R = MIC_R;
        this.MIC_S = MIC_S;
    }

    protected Bacteria() {

    }

    public double getBeta(){
        return this.gene_transfer_rate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlpha(double resistance_fitness_cost) {
        this.resistance_fitness_cost = resistance_fitness_cost;
    }

    public double getAlpha() {
        return this.resistance_fitness_cost;
    }

    public void setE_max(double e_max) {
        E_max = e_max;
    }

    public void setHill_coeff(double hill_coeff) {
        this.hill_coeff = hill_coeff;
    }

    public void setMIC_R(double MIC_R) {
        this.MIC_R = MIC_R;
    }

    public void setMIC_S(double MIC_S) {
        this.MIC_S = MIC_S;
    }

    public void setBeta(double val){
        this.gene_transfer_rate = val;
    }

    public void setGrowthRate(double val){
        this.growth_rate = val;
    }
}
