package web.controller;

import core.model.ProductionLot;
import core.service.EmployeeServiceImpl;
import core.service.ProductionLotImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.converter.ProductionLotConverter;
import web.dto.ProductionLotDto;
import web.dto.ProductionLotsDto;

@RestController
public class ProductionLotController {

    @Autowired
    private ProductionLotImpl productionLotService;

    @Autowired
    private ProductionLotConverter productionLotConverter;

    public static final Logger log = LoggerFactory.getLogger(ProductionLotImpl.class);


    @RequestMapping(value  = "/productionLots", method = RequestMethod.GET)
    public ProductionLotsDto getAllProductionLots(){
        log.trace("getAllProductionLots -- method start");
        return new ProductionLotsDto(productionLotConverter.convertModelsToDtos(
                productionLotService.getAll()));
    }

     @RequestMapping(value  = "/", method = RequestMethod.GET)
     public String getAll(){
         System.err.println("here");
        return "garbage";
    }

    @RequestMapping(value = "/productionLots", method = RequestMethod.POST)
    public ProductionLotDto addProductionLot(@RequestBody ProductionLotDto productionLotDto)
    {
        log.trace("addProductionLot -- method start");
        var productionLot = productionLotConverter.convertDtoToModel(productionLotDto);
        var result = productionLotService.addProductionLot(productionLot);
        var resultModel = productionLotConverter.convertModelToDto(result);
        log.trace("addProductionLot -- method finished");
        return resultModel;
    }

    @RequestMapping(value = "/productionLots/{id}", method = RequestMethod.PUT)
    public ProductionLotDto updateProductionLot(@PathVariable Long id,
                             @RequestBody ProductionLotDto dto) {
        log.trace("updateProductionLot -- method started");
        ProductionLot productionLot = productionLotConverter.convertDtoToModel(dto);
        productionLot.setId(id);
        return
                productionLotConverter.convertModelToDto(
                        productionLotService.updateProductionLot(
                                productionLot
                        ));
    }

    @RequestMapping(value = "/productionLots/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProductionLot(@PathVariable Long id)
    {
        log.trace("deleteProductionLot -- method started");
        productionLotService.deleteProductionLot(id);
        log.trace("deleteProductionLot -- method finished");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value  = "/productionLots/findOne/{id}", method = RequestMethod.GET)
    public ProductionLotsDto findOneProductionLot(@PathVariable Long id){
        log.trace("findOneProductionLot -- method start");
        return new ProductionLotsDto(productionLotConverter.convertModelsToDtos(
                productionLotService.findOneProductionLot(id)));
    }

    @RequestMapping(value  = "/productionLots/filterByChocoID/{id}", method = RequestMethod.GET)
    public ProductionLotsDto filterByChocoID(@PathVariable int id){
        log.trace("filterByChocoID -- method start");
        return new ProductionLotsDto(productionLotConverter.convertModelsToDtos(
                productionLotService.filterByChocoID(id)));
    }

    @RequestMapping(value  = "/productionLots/findByOrderByChocolateIDAsc/", method = RequestMethod.GET)
    public ProductionLotsDto findByOrderByChocolateIDAsc(){
        log.trace("findByOrderByChocolateIDAsc -- method start");
        return new ProductionLotsDto(productionLotConverter.convertModelsToDtos(
                productionLotService.findByOrderByChocolateIDAsc()));
    }

    @RequestMapping(value  = "/productionLots/filterByQuantity/{quantity}", method = RequestMethod.GET)
    public ProductionLotsDto filterByQuantity(@PathVariable int quantity){
        log.trace("filterByQuantity -- method start");
        return new ProductionLotsDto(productionLotConverter.convertModelsToDtos(
                productionLotService.filterByQuantity(quantity)));
    }

    @RequestMapping(value  = "/productionLots/filterByProductionDate/{productionDate}", method = RequestMethod.GET)
    public ProductionLotsDto filterByProductionDate(@PathVariable String productionDate){
        log.trace("filterByQuantity -- method start");
        return new ProductionLotsDto(productionLotConverter.convertModelsToDtos(
                productionLotService.filterByProductionDate(productionDate)));
    }

    @RequestMapping(value  = "/productionLots/filterByExpirationDate/{expirationDate}", method = RequestMethod.GET)
    public ProductionLotsDto filterByExpirationDate(@PathVariable String expirationDate){
        log.trace("filterByQuantity -- method start");
        return new ProductionLotsDto(productionLotConverter.convertModelsToDtos(
                productionLotService.filterByExpirationDate(expirationDate)));
    }
}
