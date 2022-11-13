package gr2232.rest;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import gr2232.core.Unit;

@ExtendWith(SpringExtension.class)
public class UnitListServiceTest {
  
  @SuppressWarnings("SpringJavaAutowiredMembersInspection")
  @Autowired
  private UnitListService unitListService; 

  /**
   * Class for a UnitListServiceBean used for testing purposes.
   */
  @TestConfiguration
  static class TestContextConfiguration {

    @Bean
    public UnitListService UnitListService() throws FileNotFoundException, UnsupportedEncodingException {
      return new UnitListService();
    }
  }

  

  
}
