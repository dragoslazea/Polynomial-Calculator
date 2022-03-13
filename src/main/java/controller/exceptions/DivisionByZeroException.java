package controller.exceptions;

// Exceptie aruncata in cazul in care utilizatorul incearca impartirea la 0
public class DivisionByZeroException extends Exception {
    public DivisionByZeroException(){
        super("Error: Division by 0!");
    }

    public DivisionByZeroException(String errMsg){
        super(errMsg);
    }
}
