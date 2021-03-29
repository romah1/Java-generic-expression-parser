package expression.exceptions;

public class UnsupportedTypeException extends Exception {
    public UnsupportedTypeException(String type) {
        super("Unsupported type: " + type);
    }
}
