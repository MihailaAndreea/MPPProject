package core.model.validators;

/**
 * @author anita.
 */

public class ValidatorException extends ChocolateFactoryException{
    public ValidatorException(String message) {
        super(message);
    }

    public ValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidatorException(Throwable cause) {
        super(cause);
    }
}
