package Lab.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

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
public class Plan {
    /**
     * Mark this column as the primary key & identifier for this Plan entity.
     * Also, this value should be automatically generated (it will autoincrement).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long planId;
    /**
     * A column of the Plan table
     */
    @Column
    private int numberOfReps;
    /**
     * The ManyToOne annotation will associate this entity with a Workout entity. In the SQL table itself,
     * the Plan table will have a foreign key to the Workout table. If the developer retrieves the Workout Object
     * from this class, it will be a real Workout Entity which is mapped to the database.
     *
     * fetch = FetchType.EAGER will load all related entites when this entity is retrieved. FetchType.LAZY would
     * load them only when requested.
     *
     * The @JsonBackReference annotation prevents this field from being part of the Object's JSON. This prevents the
     * field from resulting in an infinite JSON (eg a painting's artist's painting's artist...) You can swap
     * Painting's JsonBackReference with Artist's JsonManagedEntity if you need the Artist to be in the Painting's JSON.
     *
     * The @JoinColumn annotation will define the name of the foreign key column referring to the Workout table.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name="workoutFK")
    private Workout workout;

    public Plan(){

    }

    public Plan(long planId, int numberOfReps, Workout workout) {
        this.planId = planId;
        this.numberOfReps = numberOfReps;
        this.workout = workout;
    }

    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }

    public int getNumberOfReps() {
        return numberOfReps;
    }

    public void setNumberOfReps(int numberOfReps) {
        this.numberOfReps = numberOfReps;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return planId == plan.planId && numberOfReps == plan.numberOfReps && Objects.equals(workout, plan.workout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, numberOfReps, workout);
    }

    @Override
    public String toString() {
        return "Plan{" +
                "planId=" + planId +
                ", numberOfReps=" + numberOfReps +
                ", workout=" + workout +
                '}';
    }
}
