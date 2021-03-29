package expression.exceptions;

public class DivisionByZeroException extends ArithmeticException {
    public DivisionByZeroException(String left) {
        super("Division by zero error: " + left + " / 0");
    }
}
