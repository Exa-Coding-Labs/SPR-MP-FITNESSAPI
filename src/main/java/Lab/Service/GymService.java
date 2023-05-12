package Lab.Service;

import Lab.Model.Gym;
import Lab.Model.Workout;
import Lab.Repository.GymRepository;
import Lab.Repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO: implement the Service methods below by interacting with the GymRepository's built in methods.
 * Logging isn't necessary, but it is a good practice.
 */
@Component
public class GymService {
    GymRepository gymRepository;
    WorkoutRepository workoutRepository;
    @Autowired
    public GymService(GymRepository gymRepository, WorkoutRepository workoutRepository){
        this.gymRepository = gymRepository;
        this.workoutRepository = workoutRepository;
    }
    /**
     * TODO: persist a new gym and return the persisted gym
     * @param gym transient gym entity
     * @return the persisted gym entity
     */
    public Gym addGym(Gym gym){
        return gymRepository.save(gym);
    }
    /**
     * TODO: return all gyms from the gymRepository
     * @return all gym entities
     */
    public List<Gym> getAllgym(){
        return null;
    }
    /**
     * TODO: return a gym of a specific ID from the gymRepository
     * @return the persisted gym entity of a specific id
     */
    public Gym getgymById(long id){
        return null;
    }
    /**
     * TODO: delete a gym entity using its ID and return the deleted workout
     */
    public Gym deletegym(long id){
        return null;
    }
    /**
     * TODO: update a gym's address by retrieving the gym entity with id, and using the address field in updatedGym to
     * update the entity.
     */
    public Gym updateGymAddress(long id, Gym updatedGym){
        return null;
    }
}
