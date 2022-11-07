package gr2232.rest;

import gr2232.core.UnitList;
import gr2232.json.UnitListFileSupport;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import gr2232.core.Unit;

public class UnitListService {

	private static final String name = "restUnitList";

  private final UnitListFileSupport persistence;

  public UnitListService() {
    this.persistence = new UnitListFileSupport();
  }

  public UnitList getUnitList() throws FileNotFoundException, UnsupportedEncodingException {
    return persistence.getListFromFile(name); 
  }
}