package gr2232.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.internal.bytebuddy.jar.asm.Handle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;

import gr2232.core.HandleUser;
import gr2232.core.Unit;
import gr2232.core.UnitList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppRestLeaseBoothTest extends ApplicationTest {
    private Parent parent;
    private LeaseBoothController controller;
    private FXMLLoader loader;

    @Override
    public void start(final Stage stage) throws Exception {
        HandleUser.setUsesRest(true);
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("leasebooth.fxml"));
        this.loader = loader;
        this.parent = loader.load();
        this.controller = loader.getController();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @BeforeEach
    public void initialize() throws IOException {
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

        // Create empty Test Unit
        ObjectMapper mapper = new ObjectMapper();
        Unit u = new Unit('M', 999, false, "null");
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
    }

    @AfterEach
    public void after() throws IOException {
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

    @Test
    public void testRentStatus() {
        UnitList ul = new UnitList();
        clickOn("#UnitOwner").write("Ole");
        WaitForAsyncUtils.waitForFxEvents();
        clickOn("#unitSize").clickOn("Medium");
        WaitForAsyncUtils.waitForFxEvents();
        clickOn("#submitButton");
        WaitForAsyncUtils.waitForFxEvents();
        Unit rentedUnit = ul.getUnitByLocation(999);
        assertEquals(true,rentedUnit.getIsRented());
    }
}
