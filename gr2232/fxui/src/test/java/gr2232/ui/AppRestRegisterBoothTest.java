package gr2232.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ResourceBundle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;
import gr2232.core.UnitList;
import gr2232.core.HandleUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppRestRegisterBoothTest extends ApplicationTest {

  private Parent parent;
  private RegisterBoothController controller;
  private FXMLLoader loader;

  @Override
  public void start(final Stage stage) throws Exception {
    UnitList ul = new UnitList();
    ul.clearUnitList();
    final FXMLLoader loader = new FXMLLoader(getClass().getResource("registerbooth.fxml"));
    HandleUser.setUsesRest(true);
    this.loader = loader;
    this.parent = loader.load();
    this.controller = loader.getController();
    stage.setScene(new Scene(parent));
    stage.show();
  }

  @Test
  public void testInputSize() throws InterruptedException {
    UnitList ul = new UnitList();
    assertTrue(HandleUser.getUsesRest());
    clickOn("#inputSmallBooth").write("4");
    clickOn("#inputMediumBooth").write("0");
    clickOn("#inputLargeBooth").write("0");
    clickOn("#getNewBoothButton");
    WaitForAsyncUtils.waitForFxEvents();
    assertEquals(4, ul.getUnitListEntries().size());
  }
}
