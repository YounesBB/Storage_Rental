module gr2232.ui {
    requires com.fasterxml.jackson.databind;
    
    requires java.net.http;
    requires gr2232.core;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    
    opens gr2232.ui to javafx.graphics, javafx.fxml;
}
