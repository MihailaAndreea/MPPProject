package web.dto;

import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)

public class EmployeeDto extends  BaseDto{
    private String name;
    private LocalDate birthDate;
    private int salary;
}