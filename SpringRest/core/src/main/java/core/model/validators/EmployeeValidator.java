package core.model.validators;


import core.model.Employee;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Validator class for Employee entities.
 * @author anita.
 */
public class EmployeeValidator implements Validator<Employee>{
    @Override
    public void validate(Employee entity) throws ValidatorException {
        Optional.ofNullable(entity).orElseThrow(()-> new ValidatorException("Employee can not be null!"));
        Optional.of(entity.getId()).orElseThrow(() -> new ValidatorException("Employee's id cannot be null!"));
        Optional.ofNullable(entity.getName()).orElseThrow(()-> new ValidatorException("Employee name can not be null!"));
        Optional.ofNullable(entity.getBirthDate()).orElseThrow(()-> new ValidatorException("Employee birth date can not be null!"));
        Optional.ofNullable(entity.getSalary()).orElseThrow(()-> new ValidatorException("Employee salary can not be null!"));

        if(LocalDate.now().getYear()-entity.getBirthDate().getYear() <= 18){
            throw new ValidatorException("Employee age must be greater than 18!");
        }
        if(entity.getSalary() < 0){
            throw new ValidatorException("Employee salary must be greater than 0!");
        }
    }
}
