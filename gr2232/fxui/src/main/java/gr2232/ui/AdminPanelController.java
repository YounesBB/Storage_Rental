package gr2232.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import gr2232.core.UnitList;
import gr2232.core.UnitListFileSupport;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AdminPanelController {

  @FXML
  private TextField fileUrl;

  @FXML
  private TextArea responseText;

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

  @FXML
  void onLoad(ActionEvent event) {
    UnitList unitList = new UnitList();
    UnitListFileSupport fileHandler = new UnitListFileSupport();

    String fileName = fileUrl.getText();

    try {
      unitList.clearUnitList();
      fileHandler.getListFromFile(fileName);
      responseText.setText("Loaded!");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      responseText.setText("Error loading file");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      responseText.setText("Unsupported encoding");
    }
  }

  @FXML
  void onSave(ActionEvent event) throws IOException {
    UnitListFileSupport fileHandler = new UnitListFileSupport();

    String fileName = fileUrl.getText();
    fileHandler.writeListToFile(fileName);
    responseText.setText("Saved!");

  }

}
