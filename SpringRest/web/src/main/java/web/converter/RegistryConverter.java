package web.converter;

import core.model.Registry;
import org.springframework.stereotype.Component;
import web.dto.RegistryDto;
//
@Component
public class RegistryConverter extends  BaseConverter<Registry, RegistryDto> {

    @Override
    public Registry convertDtoToModel(RegistryDto dto) {
        var model = new Registry();

        model.setDate(dto.getDate());
        model.setEmployeeID(dto.getEmployeeId());
        model.setProductionLotID(dto.getProductionLotId());
        return model;
    }

    @Override
    public RegistryDto convertModelToDto(Registry registry) {
        RegistryDto dto = new RegistryDto(registry.getDate(), registry.getEmployeeID(), registry.getProductionLotID());
        dto.setId(registry.getId());
        return dto;
    }
}