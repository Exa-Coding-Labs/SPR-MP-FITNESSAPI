package Lab.Controller;

import Lab.Model.Gym;
import Lab.Model.Workout;
import Lab.Service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Recall that @Controller is a stereotype annotation introduced by Spring MVC (model/view/controller), which
 * allows for the creation of a Component which follows a stereotype Controller pattern. This means that the class can
 * be used to create web endpoints. The @RestController annotation exhibits all the behavior of @Controller, but it
 * also includes the behavior of @ResponseBody, which automatically converts the Objects that are returned by the
 * endpoint methods into JSON response bodies.
 *
 * For the purpose of completing any challenges within this project: do not change anything within this class!
 * It is already complete.
 */

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
@RestController
public class WorkoutController {
    WorkoutService workoutService;
    /**
     * Constructor injection
     * @param workoutService a PlanService bean that will be autowired into this class from the Spring IOC container
     */
    @Autowired
    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }
    /**
     * Endpoint on GET localhost:8080/workout should respond with a JSON containing all workouts.
     * For instance, GET localhost:8080/workout could respond with
     * [{
     *     "workoutId":1,
     *     "title":"run a mile"
     *     "plans":[{
     *                  "planId":1,
     *                  "numberOfReps":2
     *              },
     *              {
     *                  "planId":2,
     *                  "numberOfReps":4
     *              }]
     * }, {
     *     "workoutId":2,
     *     "title":"pushups"
     *     "plans":[{
     *                  "planId":3,
     *                  "numberOfReps":20
     *              }]
     * }]
     * @return all workout entities
     */
    @GetMapping("workout")
    public List<Workout> getAllWorkout() throws Exception {
        return workoutService.getAllWorkout();
    }
    /**
     * Endpoint on POST localhost:8080/workout should add a new workout and respond with a JSON of the added workout
     * For instance, POST localhost:8080/workout containing
     * {
     *     "title":"run a mile"
     * }
     * should insert the workout and respond with
     * {
     *     "workoutId":1,
     *     "title":"run a mile"
     *     "plans":[]
     * }
     */
    @PostMapping("workout")
    public Workout postWorkout(@RequestBody Workout workout){
        return workoutService.addWorkout(workout);
    }
    /**
     * Endpoint on GET localhost:8080/workout/{id} should respond with a JSON containing all workouts.
     * For instance, GET localhost:8080/workout/1 could respond with
     * {
     *     "workoutId":1,
     *     "title":"run a mile"
     *     "plans":[{
     *                  "planId":1,
     *                  "numberOfReps":1
     *              },
     *              {
     *                  "planId":2,
     *                  "numberOfReps":4
     *              }]
     * }
     */
    @GetMapping("workout/{id}")
    public Workout getWorkoutById(@PathVariable long id){
        return workoutService.getWorkoutById(id);
    }
    /**
     * Endpoint on GET localhost:8080/workout/{id}/plan should respond with a JSON of the plans of a workout.
     * For instance, GET localhost:8080/workout/1/plan should respond with
     * [{
     *      "planId":1,
     *      "numberOfReps":1
     *  },
     *  {
     *      "planId":1,
     *      "numberOfReps":4
     *  }]
     */
    @GetMapping("workout/{id}/plan")
    public List<Gym> getWorkoutPlans(@PathVariable long id){
        return workoutService.getWorkoutPlans(id);
    }
    /**
     * Endpoint on DELETE localhost:8080/workout/{id} should delete the workout and respond with the deleted workout.
     * For instance, DELETE localhost:8080/workout/1 should delete the workout and respond with
     * {
     *     "workoutId":1,
     *     "title":"run a mile"
     *     "plans":[{
     *                  "planId":1,
     *                  "numberOfReps":1
     *              },
     *              {
     *                  "planId":1,
     *                  "numberOfReps":4
     *              }]
     * }
     */
    @DeleteMapping("workout/{id}")
    public Workout deleteWorkout(@PathVariable long id){
        return workoutService.deleteWorkout(id);
    }
    /**
     * Endpoint on PATCH localhost:8080/workout/{id} should update the workout title and respond with the updated workout.
     * For instance, PATCH localhost:8080/workout/1 with the request body
     * {
     *      "title":"jog a mile"
     * }
     * should update the workout and respond with
     * {
     *     "workoutId":1,
     *     "title":"jog a mile"
     *     "plans":[{
     *                  "planId":1,
     *                  "numberOfReps":1
     *              },
     *              {
     *                  "planId":1,
     *                  "numberOfReps":4
     *              }]
     * }
     */
    @PatchMapping("workout/{id}")
    public Workout deleteWorkout(@PathVariable long id, @RequestBody Workout workout){
        return workoutService.updateWorkoutTitle(id, workout);
    }

}
