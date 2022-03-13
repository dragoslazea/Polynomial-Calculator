package model;

import java.util.Comparator;

// Clasa ce implementeaza interfata Comparator, folosita pentru ordonarea monoamelor descrescator in functie de grad
public class DegreeComparator implements Comparator<Monomial> {
    // Suprascrierea metodei compare
    @Override
    public int compare(Monomial o1, Monomial o2) {
        if (o1.getDegree() > o2.getDegree()){
            return -1;
        } else if (o1.getDegree() == o2.getDegree()){
            return 0;
        } else {
            return 1;
        }
    }
}
