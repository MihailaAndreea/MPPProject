package web.dto;

import lombok.*;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)

public class ProductionLotDto extends BaseDto{
    private int chocolateID;
    private int quantity;
    private String productionDate;
    private String expirationDate;
}
