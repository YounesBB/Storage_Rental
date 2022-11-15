package gr2232.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.assertj.core.internal.bytebuddy.jar.asm.Handle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;
import org.testfx.api.FxToolkit;

import gr2232.core.HandleUser;
import gr2232.core.Unit;
import gr2232.core.UnitList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AppOverviewPageTest extends ApplicationTest {
    private Parent parent;
    private OverviewPageController controller;
    private FXMLLoader loader;

    @Override
    public void start(final Stage stage) throws Exception {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("overviewpage.fxml"));
        HandleUser.setUsesRest(true);
        HandleUser.setIsManager(false);
        this.loader = loader;
        this.parent = loader.load();
        this.controller = loader.getController();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @BeforeEach
    public void initialize() {
    }

    @Test
    public void DisabledButtonAsEmployee() {
        Button button = (Button) parent.lookup("#addUnitsButton");
        assertEquals(true, button.isDisabled());
    }

    @Test
    public void SettingsDisabledUsingRest() {
        Button button = (Button) parent.lookup("#settingsButton");
        System.out.println(button.isDisabled());
        assertEquals(true, button.isDisabled());
    }
}
