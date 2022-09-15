module gr2232 {
    requires javafx.controls;
    requires javafx.fxml;

    opens gr2232 to javafx.fxml;
    exports gr2232;
}
