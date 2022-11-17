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
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppAdminPanelTest extends ApplicationTest {
  private Parent parent;
  private AdminPanelController controller;
  private FXMLLoader loader;


  @Override
  public void start(final Stage stage) throws Exception {
    final FXMLLoader loader = new FXMLLoader(getClass().getResource("adminpanel.fxml"));
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
    Unit u1 = new Unit('S', 0);
    Unit u2 = new Unit('M', 1);
    Unit u3 = new Unit('L', 2);
    ul.addUnit(u1);
    ul.addUnit(u2);
    ul.addUnit(u3);
  }

  @Test
  public void testClearSystem() {
    UnitList ul = new UnitList();
    clickOn("#clearButton");
    WaitForAsyncUtils.waitForFxEvents();
    Integer listSize = ul.getUnitListEntries().size();
    assertEquals(listSize, 0);
  }

  // Should add some tests for saving/loading

  @Test
  public void TestLoading() {
    UnitList ul = new UnitList();
    ul.clearUnitList();
    clickOn("#fileUrl").write("test_file");
    clickOn("#loadButton");
    assertEquals(10, ul.getUnitListEntries().size());
  }

  @Test
  public void TestLoadingFileNotExisiting() {
    clickOn("#fileUrl").write("NEVERCRYSHITWOLF");
    clickOn("#loadButton");
    TextArea response = (TextArea) parent.lookup("#responseText");
    assertEquals(response.getText(), "Error loading file");
    response.clear();
  }


  @Test
  public void TestSaving() {
    UnitList ul = new UnitList();
    ul.clearUnitList();
    ul.createUnit('L');
    ul.createUnit('M');
    clickOn("#fileUrl").write("test_save");
    clickOn("#saveButton");
    TextArea response = (TextArea) parent.lookup("#responseText");
    assertEquals(response.getText(), "Saved!");
    clickOn("#clearButton");
    clickOn("#loadButton");
    assertEquals(2,ul.getUnitListEntries().size());
    assertNotEquals(0,ul.getUnitListEntries().size());
  }
}
