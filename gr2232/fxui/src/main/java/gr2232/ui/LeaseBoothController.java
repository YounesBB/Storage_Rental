package gr2232.ui;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;
import com.fasterxml.jackson.databind.ObjectMapper;
import gr2232.core.HandleUser;
import gr2232.core.Unit;
import gr2232.core.UnitList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller for the LeaseBoothController page.
 * Gives users the ability to lease out booths. 
 */

public class LeaseBoothController implements Initializable {

  @FXML
  private TextField UnitOwner;

  @FXML
  private TextArea unitLocation;

  @FXML
  private ComboBox<String> unitSize;

  UnitList units = new UnitList();

  private String[] sizes = {"Large", "Medium", "Small"};

  Integer location;



  @Override
  public void initialize(URL location, ResourceBundle resources) {
    unitSize.getItems().addAll(sizes);
  }

  @FXML
  void getSizeValue(ActionEvent event) throws IOException {
    if (unitSize.getValue() == null) {
      throw new NullPointerException();
    } else {
      showFreeBooth(unitSize.getValue());
    }
  }

  /* shows units of a chosen size*/
  public void showFreeBooth(String boothSize) {
    List<Unit> free = units.getFreeUnitsWithCertainSize(boothSize);
    if (free.isEmpty()) {
      unitLocation.setText("There is no more Units of this size to lease out!");
    } else {
      Integer location = free.get(0).getLocation();
      this.location = location;
    }
    unitLocation.setText(Integer.toString(location));
  }


  @FXML
  void goBackToOverviewPage(ActionEvent event) throws IOException {
    App.setRoot("overviewpage");

  }


  @FXML
  void leaseOut(ActionEvent event) throws IOException {
    if (UnitOwner.getText().equals("") || unitSize.getValue() == null || unitLocation.getText().equals("")) {
      throw new IllegalArgumentException("Must select size and give customername!");
    } else {
      if(HandleUser.getUsesRest()) {

        ObjectMapper mapper = new ObjectMapper();
        String name = UnitOwner.getText().replace(" ", "_");
        String put = location + name;
        String json = mapper.writeValueAsString(put);
        String url = MessageFormat.format("http://localhost:8080/unitlist/addtenant/{0}/{1}", location, name);
        try {
          HttpClient client = HttpClient.newHttpClient();
          HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(url))
              .header("Accept", "application/json")
              .header("Content-Type", "application/json")
              .PUT(BodyPublishers.ofString(json))
              .build();
  
          final HttpResponse<String> response = HttpClient
              .newBuilder()
              .build()
              .send(request, HttpResponse.BodyHandlers.ofString());
          if((response.statusCode() == 200) && (Boolean.parseBoolean(response.body()))) {
            units.getUnitByLocation(location).setCustomerName(name);;
            System.out.println("Added customer: " + name + ", to unit location: " + location);
            this.UnitOwner.clear();
            this.unitLocation.clear();
          }
          else if(response.statusCode() == 500) {
            System.out.println("Internal Server error 500");
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      } 
      else {
        units.getUnitByLocation(this.location).setCustomerName(UnitOwner.getText());
        this.UnitOwner.clear();
        this.unitLocation.clear();
      }

      // this.unitSize.getSelectionModel().clearSelection();
      // This causes testfx to raise exception
    }
  }



}
