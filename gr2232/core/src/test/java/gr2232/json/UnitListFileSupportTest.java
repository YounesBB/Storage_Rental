package gr2232.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gr2232.core.UnitList;
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
    assertEquals('L', unitList.getUnitListEntries().get(0).getSize());
  }

  @Test
  public void testGetListFromFile() throws IOException {
    filesupport.writeListToFile(); 
    UnitList unitList = filesupport.getListFromFile();
    assertEquals('L', unitList.getUnitListEntries().get(0).getSize());
  }
  
}
  