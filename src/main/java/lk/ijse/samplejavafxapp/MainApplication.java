/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2021 - present Sandul Renuja. All rights reserved.
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

/*
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
import java.util.Objects;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent load = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view/Dashboard.fxml")));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setTitle("Dashboard");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}