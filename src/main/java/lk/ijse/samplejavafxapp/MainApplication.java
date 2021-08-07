/**
 * @author Sandul Renuja <sandulrenuja@gmail.com>
 * @since  7/8/21
 */

package lk.ijse.samplejavafxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        Parent load = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Customers.fxml")));
//        Scene scene = new Scene(load);
//        stage.setScene(scene);
//        stage.setTitle("Customer Management");
//        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}