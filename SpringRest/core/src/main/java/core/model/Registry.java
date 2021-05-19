package core.model;


import jdk.jfr.Enabled;
import lombok.*;

import javax.persistence.Entity;
import java.util.Objects;

/**
 * @author Stefan Nemtoc
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Registry extends BaseEntity<Long> {
    private int productionLotID;
    private int employeeID;
    private String date;

    /**
     * Returns the object productionLotID
     *
     * @return an {@code Int} - the object productionLotID
     *
     */
    public int getProductionLotID() {
        return productionLotID;
    }

    /**
     * Sets the object productionLotID
     *
     * @param productionLotID the employeeID to be set
     *
     */
    public void setProductionLotID(int productionLotID) {
        this.productionLotID = productionLotID;
    }


    /**
     * Returns the object employeeID
     *
     * @return an {@code Int} - the object employeeID
     *
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Sets the object employeeID
     *
     * @param employeeID the employeeID to be set
     *
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }


    /**
     * Returns the object date
     *
     * @return an {@code String} - the object date
     *
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the object date
     *
     * @param date the date to be set
     *
     */
    public void setDate(String date) {
        this.date = date;
    }
}