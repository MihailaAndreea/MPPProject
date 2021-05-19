package core.repository;

import core.model.validators.ChocolateFactoryException;

public class RepositoryException extends ChocolateFactoryException {
    public RepositoryException(String message) { super(message); }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositoryException(Throwable cause) { super(cause); }
}