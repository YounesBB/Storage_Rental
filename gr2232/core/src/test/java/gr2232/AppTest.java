package gr2232;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ResourceBundle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AppTest extends ApplicationTest {

    private Parent parent;
    private LoginController controller;
    private FXMLLoader loader;

    private Button newBoothButton;
    private TextField smallBooths;
    private TextField mediumBooths;
    private TextField largeBooths;

    @Override
    public void start(final Stage stage) throws Exception {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("registerbooth.fxml"));
        this.loader = loader;
        this.parent = loader.load();
        this.controller = loader.getController();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @BeforeEach
    public void initialize() {
        this.newBoothButton = (Button) parent.lookup("#getNewBoothButton");
        this.smallBooths = (TextField) parent.lookup("#inputSmallBooth");
        this.mediumBooths = (TextField) parent.lookup("#inputMediumBooth");
        this.largeBooths = (TextField) parent.lookup("#inputLargeBooth");
    }

    @Test
    public void testController() {
        controller.clickOn(smallBooths).type(2);
        clickOn(employeeButton);
        AnchorPane currentPage = loader.getRoot();
        assertNotEquals(currentPage, loginPage);
    }
}