package gr2232.ui;

import java.io.IOException;
import gr2232.core.HandleUser;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

/**
 * Controller for the Login page.
 * Gives the user the ability to choose between employee and manager.
 */

public class LoginController {

  @FXML
  private CheckBox restCheckbox;

  @FXML
  public void initialize() {
    HandleUser.setUsesRest(false);
  }

  @FXML
  private void switchToOverviewAsEmployee() throws IOException {
    HandleUser.setIsManager(false);
    App.setRoot("overviewpage");
  }

  @FXML
  private void switchToOverviewAsManager() throws IOException {
    HandleUser.setIsManager(true);
    App.setRoot("managerlogin");
  }

  @FXML
  private void changeRestState() throws IOException {
    HandleUser.setUsesRest(getCheckboxValue());;
    System.out.println(HandleUser.getUsesRest());
  }

  private boolean getCheckboxValue() {
    System.out.println(restCheckbox.isSelected());
    return restCheckbox.isSelected();
  }
}
