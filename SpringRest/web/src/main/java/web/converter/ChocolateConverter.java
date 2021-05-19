package web.converter;

import core.model.Chocolate;
import org.springframework.stereotype.Component;
import web.dto.ChocolateDto;

@Component
public class ChocolateConverter extends BaseConverter<Chocolate, ChocolateDto> {
    @Override
    public Chocolate convertDtoToModel(ChocolateDto dto) {
        var model = new Chocolate();
        model.setName(dto.getName());
        model.setIngredients(dto.getIngredients());
        model.setWeight(dto.getWeight());
        model.setPrice(dto.getPrice());
        return model;
    }

    @Override
    public ChocolateDto convertModelToDto(Chocolate chocolate) {
        ChocolateDto dto = new ChocolateDto(chocolate.getName(), chocolate.getIngredients(), chocolate.getWeight(), chocolate.getPrice());
        dto.setId(chocolate.getId());
        return dto;
    }
}
