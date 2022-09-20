package gr2232;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LeaseBoothController implements Initializable{

    @FXML
    private ChoiceBox<String> leaseSize;

    private String[] sizes = {"Large", "Medium", "Small"};
    
    @FXML
    private TextField leaseName; 

    @FXML
    private TextArea leaseLocation;

    @FXML
    private void submitLease() throws IOException {
        System.out.println("test");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        leaseSize.getItems().addAll(sizes);
    }

    @FXML
    public void onGoBack() throws IOException {
        App.setRoot("overviewpage");
    }
  
    //Add function to assign location automatically

}