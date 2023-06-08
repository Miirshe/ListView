module com.example.listviews {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.listviews to javafx.fxml;
    exports com.example.listviews;
}