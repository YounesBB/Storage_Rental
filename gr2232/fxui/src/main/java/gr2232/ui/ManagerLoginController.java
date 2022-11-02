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

    private String correctUsername = "admin";
    private String correctPassword = "admin123";


    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if((username.equals(this.correctUsername)) && (password.equals(this.correctPassword))) {
          HandleUser.setIsManager(true);
          App.setRoot("overviewpage");
        } else {
          System.out.println("Feil! Taper:----}]");
          this.response.setText("Feil brukernavn og/eller passord...");
        }
      }

    @FXML
    void onGoBack(ActionEvent event) throws IOException {
      App.setRoot("login");
    }

}

