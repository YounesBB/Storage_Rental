package gr2232.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;
import gr2232.core.Unit;
import gr2232.core.UnitList;
import org.testfx.api.FxAssert;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppRemoveTenantTest extends ApplicationTest {
  private Parent parent;
  private RemoveTenantController controller;
  private FXMLLoader loader;

  private String name;

  @Override
  public void start(final Stage stage) throws Exception {
    UnitList ul = new UnitList();
    ul.clearUnitList();
    Unit u = new Unit('M', 0);
    u.setCustomerName("Testimus Maximus");
    ul.addUnit(u);
    name = u.getCustomerName() + "," + u.getLocation() + "," + u.getSize();

    final FXMLLoader loader = new FXMLLoader(getClass().getResource("removetenant.fxml"));
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
    Unit u = new Unit('M', 0);
    u.setCustomerName("Testimus Maximus");
    ul.addUnit(u);
    name = u.getCustomerName() + "," + u.getLocation() + "," + u.getSize();
  }

  @Test
  public void testRemoveTenant() {
    UnitList ul = new UnitList();
    Integer rentedUnitsBeforeRemoved = ul.getRentedUnits().size();
    assertEquals(rentedUnitsBeforeRemoved, 1);
    clickOn("#tenantSelector").clickOn(this.name);
    WaitForAsyncUtils.waitForFxEvents();
    clickOn("#removeTenantButton");
    WaitForAsyncUtils.waitForFxEvents();
    Integer rentedUnitsAfterRemoved = ul.getRentedUnits().size();
    assertNotEquals(rentedUnitsAfterRemoved, rentedUnitsBeforeRemoved);
    assertEquals(rentedUnitsAfterRemoved, 0);

  }
}
