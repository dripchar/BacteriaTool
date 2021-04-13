package Model;

public class NottinghamEquation implements Equation{

    //TODO: Break up subeqns for testing purposes ex Vt, E_S, E_R
    double one = 1.0;

    @Override
    public double sumBacteria(double S, double R){
        return S+R;
    }

    @Override
    public double getVt(double vi, double lambda, double time){
        return vi + lambda*time;
    }

    @Override
    public double getNmaxt(double mu, double Vt){
        return mu*Vt;
    }

    @Override
    public double getAt(double time, double ai, double theta, double gamma){
        return (ai - (theta/gamma))*Math.exp(-one*gamma*time)+theta/gamma;
    }

    @Override
    public double getEs(double Emax, double At, double Vt, double H, double MICs){
        return one - ((Emax*(Math.pow(At/Vt, H)))/(MICs+Math.pow(At/Vt, H)));
    }

    @Override
    public double getEr(double Emax, double At, double Vt, double H, double MICr){
        return one-((Emax*(Math.pow(At/Vt,H))/(MICr+Math.pow(At/Vt, H))));
    }

    @Override
    public double SensitiveFunction(double time, double r, double N, double Nmax, double Es, double S, double Beta, double R,
                                    double lambda, double rho, double v) {

        return r*(one-N/Nmax)*Es*S-Beta*S*R/N+lambda*(one-rho)*v;

    }

    @Override
    public double ResistantFunction(double time, double r, double alpha, double N, double Nmax, double Er, double R, double Beta,
                                    double S, double lambda, double rho, double v) {

        return r*(one-alpha)*(one-N/Nmax)*Er*R+Beta*S*R/N+lambda*rho*v;

    }
}
