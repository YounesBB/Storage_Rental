package gr2232;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterBoothSimpleController {

  @FXML
  private Button addNewBoothButton;

  @FXML
  private TextField inputBoothLocation;

  @FXML
  private TextField inputBoothSize;

  // Input a TextField, returns the integer if possible.
  private Integer getIntFromTextField(TextField name) {
    String valueString = name.getText();
    try {
      int number = Integer.parseInt(valueString);
      return number;
    } catch (final NumberFormatException e) {
      return null;
    }
  }

  // TODO: Add logic such that new booths get added
  // Hent ut verdi fra de to tekstfeltene
  // Lag en unit med de verdiene
  // Putt uniten i liste med units
  @FXML
  void addNewBooth(ActionEvent event) {

    // Testing that aquired number is correct
    System.out.println(getIntFromTextField(inputBoothLocation));

  }

  @FXML
  void goBackToOverviewpage(ActionEvent event) throws IOException {
    App.setRoot("overviewpage");

  }

}
