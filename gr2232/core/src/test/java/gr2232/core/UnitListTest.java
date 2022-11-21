package gr2232.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnitListTest {

  private UnitList newUnitList;

  @BeforeEach
  public void setUp() {
    newUnitList = new UnitList();
  }

  @AfterEach
  public void setUp1() {
    newUnitList.clearUnitList();
    newUnitList.setLocationIncrementer(0);
  }

  @Test
  public void testRemoveUnitByLocation(){
    newUnitList.createUnit('S');
    newUnitList.createUnit('M');
    assertTrue(newUnitList.removeUnitByLocation(1));
    assertFalse(newUnitList.removeUnitByLocation(1));
    assertFalse(newUnitList.removeUnitByLocation(1));
  }

  @Test
  public void testCreateTempUnit(){
    newUnitList.createTempUnit('L');
    newUnitList.getTempUnits().get(0);
    assertEquals('L', newUnitList.getTempUnits().get(0).getSize());
  }

  @Test
  public void testUnitList(){
    
  }

  @Test
  public void testToString() {
    newUnitList.setLocationIncrementer(0);
    newUnitList.createUnit('L');
    System.out.println(UnitList.getIncrementLocation());
    assertEquals("UnitList [unitlist=[Unit [isRented=false, customerName=null, location=0, size=L]]]", newUnitList.toString());
  }

  @Test
  public void testResetTempUnitList(){
    newUnitList.createTempUnit('L');
    newUnitList.resetTempUnitList();
    assertEquals(0, newUnitList.getTempUnits().size());
  }

  @Test
  public void testInitializeTempUnitList() {
    newUnitList.setLocationIncrementer(0);
    newUnitList.incrementLocation();
    newUnitList.initializeTempUnitList();
    assertEquals(1, newUnitList.getTempLocationIncrementer());
  }

  @Test
  public void testGetTempUnits(){
    newUnitList.createTempUnit('L');
    assertEquals(1, newUnitList.getTempUnits().size());
  }

  @Test
  public void testGetIncrementLocation(){
    newUnitList.setLocationIncrementer(0);
    assertEquals(0,newUnitList.getIncrementLocation());
  }


  @Test
  public void testCreateUnit() {
    newUnitList.createUnit('S');
    assertEquals(1, newUnitList.getUnitListEntries().size());
    assertThrows(IllegalArgumentException.class, () -> newUnitList.createUnit('E'));

  }

  @Test
  public void testAddUnit() {
    Unit unit = new Unit('S', 1);
    newUnitList.addUnit(unit);
    assertEquals(newUnitList.getUnitListEntries().size(), 1);
  }

  @Test
  public void testClearUnitList() {
    newUnitList.addUnit(new Unit('M', 1));
    newUnitList.addUnit(new Unit('S', 2));
    newUnitList.clearUnitList();
    assertFalse(newUnitList.getUnitListEntries().iterator().hasNext());
  }

  @Test
  public void testGetUnitByLocation() {
    Unit a1 = new Unit('M', 1);
    Unit a2 = new Unit('S', 3);

    newUnitList.addUnit(a1);
    newUnitList.addUnit(a2);
    assertEquals(a2, newUnitList.getUnitByLocation(3));
    assertEquals(null, newUnitList.getUnitByLocation(10));
    assertEquals(null, newUnitList.getUnitByLocation(-1));

  }

  @Test
  public void testGetFreeUnits() {
    assertTrue(newUnitList.getFreeUnits().isEmpty());

    Unit a1 = new Unit('M', 1);
    Unit a2 = new Unit('S', 3);

    // unit a1 should now not be free
    a1.setCustomerName("Tom");

    newUnitList.addUnit(a1);
    newUnitList.addUnit(a2);
    assertFalse(newUnitList.getFreeUnits().contains(a1));

    // Testing to see that the units that belong to the same customer don't show up
    // as free units.
    Unit a3 = new Unit('S', 4);
    a3.setCustomerName("Tom");
    newUnitList.addUnit(a3);

    assertTrue(newUnitList.getFreeUnits().size() == 1);

    // We test to see that the unit is free after removing tenant
    a1.setUnitFree();
    assertTrue(newUnitList.getFreeUnits().contains(a1), "the unit still shows up as rented!");
  }

  @Test
  public void testGetRentedUnits() {
    newUnitList.clearUnitList();
    assertTrue(newUnitList.getFreeUnits().isEmpty());


    Unit a1 = new Unit('M', 1);
    Unit a2 = new Unit('S', 3);

    // unit a1 should now be rented
    a1.setCustomerName("Tom");

    newUnitList.addUnit(a1);
    newUnitList.addUnit(a2);
    assertTrue(newUnitList.getRentedUnits().contains(a1));

    // Testing to see that the units that belong to the same customer don't show up
    // as free units.
    Unit a3 = new Unit('S', 4);
    a3.setCustomerName("Jerry");
    newUnitList.addUnit(a3);

    System.out.println("Rented units:");
    System.out.println(newUnitList.getRentedUnits());
    System.out.println(newUnitList.getRentedUnits().size());

    assertTrue(newUnitList.getFreeUnits().size() == 1);
    assertTrue(newUnitList.getRentedUnits().size() == 2);

    // We test to see that the unit is free after removing tenant
    a1.setUnitFree();
    assertFalse(newUnitList.getRentedUnits().contains(a1), "the unit still shows up as rented!");
  }

  @Test
  public void testGetFreeUnitsWithCertainSize() {
    Unit a1 = new Unit('S', 1);
    Unit a2 = new Unit('S', 2);
    Unit a3 = new Unit('M', 3);
    Unit a4 = new Unit('M', 4);
    Unit a5 = new Unit('L', 5);
    Unit a6 = new Unit('L', 6);

    newUnitList.addUnit(a1);
    newUnitList.addUnit(a2);
    newUnitList.addUnit(a3);
    newUnitList.addUnit(a4);
    newUnitList.addUnit(a5);
    newUnitList.addUnit(a6);

    assertTrue(newUnitList.getFreeUnitsWithCertainSize("S").size() == 2);
    assertTrue(newUnitList.getFreeUnitsWithCertainSize("Medium").size() == 2);
    assertTrue(newUnitList.getFreeUnitsWithCertainSize("L").size() == 2);

    // Just to check that the content is actually correct
    assertTrue(newUnitList.getFreeUnitsWithCertainSize("S").contains(a2));
    assertTrue(newUnitList.getFreeUnitsWithCertainSize("H").isEmpty());

    assertThrows(IllegalArgumentException.class, () -> newUnitList.getFreeUnitsWithCertainSize(null));

  }

  @Test
  public void testUpdateUnitByLocation() {
    Unit a1 = new Unit('S', 0);
    Unit a2 = new Unit('M', 1);
    Unit a3 = new Unit('L', 2);

    newUnitList.addUnit(a1);
    newUnitList.addUnit(a2);
    newUnitList.addUnit(a3);

    Unit testUnit = new Unit('S', 2);

    newUnitList.updateUnitByLocation(2, testUnit);

    List<Unit> list = newUnitList.getUnitListEntries();

    assertTrue(list.get(2).equals(testUnit));

    // We test to see that nothing should happen if we try to swap a unit with
    // location that does not already exist.
    Unit testUnit2 = new Unit('S', 58);

    newUnitList.updateUnitByLocation(3, testUnit2);

    List<Unit> list2 = newUnitList.getUnitListEntries();
    assertFalse(list2.contains(testUnit2));

  }
}