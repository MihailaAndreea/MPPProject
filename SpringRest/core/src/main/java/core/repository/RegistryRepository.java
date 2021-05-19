package core.repository;

import core.model.Registry;

import java.util.List;

public interface RegistryRepository extends ChocolateFactoryRepository<Registry, Long> {
    List<Registry> findByDate(String date);
    List<Registry> findByProductionLotID(int productionLotId);
    List<Registry> findByEmployeeID(int employeeId);
}