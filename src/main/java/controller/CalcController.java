package controller;
import controller.exceptions.DivisionByZeroException;
import controller.exceptions.InvalidPolynomialException;
import model.CalcModel;
import model.Monomial;
import model.Polynomial;
import view.CalcView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Clasa pentru controller-ul aplicatiei
public class CalcController {
    // Variabile instanta - modelul si vizualizarea
    private CalcModel model;
    private CalcView view;

    // Constructor
    public CalcController(CalcModel m, CalcView v){
        this.model = m;
        this.view = v;

        // Se adauga ascultatori la butoanele din GUI
        this.view.addAddListener(new AddListener());
        this.view.addSubListener(new SubListener());
        this.view.addMulListener(new MulListener());
        this.view.addDivListener(new DivListener());
        this.view.addDifListener(new DifListener());
        this.view.addIntListener(new IntListener());
        this.view.addClearListener(new ClearListener());
    }

    // Functii pentru parsarea string-urilor introduse in interfata grafica sub forma de polinoame (pot arunca IvalidPolynomialException)
    public void parseInputP() throws InvalidPolynomialException {
        ArrayList<String> mon = Validity.splitToMonomials(this.view.getInputP());
        for (String m : mon){
            this.model.getP().getMonomials().add(Monomial.parseMonomial(m));
        }
    }

    public void parseInputQ() throws InvalidPolynomialException{
        ArrayList<String> mon = Validity.splitToMonomials(this.view.getInputQ());
        for (String m : mon){
            this.model.getQ().getMonomials().add(Monomial.parseMonomial(m));
        }
    }

    // Clase interne ce definesc listenerii pentru cele 7 butoane ale GUI

    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.reset();
                view.resetResult();
                parseInputP();
                parseInputQ();
                model.addPolynomials();
                view.setResult(model.getResult());
            } catch (InvalidPolynomialException ex){
                view.showError(ex.getMessage());
            }
        }
    }

    class SubListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.reset();
                view.resetResult();
                parseInputP();
                parseInputQ();
                model.subPolynomials();
                view.setResult(model.getResult());
            } catch (InvalidPolynomialException ex){
                view.showError(ex.getMessage());
            }
        }
    }

    class MulListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.reset();
                view.resetResult();
                parseInputP();
                parseInputQ();
                model.mulPolynomials();
                view.setResult(model.getResult());
            } catch (InvalidPolynomialException ex){
                view.showError(ex.getMessage());
            }
        }
    }

    class DivListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.resetResult();
                view.resetResult();
                parseInputP();
                parseInputQ();
                if(view.getInputQ().equals("0")){
                    throw new DivisionByZeroException();
                }
                model.divPolynomials();
                view.setResult("Quotient: " + model.getResult() + ", Remainder: " + model.getRemainder());
            } catch (InvalidPolynomialException ex){
                view.showError(ex.getMessage());
            } catch (DivisionByZeroException divEx){ // Exceptie: Impartirea la 0
                view.showError(divEx.getMessage()); // Daca se incearca impartirea la 0, utilizatorul este notificat
            }
        }
    }

    class DifListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.reset();
                view.resetResult();
                parseInputP();
                model.difPolynomial();
                view.setResult("dP/dX = " + model.getResult());
            } catch (InvalidPolynomialException ex){
                view.showError(ex.getMessage());
            }
        }
    }

    class IntListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.reset();
                view.resetResult();
                parseInputP();
                model.intPolynomial();
                if (model.getResult().equals("o")){
                    view.setResult("∫P(X)dX = C");
                } else {
                    view.setResult("∫P(X)dX = " + model.getResult() + "+C");
                }
            } catch (InvalidPolynomialException ex){
                view.showError(ex.getMessage());
            }
        }
    }

    class ClearListener implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.reset();
            view.reset();
        }
    }

}
