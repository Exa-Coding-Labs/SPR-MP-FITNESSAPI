package Lab.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

/**
 * The @Entity annotation informs Spring Data to map this object to a database table as part of a paradigm known as
 * 'object-relational-mapping'. By default, the Table and Column names should match the Class and Field names, but this
 * can be overridden. That means that Spring Data can use an existing 'Plan' table to automatically persist
 * this object as a database record, and it can retrieve 'Plan' objects from the 'Plan' table. Spring Data can
 * even create and modify tables for you, although this would not likely be done on real projects. See the
 * application.properties file in the resources folder for more info. Spring ORM Entities leverage the Hibernate
 * framework - you may see Hibernate when reading Stack traces or researching documentation.
 *
 * For the purpose of completing any challenges within this project: do not change anything within this class!
 * It is already complete.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Gym {
    /**
     * Id marks this column as the primary key & identifier for this Plan entity.
     * This value should be automatically generated (it will autoincrement).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long planId;
    /**
     * A column of the Gym table
     */
    @Column
    private String address;

}
