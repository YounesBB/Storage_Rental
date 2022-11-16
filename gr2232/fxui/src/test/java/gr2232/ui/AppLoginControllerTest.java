package gr2232.ui;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.testfx.api.FxAssert.verifyThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import gr2232.core.HandleUser;
import gr2232.core.Unit;
import gr2232.core.UnitList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class AppLoginControllerTest extends ApplicationTest {
  private Parent parent;
  private LoginController controller;
  private FXMLLoader loader;


  @Override
  public void start(final Stage stage) throws Exception {
    final FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
    this.loader = loader;
    this.parent = loader.load();
    this.controller = loader.getController();
    stage.setScene(new Scene(parent));
    stage.show();
  }

  @Test
  public void TestCheckUsesRest(){
    WaitForAsyncUtils.waitForFxEvents();
    assertEquals(false, HandleUser.getUsesRest());
    clickOn("#restCheckbox");
    assertEquals(true, HandleUser.getUsesRest());
  }
}