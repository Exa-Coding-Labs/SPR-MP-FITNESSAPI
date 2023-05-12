package Lab;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The @SpringBootApplication annotation enables automatic configuration of a Spring App.
 */
@SpringBootApplication
public class Application {
	/**
	 * Logger setup
	 */
	public static Logger log = LogManager.getLogger();

	/**
	 * Automatically configure & run the Spring ArtApplication Context, start Controllers.
	 * You can manually test this API using an API testing tool (thunder client, postman, curl.)
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}