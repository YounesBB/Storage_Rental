package gr2232;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RegisterBoothController {
 
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
    
    //Input a TextField, returns the integer if possible. 
    private Integer getIntFromTextField(TextField numberOfBooths) {
        String valueString = numberOfBooths.getText();
        try {
            int number = Integer.parseInt(valueString);
            if (number < 0) {
                throw new IllegalArgumentException("The input can not be negative!"); 
            }
            return number;
        }
        catch (final NumberFormatException e) { 
            return null;
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
    
    private void clearFields() {
        inputLargeBooth.clear();
        inputMediumBooth.clear();
        inputSmallBooth.clear();
        
    }

    //TODO: Add logic such that new booths get added
    @FXML
    private void getNewBooth() throws IOException {
        getInputValues();
        makeBooths();
        clearFields(); 
        System.out.println(units.getUnitListEntries()); //testkode
    
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
