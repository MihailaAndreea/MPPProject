package web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ChocolateDto extends BaseDto{
    private String name;
    private String ingredients;
    private double weight;
    private double price;
}
