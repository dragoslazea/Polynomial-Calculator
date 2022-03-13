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

// Clasa de test pentru operatia de impartire
public class TestDivOperation {
    private CalcModel model = new CalcModel();
    @ParameterizedTest
    @MethodSource("provideInput")
    void testDivisionOperation(Polynomial p1, Polynomial p2, String expectedResult, String expectedRemainder){
        model.setP(p1);
        model.setQ(p2);
        model.divPolynomials();
        assertEquals(expectedResult, model.getResult());
        assertEquals(expectedRemainder, model.getRemainder());
    }
    private static List<Arguments> provideInput() {
        List<Arguments> argumentsList = new ArrayList<>();
        Polynomial p1 = new Polynomial();
        p1.getMonomials().add(new Monomial(1, 3));
        p1.getMonomials().add(new Monomial(-2, 2));
        p1.getMonomials().add(new Monomial(6, 1));
        p1.getMonomials().add(new Monomial(-5, 0));
        Polynomial p2 = new Polynomial();
        p2.getMonomials().add(new Monomial(1, 2));
        p2.getMonomials().add(new Monomial(-1, 0));
        Polynomial p3 = new Polynomial();
        p3.getMonomials().add(new Monomial(2, 2));
        p3.getMonomials().add(new Monomial(-12, 1));
        p3.getMonomials().add(new Monomial(18, 0));
        Polynomial p4 = new Polynomial();
        p4.getMonomials().add(new Monomial(1, 1));
        p4.getMonomials().add(new Monomial(-3, 0));
        Polynomial p5 = new Polynomial();
        p5.getMonomials().add(new Monomial(-1, 1));
        Polynomial p6 = new Polynomial();
        p6.getMonomials().add(new Monomial(3, 2));
        Polynomial p7 = new Polynomial();
        p7.getMonomials().add(new Monomial(2, 2));
        argumentsList.add(Arguments.of(p1, p2, "X-2", "7X-7"));
        argumentsList.add(Arguments.of(p3, p4, "2X-6", "0"));
        argumentsList.add(Arguments.of(p4, p3, "0",  "X-3"));
        argumentsList.add(Arguments.of(p2, p2, "1", "0"));
        argumentsList.add(Arguments.of(p1, p5, "-X^2+2X-6", "-5"));
        return argumentsList;
    }
}
