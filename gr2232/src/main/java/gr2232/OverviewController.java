package gr2232;

import java.io.IOException;
import javafx.fxml.FXML;

public class OverviewController {

    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }
}