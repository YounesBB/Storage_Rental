package gr2232.ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class DeleteUnitController {

    @FXML
    private Button deleteUnitButton;

    @FXML
    private ChoiceBox<?> unitSelector;


    @FXML
    void onDeleteUnit(ActionEvent event) {

    }

    @FXML
    void goToOverView(ActionEvent event) throws IOException {
      App.setRoot("overviewpage");
    }

}