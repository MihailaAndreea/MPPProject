package core.model.validators;

import core.model.Chocolate;
import core.model.validators.Validator;

import java.util.Optional;

/**
 * @author vali
 */
public class ChocolateValidator implements Validator<Chocolate> {
    @Override
    public void validate(Chocolate entity) throws ValidatorException {
        Optional.ofNullable(entity).orElseThrow(()-> new ValidatorException("Chocolate cannot be null!"));
        Optional.of(entity.getId()).orElseThrow(() -> new ValidatorException("Chocolate's id cannot be null!"));
        Optional.ofNullable(entity.getName()).orElseThrow(() -> new ValidatorException("Chocolate's name cannot be null!"));
        Optional.ofNullable(entity.getIngredients()).orElseThrow(() -> new ValidatorException("Chocolate's ingredients cannot be null!"));
        Optional.of(entity.getWeight()).orElseThrow(() -> new ValidatorException("Chocolate's weight cannot be null!"));
        Optional.of(entity.getPrice()).orElseThrow(() -> new ValidatorException("Chocolate's price cannot be null!"));

        if (entity.getPrice() < 0)
            throw new ValidatorException("Price cannot be negative!");

        if (entity.getWeight() < 0)
            throw new ValidatorException("Weight cannot be negative!");
    }
}
