package gr2232.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ResourceBundle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import gr2232.core.HandleUser;
import gr2232.core.UnitList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppRegisterBoothTest extends ApplicationTest {

  private Parent parent;
  private RegisterBoothController controller;
  private FXMLLoader loader;

  @Override
  public void start(final Stage stage) throws Exception {
    UnitList ul = new UnitList();
    HandleUser.setUsesRest(false);
    ul.clearUnitList();
    final FXMLLoader loader = new FXMLLoader(getClass().getResource("registerbooth.fxml"));
    this.loader = loader;
    this.parent = loader.load();
    this.controller = loader.getController();
    stage.setScene(new Scene(parent));
    stage.show();
  }

  // Might want to change so that empty input == 0 in controller?
  @Test
  public void testInputSize() throws InterruptedException {
    UnitList ul = new UnitList();
    clickOn("#inputSmallBooth").write("1");
    clickOn("#inputMediumBooth").write("1");
    clickOn("#inputLargeBooth").write("1");
    clickOn("#getNewBoothButton");
    assertEquals(3, ul.getUnitListEntries().size());
  }

  @Test
  public void testNegativeInput() {
    clickOn("#inputSmallBooth").write("-4");
    clickOn("#inputMediumBooth").write("0");
    clickOn("#inputLargeBooth").write("0");

    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
      throw new IllegalArgumentException("The input can not be negative!");
    });
    assertEquals("The input can not be negative!", exception.getMessage());
  }

  @Test
  public void testNonNumberInput() {
    clickOn("#inputSmallBooth").write("æøå");
    clickOn("#inputMediumBooth").write("0");
    clickOn("#inputLargeBooth").write("0");

    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
      throw new IllegalArgumentException("The number can not be a decimal or empty!");
    });
    assertEquals("The number can not be a decimal or empty!", exception.getMessage());
  }
}
