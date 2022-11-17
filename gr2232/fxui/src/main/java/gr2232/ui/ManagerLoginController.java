package gr2232.ui;

import java.io.IOException;
import gr2232.core.HandleUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ManagerLoginController {

    @FXML
    private Button goBackButton;

    @FXML
    private Button loginbutton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private Text response;

    /* checks if login credidentials are correct */
    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        HandleUser user = new HandleUser();
        boolean inputValid = user.validateInputs(username, password);
        if(inputValid) {
          HandleUser.setIsManager(true);
          App.setRoot("overviewpage");
        }
        else {
          response.setText("Username and/or password is incorrect.");
        }
      }

    @FXML
    void onGoBack(ActionEvent event) throws IOException {
      App.setRoot("login");
    }

}

