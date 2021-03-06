package core.service;

import core.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ChocolateFactoryRepository<T extends BaseEntity<ID>, ID extends Serializable> extends JpaRepository<T, ID> {

}
