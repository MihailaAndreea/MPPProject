package core.service;

import core.model.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee) ;
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee employee);

    List<Employee> findOneEmployee(Long id);
    List<Employee> filterByName(String name);
    List<Employee> filterByBirthDate(LocalDate date);
    List<Employee> filterBySalary(int salary);
}