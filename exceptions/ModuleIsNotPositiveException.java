package expression.exceptions;

public class ModuleIsNotPositiveException extends ArithmeticException {
    public ModuleIsNotPositiveException(int left, int right) {
        super("Right argument of module is not positive: " + left + " % " + right);
    }
}
