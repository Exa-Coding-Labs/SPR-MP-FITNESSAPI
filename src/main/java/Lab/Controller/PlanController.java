package Lab.Controller;
import Lab.Model.Plan;
import Lab.Service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Recall that @Controller is a stereotype annotation introduced by Spring MVC (model/view/controller), which
 * allows for the creation of a Component which follows a stereotype Controller pattern. This means that the class can
 * be used to create web endpoints. The @RestController annotation exhibits all the behavior of @Controller, but it
 * also includes the behavior of @ResponseBody, which automatically converts the Objects that are returned by the
 * endpoint methods into JSON response bodies.
 *
 * TODO: write the endpoints below, and write their implementations in PlanService.
 */

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
@RestController
public class PlanController {
    PlanService planService;

    /**
     * Constructor injection
     * @param planService a PlanService bean that will be autowired into this class from the Spring IOC container
     */
    @Autowired
    public PlanController(PlanService planService){
        this.planService = planService;
    }
    /**
     * Endpoint for POST localhost:/9000/workout/{workoutId}/plan that adds a new plan for a workout with a specific id
     * and responds with the added plan. This endpoint is already provided to allow you to test your API.
     * For instance, a request to POST localhost:9000/workout/1/plan that contains the request body
     * {
     *      "numberOfReps":2
     * }
     * should add the new plan to the workout with id 1 and respond with
     * {
     *      "planId":1,
     *      "numberOfReps":2
     * }
     */
    @PostMapping("workout/{workoutId}/plan")
    public Plan postPlan(@PathVariable long workoutId, @RequestBody Plan plan){
        return planService.addPlan(workoutId, plan);
    }

    /**
     * TODO: create an endpoint for GET localhost:9000/plan that returns all plans.
     * For instance, a request to GET localhost:9000/plan could respond with
     * [{
     *      "planId":1,
     *      "numberOfReps":2
     * },
     * {
     *      "planId":1,
     *      "numberOfReps":4
     * },
     * {
     *      "planId":3,
     *      "numberOfReps":20
     * }]
     */

    /**
     * TODO: create an endpoint for GET localhost:9000/plan/{id} that returns the plan with an id.
     * For instance, a request to GET localhost:9000/plan/1 could respond with
     * {
     *      "planId":1,
     *      "numberOfReps":2
     * },
     */

    /**
     * TODO: create an endpoint for GET localhost:9000/plan/{id}/workout that responds with a plan's associated workout
     * For instance, a request to POST localhost:9000/plan/1/workout could respond with
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

    /**
     * TODO: create an endpoint for DELETE localhost:9000/plan/{id} that deletes a plan and responds with the deleted plan
     * For instance, a request to DELETE localhost:9000/plan/1 should delete the plan and respond with
     * {
     *      "planId":1,
     *      "numberOfReps":2
     * }
     */

    /**
     * TODO: create an endpoint for PATCH localhost:9000/plan/{id} that updates a plan's reps and responds with the full
     * updated object
     * For instance, a request to PATCH localhost:9000/plan/1 containing the request body
     * {
     *     "numberOfReps":3
     * }
     * should update the plan with id 1 and respond with
     * {
     *      "planId":1,
     *      "numberOfReps":3
     * }
     */
}
