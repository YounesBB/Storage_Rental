package gr2232;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ResourceBundle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

public class AppTest extends ApplicationTest {

    private Parent parent;
    private RegisterBoothController controller;
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

    //Might want to change so that empty input == 0 in controller?
    @Test
    public void testInputSize() throws InterruptedException {
        UnitList ul = new UnitList();
        clickOn("#inputSmallBooth").write("4");
        WaitForAsyncUtils.waitForFxEvents();
        clickOn("#inputMediumBooth").write("0");
        WaitForAsyncUtils.waitForFxEvents();
        clickOn("#inputLargeBooth").write("0");
        WaitForAsyncUtils.waitForFxEvents();
        clickOn("#getNewBoothButton");
        WaitForAsyncUtils.waitForFxEvents();
        System.out.println(ul.getUnitListEntries());
        assertEquals(ul.getUnitListEntries().size(), 4);
    }
}