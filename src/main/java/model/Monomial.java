package model;

// Clasa pentru monom
public class Monomial {
    // Variabile instanta
    private double coefficient; // Coeficientul monomului - la integrare se pot obtine coeficienti reali, deci retin ca format double
    private int degree; // Gradul monomului

    // Constructor
    public Monomial(double coefficient, int degree){
        this.coefficient = coefficient;
        this.degree = degree;
    }

    // Metode accesoare si mutatoare - variabilele instanta sunt private, deci avem nevoie de metode de set si get
    public double getCoefficient() {
        return coefficient;
    }

    public int getDegree() {
        return degree;
    }

    public void setCoefficient(double coefficient) { this.coefficient = coefficient; }

    public void setDegree(int degree){
        this.degree = degree;
    }

    // Metoda toString - folosita pentru afisarea rezultatului in interfata grafica
    public String toString(){
        if (!(Math.abs(this.coefficient) < 1e-300)){
            // Se va testa daca coeficientul este intreg, iar in caz afirmativ, acesta va fi afisat fara zecimale
            int i = (int)this.coefficient;
            if (degree > 1) {
                if (Math.abs(coefficient - 1) > 1e-300 && Math.abs(coefficient + 1) > 1e-300) {
                    if (Math.abs(i - this.coefficient) < 1e-300){
                        return i + "X^" + this.degree;
                    } else {
                        return Math.round(this.coefficient * 100.0) / 100.0 + "X^" + this.degree;
                    }
                } else if (Math.abs(coefficient - 1) < 1e-300){
                    return "X^" + this.degree;
                } else {
                    return "-X^" + this.degree;
                }

            } else if (degree == 1) {
                if (Math.abs(coefficient - 1) > 1e-300 && Math.abs(coefficient + 1) > 1e-300){
                    if (Math.abs(i - this.coefficient) < 1e-300) {
                        return i + "X";
                    } else {
                        return Math.round(this.coefficient * 100.0) / 100.0 + "X";
                    }
                } else if (Math.abs(coefficient - 1) < 1e-300){
                    return "X";
                } else{
                    return "-X";
                }

            } else {
                if (Math.abs(i - this.coefficient) < 1e-300) {
                    return "" + i;
                }else {
                    return "" + Math.round(this.coefficient * 100.0) / 100.0;
                }
            }
        } else {
            return "";
        }
    }

    // Metoda de afisare a monomului
    public void printMonomial(){
        if (!(Math.abs(this.coefficient) < 1e-300)){
            int i = (int)this.coefficient;
            //System.out.println("i = " + i);
            if (degree > 1) {
                if (Math.abs(coefficient - 1) > 1e-300 && Math.abs(coefficient + 1) > 1e-300) {
                    if (Math.abs(i - this.coefficient) < 1e-300){
                        System.out.print(i + "X^" + this.degree);
                    } else {
                        System.out.print(this.coefficient + "X^" + this.degree);
                    }
                } else if (Math.abs(coefficient - 1) < 1e-300){
                    System.out.print("X^" + this.degree);
                } else {
                    System.out.print("-X^" + this.degree);
                }

            } else if (degree == 1) {
                if (Math.abs(coefficient - 1) > 1e-300 && Math.abs(coefficient + 1) > 1e-300){
                    if (Math.abs(i - this.coefficient) < 1e-300) {
                        System.out.print(i + "X");
                    } else {
                        System.out.print(this.coefficient + "X");
                    }
                } else if (Math.abs(coefficient - 1) < 1e-300){
                    System.out.print("X");
                } else{
                    System.out.print("-X");
                }

            } else {
                if (Math.abs(i - this.coefficient) < 1e-300) {
                    System.out.print("" + i);
                }else {
                    System.out.print("" + this.coefficient);
                }
            }
        }
    }

    // Metoda pentru inmultirea a doua monoame
    public Monomial multiplyMonomial(Monomial m){
        Monomial res = new Monomial(this.getCoefficient(), this.getDegree());
        res.setCoefficient(this.getCoefficient() * m.getCoefficient());
        res.setDegree(this.getDegree() + m.getDegree());
        return res;
    }

    // Metoda pentru derivarea monomului
    public Monomial derivative(){
        Monomial res = new Monomial(coefficient * degree, degree - 1);
        return res;
    }

    // Metoda pentru inegrarea monomului
    public Monomial integrateMonomial(){
        Monomial res = new Monomial(coefficient / (degree + 1), degree + 1);
        return res;
    }

    // Metoda pentru impartirea a doua monoame
    public Monomial divideMonomial(Monomial m){
        return new Monomial(this.coefficient / m.getCoefficient(), this.degree - m.getDegree());
    }

    // Metoda care primeste un String ca parametru si extrage coeficientul si gradul monomului primit sub forma de String
    public static Monomial parseMonomial(String mon){
        mon = mon.replaceAll(" ", "");
        if (mon.equals("")){
            return new Monomial(0, 0);
        } else if (mon.equals("X") || mon.equals("x")){
            return new Monomial(1, 1);
        }
        Monomial m = new Monomial(0, 0);
        String[] coefDegree = mon.split("[xX]");
        if (coefDegree[0].equals("-")){
            m.setCoefficient(-1);
        } else if (coefDegree[0].equals("")){
            m.setCoefficient(1);
        } else {
            m.setCoefficient(Double.parseDouble(coefDegree[0]));
        }
        if (!mon.toUpperCase().contains("X")){
            m.setDegree(0);
        } else {
            if (coefDegree.length >= 2) {
                String[] deg = coefDegree[1].split("[ ^]");
                if (deg.length >= 2) {
                    if (deg[1].equals("")) {
                        m.setDegree(1);
                    } else { m.setDegree(Integer.parseInt(deg[1])); }
                }
            } else { m.setDegree(1); }
        }
        return m;
    }
}
