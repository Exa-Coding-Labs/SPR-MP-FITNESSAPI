package Lab.Controller;
import Lab.Model.Gym;
import Lab.Service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Recall that @Controller is a stereotype annotation introduced by Spring MVC (model/view/controller), which
 * allows for the creation of a Component which follows a stereotype Controller pattern. This means that the class can
 * be used to create web endpoints. The @RestController annotation exhibits all the behavior of @Controller, but it
 * also includes the behavior of @ResponseBody, which automatically converts the Objects that are returned by the
 * endpoint methods into JSON response bodies.
 *
 * TODO: write the endpoints below, and write their implementations in gymService.
 */

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
@RestController
public class GymController {
    GymService gymService;

    /**
     * Constructor injection
     * @param gymService a gymService bean that will be autowired into this class from the Spring IOC container
     */
    @Autowired
    public GymController(GymService gymService){
        this.gymService = gymService;
    }

    /**
     * TODO: create an endpoint for GET localhost:9000/gym that returns all gyms.
     * For instance, a request to GET localhost:9000/gym could respond with
     * [{
     *      "gymId":1,
     *      "address":2
     * },
     * {
     *      "gymId":1,
     *      "address":4
     * },
     * {
     *      "gymId":3,
     *      "address":20
     * }]
     */

    /**
     * TODO: create an endpoint for GET localhost:9000/gym/{id} that returns the gym with an id.
     * For instance, a request to GET localhost:9000/gym/1 could respond with
     * {
     *      "gymId":1,
     *      "address":2
     * },
     */

    /**
     * TODO: create an endpoint for DELETE localhost:9000/gym/{id} that deletes a gym and responds with the deleted gym
     * For instance, a request to DELETE localhost:9000/gym/1 should delete the gym and respond with
     * {
     *      "gymId":1,
     *      "address":2
     * }
     */

    /**
     * TODO: create an endpoint for PATCH localhost:9000/gym/{id} that updates a gym's address and responds with the full
     * updated object
     * For instance, a request to PATCH localhost:9000/gym/1 containing the request body
     * {
     *     "address":3
     * }
     * should update the gym with id 1 and respond with
     * {
     *      "gymId":1,
     *      "address":3
     * }
     */
}
