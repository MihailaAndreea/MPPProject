package core.repository;
import core.model.Employee;

import java.time.LocalDate;
import java.util.List;


public interface EmployeeRepository extends ChocolateFactoryRepository<Employee, Long>{
    List<Employee> findByName(String name);
    List<Employee> findByBirthDate(LocalDate date);
    List<Employee> findBySalary(int salary);
}