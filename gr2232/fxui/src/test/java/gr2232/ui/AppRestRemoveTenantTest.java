package gr2232.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;

import gr2232.core.HandleUser;
import gr2232.core.Unit;
import gr2232.core.UnitList;
import org.testfx.api.FxAssert;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppRestRemoveTenantTest extends ApplicationTest {
    private Parent parent;
    private RemoveTenantController controller;
    private FXMLLoader loader;

    private String name;

    @Override
    public void start(final Stage stage) throws Exception {
        HandleUser.setUsesRest(true);

        UnitList ul = new UnitList();
        ul.clearUnitList();

        // Get list from server
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/unitlist"))
                    .header("Accept", "application/json").header("Content-Type", "application/json").GET().build();

            final HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
            if (response.statusCode() == 200) {
                List<Unit> list = Arrays.asList(new GsonBuilder().create().fromJson(response.body(), Unit[].class));
                ul.clearUnitList();
                ul.getUnitListEntries().addAll(list);
                UnitList ul2 = new UnitList(ul.getUnitListEntries().size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Add a test unit
        ObjectMapper mapper = new ObjectMapper();
        Unit u = new Unit('L', 999, true, "Testerson");
        String json = mapper.writeValueAsString(u);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/unitlist"))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .POST(BodyPublishers.ofString(json))
                    .build();

            final HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                ul.addUnit(u);
                UnitList.incrementLocation();
                System.out.println("Added unit:");
            } else if (response.statusCode() == 500) {
                System.out.println("Internal Server error 500");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final FXMLLoader loader = new FXMLLoader(getClass().getResource("removetenant.fxml"));
        this.loader = loader;
        this.parent = loader.load();
        this.controller = loader.getController();

        stage.setScene(new Scene(parent));
        stage.show();
    }

    @BeforeEach
    public void initialize() throws IOException {
        UnitList ul = new UnitList();

    }

    @Test
    public void testRemoveTenant() throws IOException {
        WaitForAsyncUtils.waitForFxEvents();
        UnitList ul = new UnitList();
        Integer rentedUnitsBeforeRemoved = ul.getRentedUnits().size();
        ChoiceBox<String> test = (ChoiceBox) parent.lookup("#tenantSelector");
        System.out.println(test.selectionModelProperty().get());
        clickOn("#tenantSelector").clickOn("Testerson,999,L");
        clickOn("#removeTenantButton");
        Integer rentedUnitsAfterRemoved = ul.getRentedUnits().size();
        assertNotEquals(rentedUnitsAfterRemoved, rentedUnitsBeforeRemoved);
        assertEquals(rentedUnitsAfterRemoved + 1, rentedUnitsBeforeRemoved);

        // Remove test unit from server.
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/unitlist/999"))
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .DELETE()
            .build();

            final HttpResponse<String> response = HttpClient.newBuilder()
            .build()
            .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
            if (response.statusCode() == 200) {
               System.out.println("Removed unit");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
