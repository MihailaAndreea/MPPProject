package core.service;

import core.model.Employee;
import core.model.ProductionLot;
import core.repository.ChocolateRepository;
import core.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        log.trace("getAllEmployees --- method start");
        List<Employee> result = employeeRepository.findAll();
        log.trace("getAllEmployees: result={}", result);
        return result;
    }

    @Override
    public Employee addEmployee(Employee e) {
        log.trace("addEmployee --- method start");
        Employee employee = employeeRepository.save(e);
        log.trace("addEmployee --- method finished: chocolate={}", employee);
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        try {
            log.trace("deleteEmployee --- method start");
            employeeRepository.deleteById(id);
            Optional<Employee> op = employeeRepository.findById(id);
            if (op.isPresent()) {
                log.trace("deleteEmployee --- method finished");
            }
            log.trace("deleteEmployee --- method finished");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            log.trace("deleteEmployee --- exception" + e.getMessage());
        }
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        try {
            log.trace("updateEmployee --- method start");
            employeeRepository.findById(employee.getId())
                    .ifPresent(e -> {
                        e.setName(e.getName());
                        e.setBirthDate(e.getBirthDate());
                        e.setSalary(e.getSalary());
                        log.debug("updateEmployee --- updated: ch={}", e);
                    });
            Optional<Employee> op = employeeRepository.findById(employee.getId());
            log.trace("updateEmployee --- method finished, entity updated: op={}", op);
            return op.orElseGet(op::get);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            log.trace("updateEmployee --- exception" + e.getMessage());
            return new Employee();
        }
    }

    public List<Employee> findOneEmployee(Long id) {
        try{
            log.trace("findOneEmployee -- method start");
            List<Employee> employeeList = getAllEmployees().stream()
                    .filter(employee -> employee.getId().equals(id))
                    .collect(Collectors.toList());
            log.trace("findOneEmployee -- method finished, employee={}", employeeList);
            return  employeeList;
        }
        catch (IllegalArgumentException e)
        {
            log.trace("findOneEmployee -- exception" + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<Employee> filterByName(String name) {
        log.trace("filterByName SERVICE METHOD");
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> filterByBirthDate(LocalDate date) {
        log.trace("filterByBirthDate SERVICE METHOD");
        return employeeRepository.findByBirthDate(date);
    }

    @Override
    public List<Employee> filterBySalary(int salary) {
        log.trace("filterBySalary SERVICE METHOD");
        return employeeRepository.findBySalary(salary);
    }
}