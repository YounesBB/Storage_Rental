package gr2232.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import com.google.gson.GsonBuilder;

import gr2232.core.UnitList;
import gr2232.core.HandleUser;
import gr2232.core.Unit;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppRestRegisterBoothTest extends ApplicationTest {

  private Parent parent;
  private RegisterBoothController controller;
  private FXMLLoader loader;
  private int location;

  @Override
  public void start(final Stage stage) throws Exception {
    UnitList ul = new UnitList();
    ul.clearUnitList();
    final FXMLLoader loader = new FXMLLoader(getClass().getResource("registerbooth.fxml"));
    HandleUser.setUsesRest(true);
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
      }


  @AfterEach
  public void after() throws IOException {
      try {
          HttpClient client = HttpClient.newHttpClient();
          String url = MessageFormat.format("http://localhost:8080/unitlist/{0}", location);
          HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(url))
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
  public void testInputSize() throws InterruptedException {
    UnitList ul = new UnitList();
    int entriesBeforeAdding = ul.getUnitListEntries().size();
    assertTrue(HandleUser.getUsesRest());
    clickOn("#inputSmallBooth").write("1");
    clickOn("#inputMediumBooth").write("0");
    clickOn("#inputLargeBooth").write("0");
    clickOn("#getNewBoothButton");
    WaitForAsyncUtils.waitForFxEvents();
    assertEquals(entriesBeforeAdding, ul.getUnitListEntries().size()-1);
    Unit unitToRemove = ul.getUnitByLocation(ul.getUnitListEntries().size()-1);
    this.location = unitToRemove.getLocation();
  }
}
