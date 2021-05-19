package core.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Employee class and its methods.
 *
 * @author anita.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Employee extends BaseEntity<Long> {
    @Column
    private String name;
    @Column
    private LocalDate birthDate;
    @Column
    private int salary;

    /**
     * Default constructor
     */

    /**
     * Parameterized constructor.
     *
     * @param name
     * @param birthDate
     * @param salary
     *
     */

    /**
     * Returns the object name
     *
     * @return an {@code String} - the object name
     *
     */
    public String getName() { return name; }

    /**
     * Sets the object name
     *
     * @param name the name to be set
     *
     */
    public void setName(String name) { this.name = name; }

    /**
     * Returns the object birth date
     *
     * @return an {@code LocalDate} - the object birth date
     *
     */
    public LocalDate getBirthDate() { return birthDate; }

    /**
     * Sets the object birth date
     *
     * @param birthDate the birth date to be set
     *
     */
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    /**
     * Returns the object salary
     *
     * @return an {@code int} - the object salary
     *
     */
    public int getSalary() { return salary; }

    /**
     * Sets the object salary
     *
     * @param salary the salary to be set
     *
     */
    public void setSalary(int salary) { this.salary = salary; }

}