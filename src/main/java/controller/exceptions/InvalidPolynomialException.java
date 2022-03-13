package controller.exceptions;

// Exceptie aruncata in cazul in care utilizatorul introduce un polinom invalid
public class InvalidPolynomialException extends Exception{
    public InvalidPolynomialException(){
        super("Error: Invalid polynomial!");
    }

    public InvalidPolynomialException(String errMsg){
        super(errMsg);
    }
}
