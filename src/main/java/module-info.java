module lk.ijse.samplejavafxapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.ijse.samplejavafxapp to javafx.fxml;
    exports lk.ijse.samplejavafxapp;
}