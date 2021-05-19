package core.service;

import core.model.Registry;
import core.repository.RegistryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

@Service
public class RegistryServiceImpl implements RegistryService {


    public static final Logger log = LoggerFactory.getLogger(RegistryServiceImpl.class);

    @Autowired
    private RegistryRepository registryRepository;

    @Override
    public List<Registry> getAllRegistries() {
        log.trace("getAllChocolates --- method start");
        List<Registry> result = registryRepository.findAll();
        log.trace("getAllRegistries: result={}", result);
        return result;
    }

    @Override
    public Registry addRegistry(Registry registry) {
        log.trace("addRegistry --- method start");
        Registry reg = registryRepository.save(registry);
        log.trace("addRegistry --- method finished: registry={}", reg);
        return reg;
    }

    @Override
    public void deleteRegistry(Long id) {
        log.trace("deleteRegistry SERVICE METHOD");
    }

    @Override
    @Transactional
    public Registry updateRegistry(Registry registry) {
        log.trace("updateRegistry SERVICE METHOD");
        Registry updated = registryRepository.findById(registry.getId()).orElseThrow();
        updated.setDate(registry.getDate());
        updated.setEmployeeID(registry.getEmployeeID());
        updated.setProductionLotID(registry.getProductionLotID());
        return updated;
    }


    @Override
    public List<Registry> filterRegistryByProductionLotID(int productionLotID) {
        log.trace("filterByProductionLotID SERVICE METHOD");
        return registryRepository.findByProductionLotID(productionLotID);
    }

    @Override
    public List<Registry> filterRegistryByEmployeeID(int employeeID) {
        log.trace("filterRegistryByEmployeeID --- method start");
        return registryRepository.findByEmployeeID(employeeID);
    }

    @Override
    public List<Registry> filterRegistryByDate(String date) {
        log.trace("filterRegistryByDate SERVICE METHOD");
        return registryRepository.findByDate(date);
    }
}