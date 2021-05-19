package web.converter;

import core.model.Employee;
import org.springframework.stereotype.Component;
import web.dto.EmployeeDto;


@Component
public class EmployeeConverter extends BaseConverter<Employee, EmployeeDto> {
    @Override
    public Employee convertDtoToModel(EmployeeDto dto) {
        var model = new Employee();
        model.setName(dto.getName());
        model.setBirthDate(dto.getBirthDate());
        model.setSalary(dto.getSalary());
        return model;
    }

    @Override
    public EmployeeDto convertModelToDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto(employee.getName(), employee.getBirthDate(), employee.getSalary());
        dto.setId(employee.getId());
        return dto;
    }
}