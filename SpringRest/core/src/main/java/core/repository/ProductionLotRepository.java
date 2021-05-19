package core.repository;

import core.model.ProductionLot;

import java.util.List;

public interface ProductionLotRepository extends ChocolateFactoryRepository<ProductionLot, Long>{
    List<ProductionLot> findByChocolateID(int chocolateID);
    List<ProductionLot> findByQuantity(int quantity);
    List<ProductionLot> findByProductionDate(String productionDate);
    List<ProductionLot> findByExpirationDate(String expirationDate);
    List<ProductionLot> findByOrderByChocolateIDAsc();
}
