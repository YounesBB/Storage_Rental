package gr2232.ui;

import java.io.IOException;
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
    private ChoiceBox<?> unitSelector;


    @FXML
    void onDeleteUnit(ActionEvent event) {
      //TO-DO
    }

    @FXML
    void goToOverView(ActionEvent event) throws IOException {
      App.setRoot("overviewpage");
    }

}