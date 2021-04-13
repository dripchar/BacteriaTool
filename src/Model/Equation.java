package Model;

public interface Equation {

    double sumBacteria(double S, double R);

    double getVt(double vi, double lambda, double time);

    double getNmaxt(double mu, double Vt);

    double getAt(double time, double ai, double theta, double gamma);

    double getEs(double Emax, double At, double Vt, double H, double MICs);

    double getEr(double Emax, double At, double Vt, double H, double MICr);

    double SensitiveFunction(double time, double r, double N, double Nmax, double Es, double S, double Beta, double R,
                             double lambda, double rho, double v);

    double ResistantFunction(double time, double r, double alpha, double N, double Nmax, double Er, double R,
                             double Beta, double S, double lambda, double rho, double v);


}
