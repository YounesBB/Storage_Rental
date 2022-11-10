package gr2232.ui;

import java.io.IOException;
import gr2232.core.HandleUser;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class LoginController {

  @FXML
  private CheckBox restCheckbox;

  @FXML
  private void switchToOverviewAsEmployee() throws IOException {
    HandleUser.setIsManager(false);
    HandleUser.setUsesRest(getCheckboxValue());
    App.setRoot("overviewpage");
  }

  @FXML
  private void switchToOverviewAsManager() throws IOException {
    HandleUser.setUsesRest(getCheckboxValue());
    App.setRoot("managerlogin");
  }

  private boolean getCheckboxValue() {
    return restCheckbox.isSelected();
  }
}
