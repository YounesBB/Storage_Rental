package gr2232;

import java.util.ArrayList;
import java.util.List;

public class UnitList {

  // List of all units
  private static List<Unit> unitList = new ArrayList<>();
  static Integer locationIncrementer = 0;

  public UnitList() {

  }

  /**
   * Returns a list of units that's been rented yet
   * 
   * @return rentedUnits
   */
  public List<Unit> getRentedUnits() {
    List<Unit> rentedUnits = new ArrayList<>();
    for (var entry : getUnitListEntries()) {
      if (entry.getIsRented() == true) {
        rentedUnits.add(entry);
      }
    }
    return rentedUnits;
  }

  /**
   * Retunrs a list of units that's not been rented
   * 
   * @return freeUnits
   */
  public List<Unit> getFreeUnits() {
    List<Unit> freeUnits = new ArrayList<>();
    for (var entry : getUnitListEntries()) {
      if (entry.getIsRented() == false) {
        freeUnits.add(entry);
      }
    }
    return freeUnits;
  }

  /**
   * Returns a list of units, that are of a certain size and that's not been rented.
   * 
   * @param size String of Size: Large, Medium, Small
   * @return
   */
  public List<Unit> getFreeUnitsWithCertainSize(String size) {
    try {
      char s = size.charAt(0);
      List<Unit> UnitsOfSizeS = new ArrayList<>();
      for (var entry : getFreeUnits()) {
        if (entry.getSize() == s) {
          UnitsOfSizeS.add(entry);
        }
      }
      return UnitsOfSizeS;
    } catch (Exception e) {
      e.printStackTrace();
      throw new IllegalArgumentException(e);
    }


  }


  /**
   * Returns all units in the system
   * 
   * @return unitList
   */
  public List<Unit> getUnitListEntries() {
    return UnitList.unitList;
  }

  /**
   * Returns a unit with a given location
   * 
   * @param location
   * @return
   */
  public Unit getUnitByLocation(Integer location) {
    for (var entry : getUnitListEntries()) {
      if (entry.getLocation().equals(location)) {
        return entry;
      }
    }
    return null;
  }

  /**
   * Replaces the unit given by location. Iterates over Unitlist array
   * 
   * @param location Unit location
   * @param Unit New unit to swap current unit
   */
  public void updateUnitByLocation(Integer location, Unit newUnit) {
    Integer counter = 0;
    for (var entry : getUnitListEntries()) {
      if (entry.getLocation().equals(location)) {
        getUnitListEntries().set(counter, newUnit);
      }
      counter++;
    }
  }

  /**
   * Creates a Unit, and adds it to the UnitList Location is added automatically by incrementing
   * locationnumber
   * 
   * @param size
   */
  public void createUnit(char size) {
    Unit unitToAdd = new Unit(size, UnitList.locationIncrementer);
    UnitList.locationIncrementer = UnitList.locationIncrementer + 1;
    System.out.println(locationIncrementer);
    getUnitListEntries().add(unitToAdd);
  }

  /**
   * Adds an existing unit to the unitlist
   * 
   * @param Unit to add
   */
  public void addUnit(Unit unit) {
    getUnitListEntries().add(unit);
  }

  /**
   * Clears the global list of units
   */
  public void clearUnitList() {
    getUnitListEntries().clear();
  }

  /*
   * public static void main(String args[]) { UnitList testList = new UnitList(); //Empty list, no
   * objects testList.getUnitListEntries(); testList.createUnit('L'); testList.createUnit('M'); //List
   * with two Unit objects System.out.println(testList.getUnitListEntries());
   * 
   * //Add customer, sets unit to rented
   * testList.getUnitByLocation(0).setCustomerName("Magnus Svendsen");
   * System.out.println(testList.getUnitByLocation(0).getIsRented());
   * System.out.println(testList.getUnitByLocation(0).getCustomerName());
   * 
   * //Sets unit to free testList.getUnitByLocation(0).setUnitFree();
   * System.out.println(testList.getUnitByLocation(0).getCustomerName());
   * System.out.println(testList.getFreeUnits()); System.out.println(testList.getRentedUnits());
   * 
   * testList.clearUnitList(); System.out.println(testList.getUnitListEntries());
   * 
   * 
   * }
   */
}
