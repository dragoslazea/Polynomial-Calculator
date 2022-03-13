package controller;

import controller.exceptions.InvalidPolynomialException;
import model.Polynomial;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Clasa pentru testarea validitatii datelor introduse de utilizator, folosind regex
public class Validity {
    // String-uri ce folosesc regex pentru definirea pattern-urilor - CONSTANTE
    private static final String PATTERN_MONOMIAL_GEN = "[ ]*[-]?[ ]*[0-9]*[ ]*[x|X][ ]*[ ^|^][ ]*[0-9][ ]*"; // pentru monom cu de forba aX^k
    private static final String PATTERN_MONOMIAL_DEG0 = "[ ]*[-]?[ ]*[0-9]+[ ]*"; // pentru monom de gradul 0
    private static final String PATTERN_MONOMIAL_DEG1 = "[ ]*[-]?[ ]*[0-9]*[ ]*[x|X][ ]*"; // pentru monom de forma aX
    private static final Pattern GENERAL_PATTERN = Pattern.compile(PATTERN_MONOMIAL_GEN); // pattern pentru monom cu gradul >= 2
    private static final Pattern DEG0_PATTERN = Pattern.compile(PATTERN_MONOMIAL_DEG0); // pattern pentru monom de gradul 0
    private static final Pattern DEG1_PATTERN = Pattern.compile(PATTERN_MONOMIAL_DEG1); // pattern pentru monom de gradul 1

    public static Matcher getMatcher(Pattern p, String str){
        return p.matcher(str);
    }

    // Metoda care returneaza true daca stringul furnizat ca parametru este un monom valid
    public static boolean isValidMonomial(String mon){
        return getMatcher(GENERAL_PATTERN, mon).matches() || getMatcher(DEG0_PATTERN, mon).matches() || getMatcher(DEG1_PATTERN, mon).matches();
    }

    // Metoda de separare a polinomului sub forma de string intr-un lista de string-uri care reprezinta monoamele -- s-au folosit regex pentru separare
    // Ideea de baza: separ in functie de separatorul +, iar substringurile care nu sunt monoame valide le separ in functie de -. Daca si in urma acestei separari
    // obtin substringuri care nu respecta niciunul dintre pattern-uri, polinomul introdus este invalid, iar in caz contrar returnez lista monoamelor sub forma de stringuri
    public static ArrayList<String> splitToMonomials(String s) throws InvalidPolynomialException {
        Polynomial p = new Polynomial();
        ArrayList<String> monStr = new ArrayList<String>();
        s = s.replaceAll(" ", "");
        if (s.contains("-+") || s.contains("+-")){
            throw new InvalidPolynomialException();
        }
        String[] arrSplitPlus = s.split("[+]");
        for (String m1 : arrSplitPlus){
            if (isValidMonomial(m1)){
                monStr.add(m1);
            } else {
                String[] arrSplitMinus = m1.split("[-]");
                for (int i = 0; i < arrSplitMinus.length; i++){
                    String m2 = new String(arrSplitMinus[i]);
                    if (i != 0) { m2 = "-" + m2; } // Primul monom din fiecare subsir are semnul + deoarece aceste subsiruri sunt obitnute in urma separarii fata de +, deci doar de la al doilea monom incepand adaug semnul -
                    if (isValidMonomial(m2)){
                        monStr.add(m2);
                    } else {
                        throw new InvalidPolynomialException();
                    }
                }
            }
        }
        return monStr;
    }
}
