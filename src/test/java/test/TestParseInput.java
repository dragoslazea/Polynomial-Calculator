package test;

import controller.CalcController;
import controller.exceptions.InvalidPolynomialException;
import model.CalcModel;
import model.Monomial;
import model.Polynomial;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import view.CalcView;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Clasa pentru testarea parsarii (transformarea string-urilor introduse in interfata grafica
public class TestParseInput {
    private CalcModel model = new CalcModel();
    private CalcView view = new CalcView(model);
    private CalcController controller = new CalcController(model, view);
    @ParameterizedTest
    @MethodSource("provideInput")
    void testParseInput(String input, String expectedResult){
        try {
            view.setPTextField(input);
            controller.parseInputP(); // metoda parseInputQ() are acelasi principiu de functionare precum metoda parseInputQ(), deci aceasta nu va mai fi testata explicit
            assertEquals(expectedResult, model.getP().toString());
        } catch (InvalidPolynomialException e){
            System.out.println(e.getMessage() + " " + input);
        }
    }
    private static List<Arguments> provideInput(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of("x^2 +  9x + 6", "X^2+9X+6"));
        argumentsList.add(Arguments.of("-x^2 +  9x + 6", "-X^2+9X+6"));
        argumentsList.add(Arguments.of("-x+3", "-X+3"));
        argumentsList.add(Arguments.of("2X  -1 ", "2X-1"));
        argumentsList.add(Arguments.of("X^7 -  7X^4 ", "X^7-7X^4"));
        return  argumentsList;
    }

}
