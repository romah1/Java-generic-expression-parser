package expression.exceptions;

public class NullExpressionException extends Exception {
    public NullExpressionException() {
        super("Expression is null");
    }
}
