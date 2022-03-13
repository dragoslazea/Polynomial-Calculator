package model;

import java.util.ArrayList;

// Clasa ce reprezinta modelul arhitecturii MVC conform careia este structurat proiectul
public class CalcModel {
    // Variabilele instanta ce definesc starea calculatorului
    private Polynomial p;
    private Polynomial q;
    private ArrayList<Polynomial> res;

    // Constructor
    public CalcModel(){
        reset();
    }

    // Metode de set si get pentru accesul la variabilele instanta ale modelului
    public void setP(Polynomial p) {
        this.p = p;
    }

    public void setQ(Polynomial q){
        this.q = q;
    }

    public Polynomial getP() { return p; }

    public Polynomial getQ() { return q; }

    public String getResult(){
        return res.get(0).toString();
    } // Returneaza rezultatul sub forma de String (in cazul impartirii reprezinta catul)

    public String getRemainder(){
        return res.get(1).toString();
    } // In cazul in care se efectueaza o operatie de impartire, returneaza restul impartirii sub forma de String

    // Metode ce efectueaza operatiile posibile in model
    public void addPolynomials(){
        res.set(0, Operations.add(p, q));
    }

    public void subPolynomials(){
        res.set(0, Operations.sub(p, q));
    }

    public void mulPolynomials(){
        res.set(0, Operations.multiply(p, q));
    }

    public void divPolynomials(){
        res.clear();
        res = Operations.divide(p, q);
    }

    public void difPolynomial(){
        res.set(0, Operations.derivative(p));
    }

    public void intPolynomial(){
        res.set(0, Operations.integrate(p));
    }

    // Metoda ce reseteaza modelul la valorile initiale ale variabilelor instanta (0)
    public void reset(){
        p = new Polynomial();
        q = new Polynomial();
        p.getMonomials().add(new Monomial(0,0));
        q.getMonomials().add(new Monomial(0, 0));
        res = new ArrayList<Polynomial>();
        res.add(p);
        res.add(q);
    }

    // Metoda folosita la resetarea rezultatului, folosita in cazul in care se doreste efectuarea unei alte operatii pe polinoamele introduse, asupra carora s-a efectuat ulterior o operatie
    public void resetResult(){
        p = new Polynomial();
        q = new Polynomial();
        res = new ArrayList<Polynomial>();
        res.add(p);
        res.add(q);
    }

}
