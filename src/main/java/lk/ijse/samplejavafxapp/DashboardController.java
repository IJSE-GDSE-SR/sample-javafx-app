package lk.ijse.samplejavafxapp;
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

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    protected void onClickBtnCustomer() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Customers.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Customer Management");
            stage.show();

        } catch (IOException e) {
            System.out.println("Cant open Customer Management window");
        }
    }

    @FXML
    protected void onClickBtnItem() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Items.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Item Management");
            stage.show();

        } catch (IOException e) {
            System.out.println("Cant open Item Management window");
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
