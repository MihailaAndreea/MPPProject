package core.service;

import core.repository.ProductionLotRepository;
import core.model.ProductionLot;
import core.repository.RepositoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductionLotImpl{

    public static final Logger log = LoggerFactory.getLogger(ChocolateServiceImpl.class);

    @Autowired
    private ProductionLotRepository productionLotRepository;

    public List<ProductionLot> getAll() {
        log.trace("getAll --- method start");
        List<ProductionLot> result = productionLotRepository.findAll();
        log.trace("getAll: result={}", result);
        return result;
    }

    public ProductionLot  addProductionLot(ProductionLot productionLot) {
        log.trace("addProductionLot -- method start");
        ProductionLot productionLot1 = productionLotRepository.save(productionLot);
        log.trace("addProductionLot: result={}", productionLot1);
        return productionLot1;
    }

    public String deleteProductionLot(Long id) {
        try {
            log.trace("deleteProductionLot -- method start");
            productionLotRepository.deleteById(id);
            Optional<ProductionLot> op = productionLotRepository.findById(id);
            if (op.isPresent()) {
                log.trace("deleteProductionLot --- method finished");
                return "ProductionLot deleted!";
            }
            log.trace("deleteProductionLot --- method finished");
            return "ProductionLot not deleted!";
        } catch (RepositoryException e) {
            log.trace("deleteProductionLot -- exception" + e.getMessage());
            return "ProductionLot not deleted!";
        }
    }

    @Transactional
    public ProductionLot updateProductionLot(ProductionLot productionLot) {
        try {
            log.trace("updateProductionLot -- method started");
            System.err.println(productionLot.getId());
            productionLotRepository.findById(productionLot.getId())
                    .ifPresent(productionLot1 -> {
                        productionLot1.setChocolateID(productionLot.getChocolateID());
                        productionLot1.setQuantity(productionLot.getQuantity());
                        productionLot1.setProductionDate(productionLot.getProductionDate());
                        productionLot1.setExpirationDate(productionLot.getExpirationDate());
                        log.debug("updateProductionLot --- updated: productionLot1={}", productionLot1);
                    });
            Optional<ProductionLot> op = productionLotRepository.findById(productionLot.getId());
            log.trace("updateProductionLot -- method finished: op={}", op);
            return op.orElseGet(op::get);
        } catch (RepositoryException e) {
            log.trace("updateProductionLot -- exception" + e.getMessage());
            return new ProductionLot();
        }
    }

    public List<ProductionLot> findOneProductionLot(Long id) {
        try{
            log.trace("findOneProductionLot -- method start");
            List<ProductionLot> productionLotList = getAll().stream()
                    .filter(productionLot1 -> productionLot1.getId().equals(id))
                    .collect(Collectors.toList());
            log.trace("findOneProductionLot -- method finished, productionLot={}", productionLotList);
            return  productionLotList;
        }
        catch (IllegalArgumentException e)
        {
            log.trace("findOneProductionLot -- exception" + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<ProductionLot> findByOrderByChocolateIDAsc(){
        log.trace("findByOrderByChocolateIDAsc -- method start");
        return productionLotRepository.findByOrderByChocolateIDAsc();
    }

    public List<ProductionLot> filterByChocoID(int chocoID) {
        log.trace("filterByChocoID -- method start");
//        List<ProductionLot> productionLotList = getAll().stream()
//                .filter(productionLot -> productionLot.getChocolateID() == chocoID)
//                .collect(Collectors.toList());
//        log.trace("filterByChocoID -- method finished, productionLot={}", productionLotList);
        return  productionLotRepository.findByChocolateID(chocoID);
    }

    public List<ProductionLot> filterByQuantity(int quantity) {
//        log.trace("filterByQuantity -- method start");
//        List<ProductionLot> productionLotList = getAll().stream()
//                .filter(productionLot -> productionLot.getQuantity() == quantity)
//                .collect(Collectors.toList());
//        log.trace("filterByQuantity -- method finished, productionLot={}", productionLotList);
        return  productionLotRepository.findByQuantity(quantity);
    }

    public List<ProductionLot> filterByProductionDate(String productionDate) {
//        log.trace("filterByProductionDate -- method start");
//        List<ProductionLot> productionLotList = getAll().stream()
//                .filter(productionLot -> productionLot.getProductionDate().equals(productionDate))
//                .collect(Collectors.toList());
//        log.trace("filterByProductionDate -- method finished, productionLot={}", productionLotList);
        return  productionLotRepository.findByProductionDate(productionDate);
    }

    public List<ProductionLot> filterByExpirationDate(String expirationDate) {
//        log.trace("filterByExpirationDate -- method start");
//        List<ProductionLot> productionLotList = getAll().stream()
//                .filter(productionLot -> productionLot.getExpirationDate().equals(expirationDate))
//                .collect(Collectors.toList());
//        log.trace("filterByExpirationDate -- method finished, productionLot={}", productionLotList);
        return  productionLotRepository.findByExpirationDate(expirationDate);
    }
}
