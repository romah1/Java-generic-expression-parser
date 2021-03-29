package expression.exceptions;

public class WrongArgumentsException extends Exception {
    public WrongArgumentsException(String message) {
        super("Wrong command line arguments: " + message);
    }
}
