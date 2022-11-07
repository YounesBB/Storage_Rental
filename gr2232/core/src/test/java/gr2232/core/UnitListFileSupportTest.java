package gr2232.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.google.gson.JsonObject;
import gr2232.json.UnitListFileSupport;



public class UnitListFileSupportTest {

  private UnitListFileSupport filesupport;

  @BeforeEach
  public void setUp() {
    UnitList units = new UnitList();
    units.createUnit('L');
    
  }

  @Test
  public void testWriteListToFile() throws IOException {
    filesupport.writeListToFile("Large"); 


  }

  @Test
  public void testGetListFromFile() {

  }
  
}