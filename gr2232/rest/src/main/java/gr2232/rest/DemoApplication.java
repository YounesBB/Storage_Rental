package gr2232.rest;

import gr2232.json.UnitListModule; 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.Module;


@SpringBootApplication
public class DemoApplication {

  //start running the server by cd into rest and then mvn spring-boot:run.
  //open new terminal and past curl http://localhost:8080/unitlist. This is a GET command 

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
