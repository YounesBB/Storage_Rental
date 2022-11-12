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
    App.setRoot("overviewpage");
  }

  @FXML
  private void switchToOverviewAsManager() throws IOException {
    HandleUser.setIsManager(true);
    App.setRoot("managerlogin");
  }

  @FXML
  private void changeRestState() throws IOException {
    HandleUser.setIsManager(getCheckboxValue());;
    System.out.println(HandleUser.getUsesRest());
  }

  private boolean getCheckboxValue() {
    System.out.println(restCheckbox.isSelected());
    return restCheckbox.isSelected();
  }
}
