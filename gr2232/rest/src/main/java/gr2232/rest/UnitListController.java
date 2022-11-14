package gr2232.rest;

import gr2232.core.UnitList; 
import gr2232.core.Unit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.web.bind.annotation.RequestMapping; 

@RestController
@RequestMapping(UnitListController.CONTROLLER_PATH)
public class UnitListController {

  public static final String CONTROLLER_PATH = "/unitlist";

  private final UnitListService unitListService;

  @Autowired
  public UnitListController() throws FileNotFoundException, UnsupportedEncodingException {
    this.unitListService = new UnitListService();
  }

   /**
   * Gets the servers' Unitlist.
   *
   * @return the visit log
   * @throws UnsupportedEncodingException
   * @throws FileNotFoundException
   */
  @GetMapping
  protected List<Unit> getUnitList() throws FileNotFoundException, UnsupportedEncodingException {
    UnitList ul = unitListService.getUnitList();
    return ul.getUnitListEntries();
  }

   /**
   * Gets the Units from unitListTest.model.json 
   * Used for testing proposes 
   *
   * @return the unitlist
   * @throws IOException
   */
  @GetMapping(path = "/test")
  protected List<Unit> getTestUnitList() throws IOException {
    UnitList ul = UnitListService.getUnitListTestJson();
    return ul.getUnitListEntries();
  }
   /** 
   /**
   * Adds a unit to the servers Unitlist.
   *
   * @param unit unit to add
   * @return true after adding unit
   * @throws IOException
   */
  /** 
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  protected boolean addUnit(@RequestBody String u) throws IOException {
    try {
      ObjectMapper mapper = new ObjectMapper();
      //Unit u = mapper.readValue(unitstream, Unit.class);
      //System.out.println("Unit:");
      //unitListService.addUnit(u); 
      System.out.println(unitListService.getUnitList().getUnitListEntries());
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println(e);
    }
    //unitListService.addUnit(unit); 
    return true;
  }
	*/

  /**
   * Adds a unit to the servers Unitlist
   *
   * @param unit unit to add
   * @return true after adding unit
   * @throws IOException
   */
  @PostMapping
  protected boolean addUnit(@RequestBody Unit unit) throws IOException {
    unitListService.addUnit(unit);
    return true;
  }
  

   /**
   * Removes a unit to the servers Unitlist
   *
   * @param unit unit to remove
   * @return true after removing unit
   * @throws IOException
   */
  @DeleteMapping(path = "/{location}")
  protected boolean removeUnit(@PathVariable("location") Integer location) throws IOException {
    return unitListService.removeUnit(location); 
  }

  /**
   * Removes a tenant from the servers Unitlist by location
   *
   * @param  location of the unit to remove tenant from
   * @return true after removing tenant
   * @throws IOException
   */
  @PutMapping(path = "removetenant/{location}")
  protected boolean removeTenant(@PathVariable("location") Integer location) throws IOException {
    return unitListService.removeTenant(location); 
  }

  /**
   * Adds a tenant to the servers Unitlist
   *
   * @param  location to rent out
   * @param  tenant to rent the unit at location  
   * @return true after adding tenant
   * @throws IOException
   */
  @PutMapping(path = "addtenant/{location}/{tenant}")
  protected boolean addTenant(@PathVariable("tenant") String tenant, @PathVariable("location") Integer location) throws IOException {
    return unitListService.addTenant(location, tenant); 
  }
}