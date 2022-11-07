package gr2232.rest;

import gr2232.core.UnitList; 
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping; 

@RestController
@RequestMapping(UnitListController.CONTROLLER_PATH)
public class UnitListController {

  public static final String CONTROLLER_PATH = "/unitlist";

  private final UnitListService unitListService;

  @Autowired
  public UnitListController() {
    this.unitListService = new UnitListService();
  }

   /**
   * Gets the servers' VisitLog.
   *
   * @return the visit log
   * @throws UnsupportedEncodingException
   * @throws FileNotFoundException
   */
  @GetMapping
  protected UnitList getVisitLog() throws FileNotFoundException, UnsupportedEncodingException {
    return unitListService.getUnitList();
  }

	
}