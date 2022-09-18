package gr2232;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RegisterBoothController {

    @FXML
    private TextField inputLargeBooth, inputMediumBooth, inputSmallBooth;
    
    //Input a TextField, returns the integer if possible. 
    private Integer getIntFromTextField(TextField name) {
        String valueString = name.getText();
        try {
            int number = Integer.parseInt(valueString);
            return number;
        }
        catch (final NumberFormatException e) {
            return null;
        }
    }

    //TODO: Add logic such that new booths get added
    @FXML
    private void getNewBooth() throws IOException {
        //Testing that aquired number is correct
        System.out.println(getIntFromTextField(inputLargeBooth));
    }
} 
