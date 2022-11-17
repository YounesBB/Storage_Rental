package gr2232.ui;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;
import gr2232.core.HandleUser;
import gr2232.core.Unit;
import gr2232.core.UnitList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;


/**
 * Controller for the deleteUnit page.
 * Gives the user the ability to delete a unit. 
 */
public class DeleteUnitController {

    @FXML
    private Button deleteUnitButton;

    @FXML
    private ChoiceBox<String> unitSelector;

    private ObservableList<String> deleteUnitList = FXCollections.observableArrayList();

    @FXML
    void onDeleteUnit(ActionEvent event) throws IOException {
      UnitList unitList = new UnitList();
      String unitLine = unitSelector.getValue();
      if (HandleUser.getUsesRest()) {
        String[] unitData = unitLine.split(",");
        Integer location = Integer.parseInt(unitData[1]);
        String url = MessageFormat.format("http://localhost:8080/unitlist/{0}", location);
        try {
          HttpClient client = HttpClient.newHttpClient();
          HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(url))
              .header("Accept", "application/json")
              .header("Content-Type", "application/json")
              .DELETE()
              .build();
  
          final HttpResponse<String> response =
              HttpClient.newBuilder()
              .build().send(request, HttpResponse.BodyHandlers.ofString());
          System.out.println(response);

          if ((response.statusCode() == 200) && (Boolean.parseBoolean(response.body()))) {
            unitList.removeUnitByLocation(location);
            System.out.println("Unit removed from UnitList: " + location);
            updateUnitList();
            unitSelector.setItems(deleteUnitList);
          } else if (response.statusCode() == 500) {
            System.out.println("Internal Server error 500");
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
  
      } else {
  
        if (unitLine == null) {
          throw new IllegalArgumentException("Must select a tenant to remove!");
        } else {
          String[] tenantData = unitLine.split(",");
          Integer location = Integer.parseInt(tenantData[1]);
  
          unitList.removeUnitByLocation(location);  
  
          updateUnitList();
          unitSelector.setItems(deleteUnitList);
        }
      }
    }

    private void updateUnitList() {
      UnitList unitList = new UnitList();
      deleteUnitList.clear();
      for (var unit : unitList.getFreeUnits()) {
        String name = unit.getCustomerName();
        Integer location = unit.getLocation();
        Character size = unit.getSize();
        String tenantInformation = name + "," + location + "," + size; 
        this.deleteUnitList.add(tenantInformation);
      }
    }

    @FXML
    public void initialize() {
      updateUnitList();
      unitSelector.setItems(deleteUnitList);
    }

    @FXML
    void goToOverView(ActionEvent event) throws IOException {
      App.setRoot("overviewpage");
    }

}