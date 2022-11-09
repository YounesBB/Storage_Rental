package gr2232.rest;

import gr2232.core.UnitList; 
import gr2232.core.Unit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

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
   * Adds a unit to the servers Unitlist.
   *
   * @param unit unit to add
   * @return true after adding unit
   * @throws IOException
   */
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
	
}