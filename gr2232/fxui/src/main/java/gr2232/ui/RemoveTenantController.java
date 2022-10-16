package gr2232.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.IOException;
import gr2232.core.Unit;
import gr2232.core.UnitList;

public class RemoveTenantController {

  @FXML
  private TableColumn<?, ?> locationColumn;

  @FXML
  private TableColumn<?, ?> nameColumn;

  @FXML
  private TableColumn<?, ?> removeColumn;

  @FXML
  private TableColumn<?, ?> sizeColumn;

  @FXML
  private TableView<?> tenantTable;

  @FXML
  private ChoiceBox<String> tenantSelector;

  private ObservableList<String> tenantList = FXCollections.observableArrayList();

  @FXML
  private void goToOverView() throws IOException {
    App.setRoot("overviewpage");
  }

  @FXML
  void onRemoveTenant() throws IOException {
    UnitList unitList = new UnitList();
    String tenantLine = tenantSelector.getValue();
    if (tenantLine == null) {
      throw new IllegalArgumentException("Must select a tenant to remove!");
    } else {
      String[] tenantData = tenantLine.split(",");
      Integer location = Integer.parseInt(tenantData[1]);

      Unit unitToRemoveTenant = unitList.getUnitByLocation(location);
      unitToRemoveTenant.setIsRented(false);
      unitList.updateUnitByLocation(location, unitToRemoveTenant);

      updateTenantList();
      tenantSelector.setItems(tenantList);
    }

  }

  private void updateTenantList() {
    UnitList unitList = new UnitList();
    tenantList.clear();
    for (var unit : unitList.getRentedUnits()) {
      String name = unit.getCustomerName();
      Integer location = unit.getLocation();
      Character size = unit.getSize();
      String tenantInformation = name + "," + location + "," + size;
      this.tenantList.add(tenantInformation);
    }

  }

  @FXML
  public void initialize() {
    updateTenantList();
    tenantSelector.setItems(tenantList);
    // tenantSelector.setValue("test");
  }

}
