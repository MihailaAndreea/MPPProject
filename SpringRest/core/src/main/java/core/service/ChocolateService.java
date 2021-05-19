package core.service;

import core.model.Chocolate;

import java.util.Collection;
import java.util.List;

public interface ChocolateService {
    List<Chocolate> getAllChocolates();
    Chocolate addChocolate(Chocolate chocolate);
    void deleteChocolate(Long id);
    Chocolate updateChocolate(Chocolate chocolate);

    List<Chocolate> filterByName(String name);
    List<Chocolate> filterByWeight(double weight);
    List<Chocolate> filterByPrice(double price);
}
