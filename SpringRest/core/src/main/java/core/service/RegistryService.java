package core.service;

import core.model.Registry;

import java.util.List;

public interface RegistryService {
    List<Registry> getAllRegistries();
    Registry addRegistry(Registry registry);
    void deleteRegistry(Long id);
    Registry updateRegistry(Registry registry);

    List<Registry> filterRegistryByProductionLotID(int productionLotID);
    List<Registry> filterRegistryByEmployeeID(int employeeID);
    List<Registry> filterRegistryByDate(String date);
}