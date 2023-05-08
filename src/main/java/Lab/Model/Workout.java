package Lab.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
/**
 * The @Entity annotation informs Spring Data to map this object to a database table as part of a paradigm known as
 * 'object-relational-mapping'. By default, the Table and Column names should match the Class and Field names, but this
 * can be overridden. That means that Spring Data can use an existing 'Workout' table to automatically persist
 * this object as a database record, and it can retrieve 'Workout' objects from the 'Workout' table. Spring Data can
 * even create and modify tables for you, although this would not likely be done on real projects. See the
 * application.properties file in the resources folder for more info. Spring ORM Entities leverage the Hibernate
 * framework - you may see Hibernate when reading Stack traces or researching documentation.
 *
 * For the purpose of completing any challenges within this project: do not change anything within this class!
 * It is already complete.
 */
@Entity
public class Workout {
    /**
     * Mark this column as the primary key & identifier for this Plan entity.
     * Also, this value should be automatically generated (it will autoincrement).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long workoutId;
    /**
     * A column of the Workout table
     */
    @Column
    private String title;
    /**
     * The ManyToOne annotation will associate this entity with Plan entities. In the SQL table itself,
     * the Plan table will have a foreign key to the Workout table. If the developer retrieves Plan entities from
     * this class, it will be a List of real Plan entities connected with the database.
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "workoutFK")
    private List<Plan> plans;

    public long getId() {
        return workoutId;
    }

    public void setId(long workoutId) {
        this.workoutId = workoutId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    public Workout(){

    }

    public Workout(long workoutId, String title, List<Plan> plans) {
        this.workoutId = workoutId;
        this.title = title;
        this.plans = plans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return workoutId == workout.workoutId && Objects.equals(title, workout.title) && Objects.equals(plans, workout.plans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutId, title, plans);
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + workoutId +
                ", title='" + title + '\'' +
                ", plans=" + plans +
                '}';
    }
}
