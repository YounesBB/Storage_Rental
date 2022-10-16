package gr2232.ui;

import java.io.IOException;
import gr2232.core.HandleUser;
import javafx.fxml.FXML;

public class LoginController {

  @FXML
  private void switchToOverviewAsEmployee() throws IOException {
    HandleUser.setIsManager(false);
    App.setRoot("overviewpage");
  }

  @FXML
  private void switchToOverviewAsManager() throws IOException {
    HandleUser.setIsManager(true);
    App.setRoot("overviewpage");
  }
}
