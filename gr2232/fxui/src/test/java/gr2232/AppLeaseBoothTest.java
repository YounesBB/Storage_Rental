package gr2232;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLeaseBoothTest extends ApplicationTest{
    private Parent parent;
    private LeaseBoothController controller;
    private FXMLLoader loader;


    @Override
    public void start(final Stage stage) throws Exception {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("leasebooth.fxml"));
        this.loader = loader;
        this.parent = loader.load();
        this.controller = loader.getController();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @BeforeEach
    public void initialize() {
        UnitList ul = new UnitList();
        ul.clearUnitList();
        Unit u = new Unit('L', 0);
        ul.addUnit(u);          
    }

    @Test
    public void testRentStatus() {
        UnitList ul = new UnitList();  
        clickOn("#UnitOwner").write("Test Testerson");
        WaitForAsyncUtils.waitForFxEvents();
        clickOn("#unitSize").clickOn("Large");
        WaitForAsyncUtils.waitForFxEvents();
        clickOn("#submitButton");
        WaitForAsyncUtils.waitForFxEvents();
        Unit rentedUnit = ul.getRentedUnits().get(0);
        assertEquals(rentedUnit.getIsRented(), true);
    }

    @Test
    public void testName() {
        UnitList ul = new UnitList();

        clickOn("#UnitOwner").write("Test Testerson");
        WaitForAsyncUtils.waitForFxEvents();
        clickOn("#unitSize").clickOn("Large");
        WaitForAsyncUtils.waitForFxEvents();
        clickOn("#submitButton");
        WaitForAsyncUtils.waitForFxEvents();
        Unit rentedUnit = ul.getRentedUnits().get(0);
        assertEquals(rentedUnit.getCustomerName(), "Test Testerson");
    }

    @Test
    public void testLocation() {
        UnitList ul = new UnitList();

        clickOn("#UnitOwner").write("Test Testerson");
        WaitForAsyncUtils.waitForFxEvents();
        clickOn("#unitSize").clickOn("Large");
        WaitForAsyncUtils.waitForFxEvents();
        clickOn("#submitButton");
        WaitForAsyncUtils.waitForFxEvents();
        Unit rentedUnit = ul.getRentedUnits().get(0);
        assertEquals(rentedUnit.getLocation(), 0);
    }
}
