package gr2232.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.FileNotFoundException;
import java.io.IOException;
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


  
  /**
   * Tests the addUnit() method in UnitListService. Expected result is true.
   * @throws IOException
   */
  @Test
  void addUnit() throws IOException {
    Unit u1 = new Unit('M', 6);
    assertTrue(unitListService.addUnit(u1));

    //This is just to reset UnitList for other tests. 
    unitListService.removeUnit(6);
  }

  /**
   * Tests the removeUnit() method in UnitListservice. Expected result is true.
   * @throws IOException
   */
  @Test
  void removeUnit() throws IOException {
    Unit u1 = new Unit('L', 7);
    unitListService.addUnit(u1);
    assertTrue(unitListService.removeUnit(7));

    assertFalse(unitListService.removeUnit(6)); 
  }


  /**
   * Tests the removeTenant() method in UnitListservice. Expected result is true.
   * @throws IOException
   */
  @Test
  void removeTenant() throws IOException {
    Unit u1 = new Unit('L', 10, true, "Tom");
    unitListService.addUnit(u1);
    assertTrue(unitListService.removeTenant("Tom"));
    assertFalse(unitListService.removeTenant("Tom"));

    unitListService.removeUnit(10);
  }

  /**
   * Tests the addTenant() method in UnitListservice. Expected result is true.
   * @throws IOException
   */
  @Test
  void addTenant() throws IOException {
    Unit freeUnit = new Unit('S', 11);
    unitListService.addUnit(freeUnit);
    unitListService.addTenant(11, "Paul");
    assertTrue(unitListService.addTenant(11, "Paul"));
    assertFalse(unitListService.addTenant(20, "Bush"));

    unitListService.removeUnit(11);
  }

  /**
   * Tests the getUnitList() method in UnitListservice. Expected result is a UnitList.
   * @throws IOException
   */
  @Test
  void getUnitList() throws IOException {
    assertNotNull(unitListService.getUnitList()); 
  }

  /**
   * Tests the sample visit log. Expected result is a VisitLog with 3 Visits.
   * @throws IOException
   */
  @Test
  void getUnitListTestJson() throws IOException {
    assertEquals(3, UnitListService.getUnitListTestJson().getUnitListEntries().size());
  }
 
  
}
