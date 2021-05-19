package core.model.validators;


import core.model.Registry;

import java.util.Optional;

/**
 * Validator class for Registry entities.
 * @author Stefan Nemtoc.
 */
public class RegistryValidator implements Validator<Registry>{
    @Override
    public void validate(Registry entity) throws ValidatorException {
        Optional.ofNullable(entity).orElseThrow(() -> new ValidatorException("ProductionLot can not be null"));
        Optional.of(entity.getProductionLotID()).orElseThrow(() -> new ValidatorException("Chocolate ID can not be empty"));
        Optional.of(entity.getEmployeeID()).orElseThrow(() -> new ValidatorException("Quantity can not be empty"));
        Optional.ofNullable(entity.getDate()).orElseThrow(() -> new ValidatorException("Production date can not be null"));
    }
}
