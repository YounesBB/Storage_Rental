package gr2232.rest;

import gr2232.json.UnitListModule;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.Module;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "UnitList API", version = "3.0", description = "An application used to manage units in a Unit storage house."))
public class DemoApplication {

  //start running the server by cd into rest and then mvn spring-boot:run.
  //open new terminal and past curl http://localhost:8080/unitlist. This is a GET command 
  //past http://localhost:8080/swagger-ui.html in browser to see the documentation of our api. 

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	} 

  /**
   * Assign our jackson module to springboot.
   *
   * @return instane of VisitLogModule
   */
  @Bean
  protected Module objectMapperModule() {
    return new UnitListModule();
  }

}
