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

// Clasa de test pentru operatia de inmultire
public class TestMulOperation {
    private CalcModel model = new CalcModel();
    @ParameterizedTest
    @MethodSource("provideInput")
    void testMultiplicationOperation(Polynomial p1, Polynomial p2, String expectedResult){
        model.setP(p1);
        model.setQ(p2);
        model.mulPolynomials();
        assertEquals(expectedResult, model.getResult());
    }
    private static List<Arguments> provideInput() {
        List<Arguments> argumentsList = new ArrayList<>();
        Polynomial p1 = new Polynomial();
        p1.getMonomials().add(new Monomial(3, 2));
        p1.getMonomials().add(new Monomial(-1, 1));
        p1.getMonomials().add(new Monomial(1, 0));
        Polynomial p2 = new Polynomial();
        p2.getMonomials().add(new Monomial(1, 1));
        p2.getMonomials().add(new Monomial(-2, 0));
        Polynomial p3 = new Polynomial();
        p3.getMonomials().add(new Monomial(0, 0));
        Polynomial p4 = new Polynomial();
        p4.getMonomials().add(new Monomial(-1, 1));
        p4.getMonomials().add(new Monomial(1, 2));
        p4.getMonomials().add(new Monomial(7, 10));
        p4.getMonomials().add(new Monomial(-4, 3));
        p4.getMonomials().add(new Monomial(2, 3));
        p4.getMonomials().add(new Monomial(5, 6));
        p4.getMonomials().add(new Monomial(-2, 6));
        p4.getMonomials().add(new Monomial(-3, 6));
        Polynomial p5 = new Polynomial();
        p5.getMonomials().add(new Monomial(2, 3));
        p5.getMonomials().add(new Monomial(4, 7));
        p5.getMonomials().add(new Monomial(10, 1));
        p5.getMonomials().add(new Monomial(4, 0));
        Polynomial p6 = new Polynomial();
        p6.getMonomials().add(new Monomial(-1, 1));
        argumentsList.add(Arguments.of(p1, p2, "3X^3-7X^2+3X-2"));
        argumentsList.add(Arguments.of(p3, p1, "0"));
        argumentsList.add(Arguments.of(p6, p2, "-X^2+2X"));
        argumentsList.add(Arguments.of(p4, p5, "28X^17+14X^13+70X^11+20X^10+4X^9-4X^8-4X^6+2X^5-22X^4+2X^3-6X^2-4X"));
        argumentsList.add(Arguments.of(p1, p6, "-3X^3+X^2-X"));
        return argumentsList;
    }
}
