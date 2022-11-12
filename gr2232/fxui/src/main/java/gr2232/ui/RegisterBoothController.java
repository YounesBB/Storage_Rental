package gr2232.ui;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import gr2232.core.HandleUser;
import gr2232.core.Unit;
import gr2232.core.UnitList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RegisterBoothController {

  private List<Unit> list;
  private UnitList units;
  private int largeBooth;
  private int mediumBooth;
  private int smallBooth;

  public RegisterBoothController() {
    units = new UnitList();

  }

  public List<Unit> getUnits() {
    return this.units.getUnitListEntries();

  }

  public UnitList setUnits(UnitList units) {
    return this.units = units;
  }

  @FXML
  private TextField inputLargeBooth, inputMediumBooth, inputSmallBooth;

  // Input a TextField, returns the integer if possible.
  private Integer getIntFromTextField(TextField numberOfBooths) {
    String valueString = numberOfBooths.getText();
    try {
      int number = Integer.parseInt(valueString);
      if (number < 0) {
        throw new IllegalArgumentException("The input can not be negative!");
      }
      return number;
    } catch (final NumberFormatException e) {
      throw new IllegalArgumentException("The number can not be a decimal or empty!"); // burde endres. Stopper
                                                                                       // programmet helt om ikke alle
                                                                                       // felt har fått et tall 0 =<
      // Tolke at et tomt felt betyr 0 bod?
    }
  }

  private void getInputValues() {
    this.largeBooth = getIntFromTextField(inputLargeBooth);
    this.mediumBooth = getIntFromTextField(inputMediumBooth);
    this.smallBooth = getIntFromTextField(inputSmallBooth);
  }

  private void makeBooths() {
    for (int i = 0; i < largeBooth; i++) {
      units.createUnit('L');

    }

    for (int i = 0; i < mediumBooth; i++) {
      units.createUnit('M');

    }
    for (int i = 0; i < smallBooth; i++) {
      units.createUnit('S');

    }
  }

  private void makeBoothsRest() {
    UnitList ul = new UnitList();
    ul.initializeTempUnitList();
    for (int i = 0; i < largeBooth; i++) {
      ul.createTempUnit('L');
    }

    for (int i = 0; i < mediumBooth; i++) {
      ul.createTempUnit('M');

    }
    for (int i = 0; i < smallBooth; i++) {
      ul.createTempUnit('S');

    }
    list = ul.getTempUnits();
    ul.resetTempUnitList();
  }

  private void clearFields() {
    inputLargeBooth.clear();
    inputMediumBooth.clear();
    inputSmallBooth.clear();

  }

  @FXML
  private void getNewBooth() throws IOException {
    getInputValues();
    makeBooths();
    boolean rest = HandleUser.getUsesRest();
    getNewBoothRest();
    clearFields();

  }

  private void getNewBoothRest() throws IOException {
    getInputValues();
    makeBoothsRest();

    for (int i = 0; i < list.size(); i++) {
      ObjectMapper mapper = new ObjectMapper();
      String json = mapper.writeValueAsString(list.get(i));
      try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/unitlist"))
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .POST(BodyPublishers.ofString(json))
            .build();

        final HttpResponse<String> response = HttpClient
            .newBuilder()
            .build()
            .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @FXML
  public void onGoBack() throws IOException {
    App.setRoot("overviewpage");
  }

  public static void main(String args[]) {
    RegisterBoothController a = new RegisterBoothController();
    a.largeBooth = 3;
    a.mediumBooth = 2;
    a.smallBooth = 1;
    a.makeBooths();
    System.out.println(a.getUnits());

  }
}
