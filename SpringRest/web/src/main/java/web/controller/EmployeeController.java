package web.controller;

import core.model.Employee;
import core.service.EmployeeService;
import core.service.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.converter.EmployeeConverter;
import web.dto.EmployeeDto;
import web.dto.EmployeesDto;

import java.time.LocalDate;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeConverter employeeConverter;

    public static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    @RequestMapping(value  = "/employees", method = RequestMethod.GET)
    public EmployeesDto getAllEmployees(){
        log.trace("getAllEmployees -- method start");
        return new EmployeesDto(employeeConverter.convertModelsToDtos(
                employeeService.getAllEmployees()));
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
        log.trace("addEmployee --- method start");

        var employee = employeeConverter.convertDtoToModel(employeeDto);
        log.trace("employee converted from dto to model, employee={}", employee);

        var result = employeeService.addEmployee(employee);
        log.trace("result from add employee from employeeService, result={}", result);

        var resultModel = employeeConverter.convertModelToDto(result);
        log.trace("addEmployee --- method end");

        return resultModel;
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        log.trace("deleteEmployee --- method start");
        employeeService.deleteEmployee(id);
        log.trace("deleteEmployee --- method end");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto dto) {
        Employee employee = employeeConverter.convertDtoToModel(dto);
        employee.setId(id);
        return employeeConverter.convertModelToDto(employeeService.updateEmployee(employee));
    }

    @RequestMapping(value  = "/employees/findOne/{id}", method = RequestMethod.GET)
    public EmployeesDto findOneEmployee(@PathVariable Long id){
        log.trace("findOneEmployee -- method start");
        return new EmployeesDto(employeeConverter.convertModelsToDtos(
                employeeService.findOneEmployee(id)));
    }

    @RequestMapping(value = "/employees/filterByName/{name}", method = RequestMethod.GET)
    public EmployeesDto filterByName(@PathVariable String name) {
        log.trace("filterByName --- method start");
        return new EmployeesDto(employeeConverter.convertModelsToDtos(
                employeeService.filterByName(name)));
    }

    @RequestMapping(value = "/employees/filterByBirthDate/{birthDate}", method = RequestMethod.GET)
    public EmployeesDto filterByBirthDate(@PathVariable LocalDate birthDate) {
        log.trace("filterByBirthDate --- method start");
        return new EmployeesDto(employeeConverter.convertModelsToDtos(
                employeeService.filterByBirthDate(birthDate)));
    }

    @RequestMapping(value = "/employees/filterBySalary/{salary}", method = RequestMethod.GET)
    public EmployeesDto filterBySalary(@PathVariable int salary) {
        log.trace("filterBySalary --- method start");
        return new EmployeesDto(employeeConverter.convertModelsToDtos(
                employeeService.filterBySalary(salary)));
    }
}