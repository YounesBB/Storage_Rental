package gr2232.rest;

import gr2232.core.UnitList;
import gr2232.core.Unit;
import gr2232.json.UnitListFileSupport;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class UnitListService {

	private static final String name = "restUnitList";

  private final UnitListFileSupport persistence;
  private final UnitList unitlist;

  public UnitListService() throws FileNotFoundException, UnsupportedEncodingException {
    this.persistence = new UnitListFileSupport();
    this.unitlist = persistence.getListFromFile(name); 

  }

  public UnitList getUnitList() throws FileNotFoundException, UnsupportedEncodingException {
    return persistence.getListFromFile(name); 
  }

  public boolean addUnit(Unit unit) throws IOException {
    unitlist.addUnit(unit); //se om denne unit blir lagt til UnitListFileSupport sin UnitList 
    persistence.writeListToFile(name); 
    return true; 
  }

  public boolean removeUnit(Integer location) throws IOException {
    Boolean answer = unitlist.removeUnitByLocation(location);
    if (answer) {
      persistence.writeListToFile(name);
      return true; 
    }
    return false; 
  }

  public boolean removeTenant(String tenant) throws IOException {
    for (var entry : unitlist.getRentedUnits()) {
      if (entry.getCustomerName().equals(tenant)) {
        entry.setUnitFree();
        persistence.writeListToFile(name);
        return true;
      }
    }
    return false; 
  }

  public boolean addTenant(Integer location, String tenant) throws IOException {
    Unit entry = unitlist.getUnitByLocation(location); 
    if (entry == null) {
      return false;
    }
    entry.setCustomerName(tenant);
    persistence.writeListToFile(name); 
    return true;
  }


  public static void main(String[] args) throws IOException {
    UnitListService u1 = new UnitListService();
    Unit unit1 = new Unit('M',3); 

    u1.addUnit(unit1); 
  }
}