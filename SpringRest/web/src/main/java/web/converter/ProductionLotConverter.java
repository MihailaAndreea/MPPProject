package web.converter;

import core.model.ProductionLot;
import org.springframework.stereotype.Component;
import web.dto.ProductionLotDto;

@Component
public class ProductionLotConverter extends BaseConverter<ProductionLot, ProductionLotDto> {

    @Override
    public ProductionLot convertDtoToModel(ProductionLotDto dto) {
        var model = new ProductionLot();
        model.setChocolateID(dto.getChocolateID());
        model.setQuantity(dto.getQuantity());
        model.setProductionDate(dto.getProductionDate());
        model.setExpirationDate(dto.getExpirationDate());
        return model;
    }

    @Override
    public ProductionLotDto convertModelToDto(ProductionLot productionLot) {
        ProductionLotDto dto = new ProductionLotDto(productionLot.getChocolateID(), productionLot.getQuantity(), productionLot.getProductionDate(), productionLot.getExpirationDate());
        dto.setId(productionLot.getId());
        return dto;
    }
}
