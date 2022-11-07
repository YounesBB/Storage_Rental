package gr2232.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

  //start running the server by cd into rest and then mvn spring-boot:run
  //open new terminal and past curl f.example http://localhost:8080/greeting\?name=John 

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
