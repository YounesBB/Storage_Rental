package gr2232.ui;

import java.io.IOException;

import javax.net.ssl.HandshakeCompletedEvent;

import gr2232.core.HandleUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class OverviewPageController {

  @FXML
  private Button addUnitsButton;

  @FXML
  private Button leaseOutButton;

  @FXML
  private Button removeTenantButton;

  @FXML
  private Button unitsOverviewButton;

  @FXML
  void initialize() {
    boolean manager = HandleUser.getIsManager();
    boolean rest = HandleUser.getUsesRest();
    if (manager) {
      this.addUnitsButton.setDisable(false);
    } else {
      this.addUnitsButton.setDisable(true);
    }
    System.out.println(rest);
  }

  @FXML
  void goToAddUnitsPage(ActionEvent event) throws IOException {
    App.setRoot("registerbooth");
  }

  @FXML
  void goToLeaseOutPage(ActionEvent event) throws IOException {
    App.setRoot("leasebooth");
  }

  @FXML
  void goToRemoveTenantPage(ActionEvent event) throws IOException {
    App.setRoot("removetenant");
  }

  @FXML
  void goToUnitsOverviewPage(ActionEvent event) throws IOException {
    App.setRoot("allTenants");
  }

  @FXML
  void goToLogIn(ActionEvent event) throws IOException {
    App.setRoot("login");
  }

  @FXML
  void goToSettings(ActionEvent event) throws IOException {
    App.setRoot("adminpanel");
  }

}
