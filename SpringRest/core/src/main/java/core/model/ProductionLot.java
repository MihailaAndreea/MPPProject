package core.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Andreea
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public final class ProductionLot extends BaseEntity<Long>{
    @Column
    private int chocolateID;
    @Column
    private int quantity;
    @Column
    private String productionDate;
    @Column
    private String expirationDate;

//    public ProductionLot()
//    {
//        this.chocolateID = 0;
//        this.quantity = 0;
//        this.productionDate = "";
//        this.expirationDate = "";
//    }

//    public ProductionLot(Long aLong, int chocolateID, int quantity, String productionDate, String expirationDate) {
//        this.id = aLong;
//        this.chocolateID = chocolateID;
//        this.quantity = quantity;
//        this.productionDate = productionDate;
//        this.expirationDate = expirationDate;
//    }
//
//    public ProductionLot(int chocolateID, int quantity, String productionDate, String expirationDate) {
//        this.chocolateID = chocolateID;
//        this.quantity = quantity;
//        this.productionDate = productionDate;
//        this.expirationDate = expirationDate;
//    }

    public int getChocolateID() {
        return chocolateID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setChocolateID(int chocolateID) {
        this.chocolateID = chocolateID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

}
