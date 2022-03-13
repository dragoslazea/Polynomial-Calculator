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

// Clasa de test pentru operatia de adunare
public class TestAddOperation {
    private CalcModel model = new CalcModel();
    @ParameterizedTest
    @MethodSource("provideInput")
    void testAdditionOperation(Polynomial p1, Polynomial p2, String expectedResult){
        model.setP(p1);
        model.setQ(p2);
        model.addPolynomials();
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
        p5.getMonomials().add(new Monomial(9, 7));
        p5.getMonomials().add(new Monomial(1, 2));
        argumentsList.add(Arguments.of(p1, p2, "3X^3+X^2+X"));
        argumentsList.add(Arguments.of(p3, p4, "4X^5-X^3+2X^2-6X"));
        argumentsList.add(Arguments.of(p1, p3, "4X^5-3X^4+2X^3+2X^2-8X+1"));
        argumentsList.add(Arguments.of(p2, p4, "3X^4+X^2+3X-1"));
        argumentsList.add(Arguments.of(p1, p5, "9X^7+2X^3+2X^2"));
        return  argumentsList;
    }
}
