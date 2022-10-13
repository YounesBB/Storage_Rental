package gr2232;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void switchToOverviewAsEmployee() throws IOException {
        HandleUser.setIsManager(false);
        App.setRoot("overviewpage");
    }

    @FXML
    private void switchToOverviewAsManager() throws IOException {
        HandleUser.setIsManager(true);
        App.setRoot("overviewpage");
    }
}
