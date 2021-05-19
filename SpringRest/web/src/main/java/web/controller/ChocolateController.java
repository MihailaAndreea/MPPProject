package web.controller;

import core.model.Chocolate;
import core.service.ChocolateService;
import core.service.ChocolateServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.converter.ChocolateConverter;
import web.dto.ChocolateDto;
import web.dto.ChocolatesDto;

@RestController
public class ChocolateController {
    @Autowired
    private ChocolateService chocolateService;

    @Autowired
    private ChocolateConverter chocolateConverter;

    public static final Logger log = LoggerFactory.getLogger(ChocolateServiceImpl.class);

    @RequestMapping(value = "/chocolates", method = RequestMethod.GET)
    public ChocolatesDto getAllChocolates() {
        log.trace("getAllChocolates --- method start");
        return new ChocolatesDto(chocolateConverter.convertModelsToDtos(chocolateService.getAllChocolates()));
    }

    @RequestMapping(value = "/chocolates", method = RequestMethod.POST)
    public ChocolateDto addChocolate(@RequestBody ChocolateDto chocolateDto) {
        log.trace("addChocolate --- method start");

        var chocolate = chocolateConverter.convertDtoToModel(chocolateDto);
        log.trace("chocolate converted from dto to model, chocolate={}", chocolate);

        var result = chocolateService.addChocolate(chocolate);
//        System.out.println(chocolateService.getAllChocolates());
        log.trace("result from add chocolate from chocolateService, result={}", result);

        var resultModel = chocolateConverter.convertModelToDto(result);
        log.trace("addChocolate --- method end");

        return resultModel;
    }

    @RequestMapping(value = "/chocolates/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteChocolate(@PathVariable Long id) {
        log.trace("deleteChocolate --- method start");
        chocolateService.deleteChocolate(id);
        log.trace("deleteChocolate --- method end");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/chocolates/{id}", method = RequestMethod.PUT)
    public ChocolateDto updateChocolate(@PathVariable Long id, @RequestBody ChocolateDto dto) {
        Chocolate c = chocolateConverter.convertDtoToModel(dto);
        c.setId(id);
        return chocolateConverter.convertModelToDto(chocolateService.updateChocolate(c));
    }

    @RequestMapping(value = "/chocolates/filterByName/{name}", method = RequestMethod.GET)
    public ChocolatesDto filterByName(@PathVariable String name) {
        log.trace("filterByName --- method start");
        return new ChocolatesDto(chocolateConverter.convertModelsToDtos(
                chocolateService.filterByName(name)));
    }

    @RequestMapping(value = "/chocolates/filterByWeight/{weight}", method = RequestMethod.GET)
    public ChocolatesDto filterByWeight(@PathVariable double weight) {
        log.trace("filterByWeight --- method start");
        return new ChocolatesDto(chocolateConverter.convertModelsToDtos(
                chocolateService.filterByWeight(weight)));
    }

    @RequestMapping(value = "/chocolates/filterByPrice/{price}", method = RequestMethod.GET)
    public ChocolatesDto filterByPrice(@PathVariable double price) {
        log.trace("filterByPrice --- method start");
        return new ChocolatesDto(chocolateConverter.convertModelsToDtos(
                chocolateService.filterByPrice(price)));
    }
}
