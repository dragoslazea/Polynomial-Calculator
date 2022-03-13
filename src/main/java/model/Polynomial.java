package model;

import java.util.ArrayList;
import java.util.Comparator;

// Clasa pentru polinom
public class Polynomial {
    // Polinomul este reprezentat sub forma unei liste de monoame
    private ArrayList<Monomial> monomials;

    // Constructor care creeaza un polinom nul (0)
    public Polynomial(){
        this.monomials = new ArrayList<Monomial>();
    }

    // Metoda accesoare pentru lista de monoame a polinomului
    public ArrayList<Monomial> getMonomials() {
        return monomials;
    }

    // Sorteaza monoamele din lista descrescator dupa grad - se foloseste comparatorul definit in clasa DegreeComparator
    public void sortDescendingDegree(){
        Comparator<Monomial> c = new DegreeComparator();
        this.monomials.sort(c);
    }

    // Metoda care returneaza gradul polinomului
    public int getPolynomialDegree(){
        int deg = this.monomials.get(0).getDegree();
        for (Monomial m:
             this.monomials) {
            if (m.getDegree() > deg){
                deg = m.getDegree();
            }
        }
        return deg;
    }

    // Metoda care reduce polinomul la cea mai simpla forma (se reduc termenii asemenea si se efectueaza calculele posibilie intre monoamlele de acelasi grad)
    public Polynomial reduceTermsOfSameDegree(){
        Polynomial r = new Polynomial();
        for (int i = this.getPolynomialDegree(); i >= 0; i--){
            int sum = 0;
            for (Monomial m:
                 this.monomials) {
                if (m.getDegree() == i){
                    sum += m.getCoefficient();
                }
            }
            if (sum != 0){
                r.monomials.add(new Monomial(sum, i));
            }
        }
        if (r.getMonomials().isEmpty()){
            r.getMonomials().add(new Monomial(0, 0));
        }
        return r;
    }

    // Metoda care returneaza valoarea polinomului in punctul x, transmis ca parametru
    public int getValue(int x){
        int val = 0;
        for (Monomial m:
             this.monomials) {
            val += m.getCoefficient() * Math.pow(x, m.getDegree());
        }
        return val;
    }

    // Metoda care verifica daca un polinom este egal cu 0 (polinomul nul)
    public boolean isNull(){
        return (this.getMonomials().isEmpty() || this.monomials.get(0).getCoefficient() == 0 && this.monomials.get(0).getDegree() == 0);
    }

    // Metoda pentru afisarea polinomului
    public void printPolynomial(){
        this.sortDescendingDegree();
        if (this.getMonomials().isEmpty() || this.monomials.get(0).getCoefficient() == 0 && this.monomials.get(0).getDegree() == 0){
            System.out.print("0");
            return;
        }
        for (Monomial m:
                this.monomials) {
            if (m.getCoefficient() > 0 && monomials.indexOf(m) != 0){
                System.out.print("+");
            }
            m.printMonomial();
        }
    }

    // Metoda toString - folosita la afisarea rezulatului in GUI
    public String toString(){
        this.sortDescendingDegree();
        if (this.isNull()){
            return "0";
        }
        String strPol = "";
        for (Monomial m : this.monomials){
            if (m.getCoefficient() > 0 && monomials.indexOf(m) != 0){
                strPol = strPol + "+";
            }
            strPol = strPol + m;
        }
        return strPol;
    }

}
