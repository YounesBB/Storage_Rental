package gr2232.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import gr2232.core.HandleUser;
import gr2232.core.Unit;
import gr2232.core.UnitList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppDeleteUnitControllerTest extends ApplicationTest {
  private Parent parent;
  private DeleteUnitController controller;
  private FXMLLoader loader;


  @Override
  public void start(final Stage stage) throws Exception {
    HandleUser.setUsesRest(false);
    UnitList ul = new UnitList();
    ul.clearUnitList();
    Unit u = new Unit('L', 0);
    ul.addUnit(u);
    final FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteUnit.fxml"));
    this.loader = loader;
    this.parent = loader.load();
    this.controller = loader.getController();
    stage.setScene(new Scene(parent));
    stage.show();
  }


  @Test
  public void testDeleteUnit() {
    UnitList ul = new UnitList();
    clickOn("#unitSelector");
    WaitForAsyncUtils.waitForFxEvents();
    clickOn("null,0,L");
    WaitForAsyncUtils.waitForFxEvents();
    clickOn("#deleteUnitButton");
    WaitForAsyncUtils.waitForFxEvents();
    assertEquals(0, ul.getUnitListEntries().size());
  }
}
