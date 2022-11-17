package gr2232.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.text.MessageFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import gr2232.core.HandleUser;
import gr2232.core.Unit;
import gr2232.core.UnitList;

/**
 * Controller for the removetenant page.
 * Gives the user the ability to remove tenants and clear up units.
 */

public class RemoveTenantController {


  @FXML
  private ChoiceBox<String> tenantSelector;

  private ObservableList<String> tenantList = FXCollections.observableArrayList();

  @FXML
  private void goToOverView() throws IOException {
    App.setRoot("overviewpage");
  }

  @FXML
  void onRemoveTenant() throws IOException {
    UnitList unitList = new UnitList();
    String tenantLine = tenantSelector.getValue();
    if (HandleUser.getUsesRest()) {
      ObjectMapper mapper = new ObjectMapper();
      String[] tenantData = tenantLine.split(",");
      Integer location = Integer.parseInt(tenantData[1]);
      String json = mapper.writeValueAsString(location);
      String url = MessageFormat.format("http://localhost:8080/unitlist/removetenant/{0}", location);
      try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .PUT(BodyPublishers.ofString(json))
            .build();

        final HttpResponse<String> response =
            HttpClient.newBuilder()
            .build().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        if ((response.statusCode() == 200) && (Boolean.parseBoolean(response.body()))) {
          unitList.getUnitByLocation(location).removeTenantFromUnit();
          System.out.println("Tenant removed from unit: " + location);
          updateTenantList();
          tenantSelector.setItems(tenantList);
        } else if (response.statusCode() == 500) {
          System.out.println("Internal Server error 500");
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    } else {

      if (tenantLine == null) {
        throw new IllegalArgumentException("Must select a tenant to remove!");
      } else {
        String[] tenantData = tenantLine.split(",");
        Integer location = Integer.parseInt(tenantData[1]);

        Unit unitToRemoveTenant = unitList.getUnitByLocation(location);
        unitToRemoveTenant.setIsRented(false);
        unitList.updateUnitByLocation(location, unitToRemoveTenant);

        updateTenantList();
        tenantSelector.setItems(tenantList);
      }
    }


  }

  private void updateTenantList() {
    UnitList unitList = new UnitList();
    tenantList.clear();
    for (var unit : unitList.getRentedUnits()) {
      String name = unit.getCustomerName();
      Integer location = unit.getLocation();
      Character size = unit.getSize();
      if(HandleUser.getUsesRest()){
        name = name.replace("_", " ");
      }
      String tenantInformation = name + "," + location + "," + size;
      this.tenantList.add(tenantInformation);
    }

  }

  @FXML
  public void initialize() {
    updateTenantList();
    tenantSelector.setItems(tenantList);
    // tenantSelector.setValue("test");
  }

}
