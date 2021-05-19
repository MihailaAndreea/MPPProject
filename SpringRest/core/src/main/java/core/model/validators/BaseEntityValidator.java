package core.model.validators;

import core.model.BaseEntity;

import java.util.Optional;


/**
 * Validator class for Base entity.
 * @author anita.
 */
public class BaseEntityValidator implements Validator<BaseEntity>{

    @Override
    public void validate(BaseEntity entity) throws ValidatorException {
        Optional.ofNullable(entity.getId()).orElseThrow(()-> new ValidatorException("ID can not be null!"));
    }
}
