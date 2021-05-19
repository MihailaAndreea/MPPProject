package web.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RegistryDto extends BaseDto{
    private String date;
    private int employeeId;
    private int productionLotId;
}