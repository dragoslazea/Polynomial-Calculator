package test;

import model.CalcModel;
import model.Monomial;
import model.Polynomial;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Clasa de test pentru operatia de derivare
public class TestDifOperation {
    private CalcModel model = new CalcModel();
    @ParameterizedTest
    @MethodSource("provideInput")
    void testDifferentiationOperation(Polynomial p, String expectedResult){
        model.setP(p);
        model.difPolynomial();
        assertEquals(expectedResult, model.getResult());
    }
    private static List<Arguments> provideInput(){
        List<Arguments> argumentsList = new ArrayList<>();
        Polynomial p1 = new Polynomial();
        p1.getMonomials().add(new Monomial(1, 2));
        p1.getMonomials().add(new Monomial(2, 3));
        Polynomial p2 = new Polynomial();
        p2.getMonomials().add(new Monomial(1, 3));
        p2.getMonomials().add(new Monomial(1, 1));
        Polynomial p3 = new Polynomial();
        p3.getMonomials().add(new Monomial(4, 5));
        p3.getMonomials().add(new Monomial(-3, 4));
        p3.getMonomials().add(new Monomial(1, 2));
        p3.getMonomials().add(new Monomial(-8, 1));
        p3.getMonomials().add(new Monomial(1, 0));
        Polynomial p4 = new Polynomial();
        p4.getMonomials().add(new Monomial(3, 4));
        p4.getMonomials().add(new Monomial(-1, 3));
        p4.getMonomials().add(new Monomial(1, 2));
        p4.getMonomials().add(new Monomial(2, 1));
        p4.getMonomials().add(new Monomial(-1, 0));
        Polynomial p5 = new Polynomial();
        p5.getMonomials().add(new Monomial(9, 0));
        argumentsList.add(Arguments.of(p1, "6X^2+2X"));
        argumentsList.add(Arguments.of(p2, "3X^2+1"));
        argumentsList.add(Arguments.of(p3, "20X^4-12X^3+2X-8"));
        argumentsList.add(Arguments.of(p4, "12X^3-3X^2+2X+2"));
        argumentsList.add(Arguments.of(p5, "0"));
        return  argumentsList;
    }
}
