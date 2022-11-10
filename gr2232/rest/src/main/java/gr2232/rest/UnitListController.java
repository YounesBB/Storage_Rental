package gr2232.rest;

import gr2232.core.UnitList; 
import gr2232.core.Unit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
   * Adds a unit to the servers Unitlist.
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

	
}