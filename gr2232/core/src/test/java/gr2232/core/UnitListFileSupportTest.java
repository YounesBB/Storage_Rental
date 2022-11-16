package gr2232.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.google.gson.JsonObject;
import gr2232.json.UnitListFileSupport;



public class UnitListFileSupportTest {

  private UnitListFileSupport filesupport = new UnitListFileSupport("UnitListFileSupportTest");

  @BeforeEach
  public void setUp() {
    UnitList units = new UnitList();
    units.clearUnitList();
    units.createUnit('L');
  }
  
  @AfterEach
  public void after() throws IOException{
    UnitList units = new UnitList();
    units.clearUnitList();
    filesupport.writeListToFile();
  }

  @Test
  public void testWriteListToFile() throws IOException {
    filesupport.writeListToFile(); 
    UnitList unitList = filesupport.getListFromFile();
    assertEquals(unitList.getUnitListEntries().get(0).getSize(), 'L');
  }

  @Test
  public void testGetListFromFile() throws IOException {
    filesupport.writeListToFile(); 
    UnitList unitList = filesupport.getListFromFile();
    assertEquals(unitList.getUnitListEntries().get(0).getSize(), 'L');
    UnitList units = new UnitList();
    units.clearUnitList();
    filesupport.writeListToFile();
    assertThrows(IllegalStateException.class, () -> filesupport.getListFromFile());
  }
  
}
  