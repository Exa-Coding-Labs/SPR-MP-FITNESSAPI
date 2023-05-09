package Lab.Repository;

import Lab.Model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Extending JPARepository<Entity class, ID datatype> grants this class the functionality of a JPARepository:
 * this means that this class will be capable of treating the provided entity as a Java Object that is mapped
 * to a database record automatically using a strategy called Object Relational Mapping.
 *
 * Spring provides any JPARepository with some automatically generated abilities, such as persisting with save(),
 * as well as some automatically generated methods for interacting with databases such as findAll() and findById().
 * These methods do not need to be implemented by the developer at all.
 *
 * This class will work like a Spring Component, but the @Component annotation is not needed here, because the class
 * is an interface. The implementation of JPARepository, which will be a component, will be generated at runtime.
 *
 * For the purpose of completing any challenges within this project: do not change anything within this class!
 * It is already complete. All the functionality needed to complete the Service classes is *already* provided by
 * default!
 */
public interface GymRepository extends JpaRepository<Gym, Long> {
}
