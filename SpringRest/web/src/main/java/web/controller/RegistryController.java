package web.controller;


import core.model.Registry;
import core.service.RegistryService;
import core.service.RegistryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.converter.RegistryConverter;
import web.dto.RegistriesDto;
import web.dto.RegistryDto;

@RestController
public class RegistryController {
    @Autowired
    private RegistryService registryService;

    @Autowired
    private RegistryConverter registryConverter;

    public static final Logger log = LoggerFactory.getLogger(RegistryServiceImpl.class);

    @RequestMapping(value = "/registries", method = RequestMethod.GET)
    public RegistriesDto getAllRegistries() {
        log.trace("getAllRegistries --- method start");
        return new RegistriesDto(registryConverter.convertModelsToDtos(registryService.getAllRegistries()));
    }

    @RequestMapping(value = "/registries", method = RequestMethod.POST)
    public RegistryDto addRegistry(@RequestBody RegistryDto registryDto) {
        log.trace("addRegistry --- method start");

        var registry = registryConverter.convertDtoToModel(registryDto);
        log.trace("registry converted from dto to model, registry={}", registry);

        var result = registryService.addRegistry(registry);

        log.trace("result from add registry from registryService, result={}", result);

        var resultModel = registryConverter.convertModelToDto(result);
        log.trace("addRegistry --- method end");

        return resultModel;
    }

    @RequestMapping(value = "/registries/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRegistry(@PathVariable Long id) {
        log.trace("deleteRegistry --- method start");
        registryService.deleteRegistry(id);
        log.trace("deleteRegistry --- method end");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/registries/{id}", method = RequestMethod.PUT)
    public RegistryDto updateRegistry(@PathVariable Long id, @RequestBody RegistryDto dto) {
        Registry c = registryConverter.convertDtoToModel(dto);
        c.setId(id);
        return registryConverter.convertModelToDto(registryService.updateRegistry(c));
    }

    @RequestMapping(value = "/registries/filterByDate/{date}", method = RequestMethod.GET)
    public RegistriesDto filterByDate(@PathVariable String date) {
        log.trace("filterByDate --- method start");
        return new RegistriesDto(registryConverter.convertModelsToDtos(
                registryService.filterRegistryByDate(date)));
    }

    @RequestMapping(value = "/registries/filterByEmployeeId/{employeeId}", method = RequestMethod.GET)
    public RegistriesDto filterByEmployeeId(@PathVariable int employeeId) {
        log.trace("filterByEmployeeId --- method start");
        return new RegistriesDto(registryConverter.convertModelsToDtos(
                registryService.filterRegistryByEmployeeID(employeeId)));
    }

    @RequestMapping(value = "/registries/filterByProductionLotId/{productionLotId}", method = RequestMethod.GET)
    public RegistriesDto filterByProductionLotId(@PathVariable int productionLotId) {
        log.trace("filterByProductionLotId --- method start");
        return new RegistriesDto(registryConverter.convertModelsToDtos(
                registryService.filterRegistryByProductionLotID(productionLotId)));
    }
}