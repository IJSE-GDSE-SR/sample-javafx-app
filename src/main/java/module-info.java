/**
 * @author Sandul Renuja <sandulrenuja@gmail.com>
 * @since  7/8/21
 */

module lk.ijse.samplejavafxapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens lk.ijse.samplejavafxapp to javafx.fxml;
    exports lk.ijse.samplejavafxapp;
    exports lk.ijse.samplejavafxapp.controller;
    opens lk.ijse.samplejavafxapp.controller to javafx.fxml;
}