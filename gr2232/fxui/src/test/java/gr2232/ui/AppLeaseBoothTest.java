package gr2232.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

public class AppLeaseBoothTest extends ApplicationTest {
  private Parent parent;
  private LeaseBoothController controller;
  private FXMLLoader loader;


  @Override
  public void start(final Stage stage) throws Exception {
    HandleUser.setUsesRest(false);
    final FXMLLoader loader = new FXMLLoader(getClass().getResource("leasebooth.fxml"));
    this.loader = loader;
    this.parent = loader.load();
    this.controller = loader.getController();
    stage.setScene(new Scene(parent));
    stage.show();
  }

  @BeforeEach
  public void initialize() {
    UnitList ul = new UnitList();
    ul.clearUnitList();
    Unit u = new Unit('L', 0);
    ul.addUnit(u);
  }

  @Test
  public void testRentStatus() {
    UnitList ul = new UnitList();
    clickOn("#UnitOwner").write("Test Testerson");
    WaitForAsyncUtils.waitForFxEvents();
    clickOn("#unitSize").clickOn("Large");
    WaitForAsyncUtils.waitForFxEvents();
    clickOn("#submitButton");
    WaitForAsyncUtils.waitForFxEvents();
    Unit rentedUnit = ul.getRentedUnits().get(0);
    assertEquals(true, rentedUnit.getIsRented());
  }

  @Test
  public void testName() {
    UnitList ul = new UnitList();

    clickOn("#UnitOwner").write("Test Testerson");
    WaitForAsyncUtils.waitForFxEvents();
    clickOn("#unitSize").clickOn("Large");
    WaitForAsyncUtils.waitForFxEvents();
    clickOn("#submitButton");
    WaitForAsyncUtils.waitForFxEvents();
    Unit rentedUnit = ul.getRentedUnits().get(0);
    assertEquals("Test Testerson",rentedUnit.getCustomerName());
  }

  @Test
  public void testLocation() {
    UnitList ul = new UnitList();

    clickOn("#UnitOwner").write("Test Testerson");
    WaitForAsyncUtils.waitForFxEvents();
    clickOn("#unitSize").clickOn("Large");
    WaitForAsyncUtils.waitForFxEvents();
    clickOn("#submitButton");
    WaitForAsyncUtils.waitForFxEvents();
    Unit rentedUnit = ul.getRentedUnits().get(0);
    assertEquals(0,rentedUnit.getLocation());
  }
}
