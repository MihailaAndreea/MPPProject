package core.repository;

import core.model.Chocolate;

import java.util.List;


public interface ChocolateRepository extends ChocolateFactoryRepository<Chocolate, Long>{
    List<Chocolate> findByName(String name);
    List<Chocolate> findByWeight(double weight);
    List<Chocolate> findByPrice(double price);
}
