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

// Clasa de test pentru operatia de integrare
public class TestIntOperation {
    private CalcModel model = new CalcModel();
    @ParameterizedTest
    @MethodSource("provideInput")
    void testIntegrationOperation(Polynomial p, String expectedResult){
        model.setP(p);
        model.intPolynomial();
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
        p3.getMonomials().add(new Monomial(5, 4));
        p3.getMonomials().add(new Monomial(-4, 3));
        p3.getMonomials().add(new Monomial(1, 2));
        p3.getMonomials().add(new Monomial(-8, 1));
        p3.getMonomials().add(new Monomial(1, 0));
        Polynomial p4 = new Polynomial();
        p4.getMonomials().add(new Monomial(12, 3));
        p4.getMonomials().add(new Monomial(-3, 2));
        p4.getMonomials().add(new Monomial(2, 1));
        p4.getMonomials().add(new Monomial(2, 0));
        Polynomial p5 = new Polynomial();
        p5.getMonomials().add(new Monomial(0, 0));
        argumentsList.add(Arguments.of(p1, "0.5X^4+0.33X^3"));
        argumentsList.add(Arguments.of(p2, "0.25X^4+0.5X^2"));
        argumentsList.add(Arguments.of(p3, "X^5-X^4+0.33X^3-4X^2+X"));
        argumentsList.add(Arguments.of(p4, "3X^4-X^3+X^2+2X"));
        argumentsList.add(Arguments.of(p5, "0"));
        return  argumentsList;
    }
}
