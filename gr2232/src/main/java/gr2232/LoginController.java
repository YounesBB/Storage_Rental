package gr2232;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void switchToOverview() throws IOException {
        App.setRoot("overview");
    }
}
