package expression.exceptions;


public class ArithmeticOverflowException extends ArithmeticException {
    public ArithmeticOverflowException(int left, int right, String sym) {
        super("overflow: " + left + " " + sym + " " + right);
    }

    public ArithmeticOverflowException(int num, String sym) {
        super("overflow: " + sym + num);
    }
}
