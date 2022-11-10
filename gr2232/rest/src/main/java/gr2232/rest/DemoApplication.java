package gr2232.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

  //start running the server by cd into rest and then mvn spring-boot:run.
  //open new terminal and past curl http://localhost:8080/unitlist. This is a GET command 

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	} 

}
