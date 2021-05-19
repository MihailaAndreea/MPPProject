package core.model.validators;

/**
 * @author anita.
 */
public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}
