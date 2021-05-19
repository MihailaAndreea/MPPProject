package core.model.validators;

/**
 * @author anita.
 */

public class ChocolateFactoryException extends RuntimeException{
    public ChocolateFactoryException(String message) { super(message); }

    public ChocolateFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChocolateFactoryException(Throwable cause) { super(cause); }
}
