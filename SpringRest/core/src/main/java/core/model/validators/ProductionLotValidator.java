package core.model.validators;
import core.model.ProductionLot;

import java.util.Optional;

public class ProductionLotValidator implements Validator<ProductionLot> {
    @Override
    public void validate(ProductionLot entity) throws ValidatorException {
        Optional.ofNullable(entity).orElseThrow(() -> new ValidatorException("ProductionLot can not be null"));
        Optional.ofNullable(entity.getChocolateID()).orElseThrow(() -> new ValidatorException("Chocolate ID can not be empty"));
        Optional.ofNullable(entity.getQuantity()).orElseThrow(() -> new ValidatorException("Quantity can not be empty"));
        Optional.ofNullable(entity.getProductionDate()).orElseThrow(() -> new ValidatorException("Production date can not be null"));
        Optional.ofNullable(entity.getExpirationDate()).orElseThrow(() -> new ValidatorException("Expiration date can not be null"));
    }
}