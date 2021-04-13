package Model;

public class EColi extends Bacteria{

    public EColi(String name, double gene_transfer_rate, double growth_rate, double resistance_fitness_cost, double E_max, double hill_coeff,
                 double MIC_R, double MIC_S) {
        super(name, gene_transfer_rate, growth_rate, resistance_fitness_cost, E_max, hill_coeff, MIC_R, MIC_S);
    }

    public EColi(){
        this.name = "Escherichia coli";
        this.gene_transfer_rate = 0.001;
        this.growth_rate = 0.5;
        this.resistance_fitness_cost = 0.1;
        this.E_max = 2.0;
        this.hill_coeff = 2.0;
        this.MIC_S = 8.0;
        this.MIC_R = 2000.0;
    }
}
