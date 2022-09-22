package gr2232;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;



import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
        showFreeBooth(unitSize.getValue());
    }

    public void showFreeBooth(String boothSize) {
        List<Unit> freeUnits = units.getFreeUnits();
        List<Unit> free = units.getFreeUnitsWithCertainSize(boothSize, freeUnits);
        if (free.isEmpty()) {
            unitLocation.setText("There is no more Units of this size to lease out!");
            this.location = null; 
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

    public void clearFields() {
        UnitOwner.clear();
        unitSize.setValue("");
        unitLocation.setText(""); 
    }

    @FXML
    void leaseOut(ActionEvent event) throws IOException{
        units.getUnitByLocation(this.location).setCustomerName(UnitOwner.getText());
        clearFields();
        
    }

    


}
