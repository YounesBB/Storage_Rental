package gr2232;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.IOException;


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
    private void goToOverView() throws IOException {
        App.setRoot("login");
    }

}
