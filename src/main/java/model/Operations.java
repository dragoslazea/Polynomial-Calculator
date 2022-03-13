package model;

import java.util.ArrayList;

// Clasa in care sunt implementata cele 6 operatii cerute, ca metode statice
public class Operations {
    // Suma a doua polinoame
    public static Polynomial add(Polynomial p, Polynomial q) {
        Polynomial res = new Polynomial();
        p = p.reduceTermsOfSameDegree();
        q = q.reduceTermsOfSameDegree();
        int resDeg = Math.max(p.getPolynomialDegree(), q.getPolynomialDegree());
        for (int i = resDeg; i >= 0; i--) {
            double coef = 0;
            double coefP = 0;
            double coefQ = 0;
            for (Monomial m :
                    p.getMonomials()) {
                if (m.getDegree() == i) {
                    coefP = m.getCoefficient();
                    break;
                }
            }
            for (Monomial n :
                    q.getMonomials()) {
                if (n.getDegree() == i) {
                    coefQ = n.getCoefficient();
                    break;
                }
            }
            coef = coefP + coefQ;
            if (coef != 0) {
                res.getMonomials().add(new Monomial(coef, i));
            }
        }
        if (res.getMonomials().isEmpty()){
            res.getMonomials().add(new Monomial(0, 0));
        }
        return res;
    }

    // Diferenta a doua polinoame
    public static Polynomial sub(Polynomial p, Polynomial q) {
        Polynomial res = new Polynomial();
        p = p.reduceTermsOfSameDegree();
        q = q.reduceTermsOfSameDegree();
        int resDeg = Math.max(p.getPolynomialDegree(), q.getPolynomialDegree());
        for (int i = resDeg; i >= 0; i--) {
            double coef = 0;
            double coefP = 0;
            double coefQ = 0;
            for (Monomial m :
                    p.getMonomials()) {
                if (m.getDegree() == i) {
                    coefP = m.getCoefficient();
                    break;
                }
            }
            for (Monomial n :
                    q.getMonomials()) {
                if (n.getDegree() == i) {
                    coefQ = n.getCoefficient();
                    break;
                }
            }
            coef = coefP - coefQ;
            if (coef != 0) {
                res.getMonomials().add(new Monomial(coef, i));
            }
        }
        if (res.getMonomials().isEmpty()){
            res.getMonomials().add(new Monomial(0, 0));
        }
        return res;
    }

    // Produsul a doua polinoame
    public static Polynomial multiply(Polynomial p, Polynomial q) {
        p = p.reduceTermsOfSameDegree();
        q = q.reduceTermsOfSameDegree();
        Polynomial res = new Polynomial();
        for (Monomial m :
                p.getMonomials()) {
            for (Monomial n :
                    q.getMonomials()) {
                res.getMonomials().add(m.multiplyMonomial(n));
            }
        }
        res = res.reduceTermsOfSameDegree();
        return res;
    }

    // Derivata polinomului
    public static Polynomial derivative(Polynomial p){
        p = p.reduceTermsOfSameDegree();
        Polynomial d = new Polynomial();
        for (Monomial m:
             p.getMonomials()) {
            Monomial dx = m.derivative();
            if (Math.abs(dx.getCoefficient()) > 1e-300){
                d.getMonomials().add(dx);
            }
        }
        if (d.getMonomials().isEmpty()){
            d.getMonomials().add(new Monomial(0, 0));
        }
        return d;
    }

    // Integrala polinomului (multimea primitivelor polinomului)
    public static Polynomial integrate(Polynomial p){
        Polynomial res = new Polynomial();
        p = p.reduceTermsOfSameDegree();
        for (Monomial m:
             p.getMonomials()) {
            Monomial it = m.integrateMonomial();
            if (Math.abs(it.getCoefficient()) > 1e-300){
                res.getMonomials().add(it);
            }
        }
        if (res.getMonomials().isEmpty()){
            res.getMonomials().add(new Monomial(0, 0));
        }
        return res;
    }

    // Impartirea a doua polinoame (primul element din lista returnata este catul, iar al doilea este restul)
    public static ArrayList<Polynomial> divide(Polynomial p1, Polynomial p2){
        ArrayList<Polynomial> res = new ArrayList<Polynomial>();
        p1.reduceTermsOfSameDegree();
        p2.reduceTermsOfSameDegree();
        Polynomial q = new Polynomial();
        Polynomial r = new Polynomial();
        for (Monomial m:
             p1.getMonomials()) {
            r.getMonomials().add(new Monomial(m.getCoefficient(), m.getDegree()));
        }
        while (!r.isNull() && r.getPolynomialDegree() >= p2.getPolynomialDegree()){
            Monomial t = r.getMonomials().get(0).divideMonomial(p2.getMonomials().get(0));
            q.getMonomials().add(t);
            Polynomial tp = new Polynomial();
            tp.getMonomials().add(t);
            r = Operations.sub(r, Operations.multiply(tp, p2));
        }
        if (q.getMonomials().isEmpty()){
            q.getMonomials().add(new Monomial(0, 0));
        }
        if (r.getMonomials().isEmpty()){
            r.getMonomials().add(new Monomial(0, 0));
        }
        q = q.reduceTermsOfSameDegree();
        r = r.reduceTermsOfSameDegree();
        res.add(q);
        res.add(r);
        return res;
    }
}

