package gr2232;

import java.io.IOException;
import javafx.fxml.FXML;

public class RemoveTenantController {
    
    @FXML
    public void goToOverView() throws IOException {
        App.setRoot("overviewpage");
    }
}
