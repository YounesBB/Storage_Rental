package gr2232.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gr2232.core.Unit;
import gr2232.core.UnitList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnitListModuleTest {

  private static Unit Input1;

  private static Unit Input2;

  private static ObjectMapper mapper;

  private UnitList unitList;

  /**
   * Makes Unit objects and a mapper with the UnitListModule
   */
  @BeforeAll
  static void initialize() {
    Input1 = new Unit('L', 1, true, "Elon");
    Input2 = new Unit('M', 2, true, "Steve");
    mapper = new ObjectMapper();
    mapper.registerModule(new UnitListModule());
  }

  @BeforeEach
  void setUp() {
    unitList = new UnitList();
    unitList.addUnit(Input1);
    unitList.addUnit(Input2);
  }

  @Test
  public String testSerializers() {
    String json = null;
    try {
      json = mapper.writeValueAsString(unitList.getUnitListEntries());
      assertTrue(json.contains("isRented"));
      assertTrue(json.contains("customerName"));
      assertTrue(json.contains("location"));
      assertTrue(json.contains("size"));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return json;
  }

  @Test
  public void testDeserializers() {
    String json = testSerializers();
    try {
      UnitList deserializeUnitList = mapper.readValue(json, UnitList.class);
      //assertEquals(2, deserializeUnitList.getUnitListEntries().size());
      assertTrue((deserializeUnitList.getUnitByLocation(1)) == Input1 );
      assertTrue((deserializeUnitList.getUnitByLocation(2)) == Input2 );
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  
}
