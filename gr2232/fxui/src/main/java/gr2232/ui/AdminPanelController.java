package gr2232.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import gr2232.core.UnitList;
import gr2232.json.UnitListFileSupport;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
* Controller for AdminPanel.
* Supports loading, clearing and saving the UnitList.
*/

public class AdminPanelController {

  @FXML
  private TextField fileUrl;

  @FXML
  private TextArea responseText;

  /* clears all units */
  @FXML
  void onClearSystem(ActionEvent event) {
    UnitList unitList = new UnitList();
    unitList.clearUnitList();
    responseText.setText("System cleared!");
  }

  @FXML
  void onGoBack(ActionEvent event) throws IOException {
    App.setRoot("overviewpage");
  }

  /* loads list from the file written in the box */
  @FXML
  void onLoad(ActionEvent event) {
    String fileName = fileUrl.getText();

    UnitList unitList = new UnitList();
    UnitListFileSupport fileHandler = new UnitListFileSupport(fileName);


    try {
      unitList.clearUnitList();
      fileHandler.getListFromFile();
      responseText.setText("Loaded!");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      responseText.setText("Error loading file");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      responseText.setText("Unsupported encoding");
    }
  }

  /* saves list to the file written in the box*/
  @FXML
  void onSave(ActionEvent event) throws IOException {
    String fileName = fileUrl.getText();
    UnitListFileSupport fileHandler = new UnitListFileSupport(fileName);

    fileHandler.writeListToFile();
    responseText.setText("Saved!");

  }

}
