package gr2232.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NameClassPair;

import gr2232.core.Unit;
import gr2232.core.UnitList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controller for the allUnits page.
 */

public class AllUnitsController {

  private UnitList unitList;

  @FXML
  private Button backButton;

  @FXML
  private TableColumn<Unit, Integer> locationColumn;

  @FXML
  private TableColumn<Unit, String> nameColumn;

  @FXML
  private TableColumn<Unit, Character> sizeColumn;

  @FXML
  private TableColumn<Unit, Boolean> statusColumn;

  @FXML
  private TableView<Unit> tableView;



  @FXML
  public void initialize() {
    UnitList unitList = new UnitList();
    this.unitList = unitList;
    updateTable();
  }

  private void updateTable() {
    sizeColumn.setCellValueFactory(new PropertyValueFactory<Unit, Character>("Size"));
    locationColumn.setCellValueFactory(new PropertyValueFactory<Unit, Integer>("Location"));
    nameColumn.setCellValueFactory(new PropertyValueFactory<Unit, String>("customerName"));
    statusColumn.setCellValueFactory(new PropertyValueFactory<Unit, Boolean>("isRented"));

    tableView.setItems(getUnits());
  }

  private ObservableList<Unit> getUnits() {
    ObservableList<Unit> units = FXCollections.observableArrayList();
    unitList.getUnitListEntries().stream().forEach((u) -> {
      Boolean status = u.getIsRented();
      String name = u.getCustomerName().replace("_", " ");
      u.setCustomerName(name);
      u.setIsRented(status);
      units.add(u);
    });

    return units;
  }

  // Remove functions? Or keep just in case
  /* private List<Character> getSizeList() {
    List<Character> sizeList = new ArrayList<>();
    unitList.getUnitListEntries().stream().forEach((u) -> {
      sizeList.add(u.getSize());
    });
    return sizeList;
  }

  private List<Integer> getLocationList() {
    List<Integer> locationList = new ArrayList<>();
    unitList.getUnitListEntries().stream().forEach((u) -> {
      locationList.add(u.getLocation());
    });
    return locationList;
  }

  private List<String> getNameList() {
    List<String> nameList = new ArrayList<>();
    unitList.getUnitListEntries().stream().forEach((u) -> {
      nameList.add(u.getCustomerName());
    });
    return nameList;
  }

  private List<Boolean> getStatusList() {
    List<Boolean> statusList = new ArrayList<>();
    unitList.getUnitListEntries().stream().forEach((u) -> {
      statusList.add(u.getIsRented());
    });
    return statusList;
  } */

  @FXML
  void backToOverviewpage(ActionEvent event) throws IOException {
    App.setRoot("overviewpage");
  }

}
