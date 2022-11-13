package gr2232.ui;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HandshakeCompletedEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr2232.core.HandleUser;
import gr2232.core.Unit;
import gr2232.core.UnitList;
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
  void initialize() throws IOException {
    boolean manager = HandleUser.getIsManager();
    boolean rest = HandleUser.getUsesRest();
    if (manager) {
      this.addUnitsButton.setDisable(false);
    } else {
      this.addUnitsButton.setDisable(true);
    }
    /*
     * Fetches unitlist from server, and sets it locally.  
     * Does this if there are none units in the program
     * Assumes fresh boot of program. 
     */
    UnitList ul = new UnitList();
    if (rest && ul.getUnitListEntries().size() == 0) {
      ObjectMapper mapper = new ObjectMapper();
      String json = mapper.writeValueAsString("");
      try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/unitlist"))
            .header("Accept", "application/json").header("Content-Type", "application/json").GET().build();

        final HttpResponse<String> response =
            HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
          List<Unit> list = Arrays.asList(new GsonBuilder().create().fromJson(response.body(), Unit[].class));
          ul.clearUnitList();
          ul.getUnitListEntries().addAll(list);
        }

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
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
