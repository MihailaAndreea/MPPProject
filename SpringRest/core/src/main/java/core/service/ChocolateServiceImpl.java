package core.service;

import core.model.Chocolate;
import core.repository.ChocolateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChocolateServiceImpl implements ChocolateService{

    @Autowired
    private ChocolateRepository chocolateRepository;

    public static final Logger log = LoggerFactory.getLogger(ChocolateServiceImpl.class);

    @Override
    public List<Chocolate> getAllChocolates() {
        log.trace("getAllChocolates SERVICE METHOD");
        return chocolateRepository.findAll();

    }

    @Override
    public Chocolate addChocolate(Chocolate chocolate) {
        log.trace("addChocolates SERVICE METHOD");
        return chocolateRepository.save(chocolate);
    }

    @Override
    public void deleteChocolate(Long id) {
        log.trace("deleteChocolates SERVICE METHOD");
        chocolateRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Chocolate updateChocolate(Chocolate chocolate) {
        log.trace("updateChocolates SERVICE METHOD");
        Chocolate updatedChocolate = chocolateRepository.findById(chocolate.getId()).orElseThrow();
        updatedChocolate.setName(chocolate.getName());
        updatedChocolate.setIngredients(chocolate.getIngredients());
        updatedChocolate.setWeight(chocolate.getWeight());
        updatedChocolate.setPrice(chocolate.getPrice());
        return updatedChocolate;
    }

    /**
     * calls findByName method from jpa and automatically tries to findByName without any actual implementation
     * @param name
     * @return
     */
    @Override
    public List<Chocolate> filterByName(String name) {
        log.trace("filterByName SERVICE METHOD");
        return chocolateRepository.findByName(name);
    }

    @Override
    public List<Chocolate> filterByWeight(double weight) {
        log.trace("filterByWeight SERVICE METHOD");
        return chocolateRepository.findByWeight(weight);
    }

    @Override
    public List<Chocolate> filterByPrice(double price) {
        log.trace("filterByPrice SERVICE METHOD");
        return chocolateRepository.findByPrice(price);
    }
}
