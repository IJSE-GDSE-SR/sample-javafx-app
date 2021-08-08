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

package lk.ijse.samplejavafxapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.samplejavafxapp.db.DBConnection;
import lk.ijse.samplejavafxapp.model.Item;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ItemController implements Initializable {
    @FXML
    private TextField txtItemID;
    @FXML
    private TextField txtItemName;
    @FXML
    private TextField txtItemBuyingPrice;
    @FXML
    private TextField txtItemSellingPrice;
    @FXML
    private TextField txtItemQty;
    @FXML
    private Button btnAddItem;

    @FXML
    protected void onClickBtnAddItem() {
        String itemIDString = txtItemID.getText();
        String itemName = txtItemName.getText();
        String itemBPString = txtItemBuyingPrice.getText();
        String itemSPString = txtItemSellingPrice.getText();
        String itemQtyString = txtItemQty.getText();

        boolean isValidated = validate(itemIDString, itemName, itemBPString, itemSPString, itemQtyString);

        if (isValidated) {
            try {
                int itemID = Integer.parseInt(itemIDString);
                double itemBP = Double.parseDouble(itemBPString);
                double itemSP = Double.parseDouble(itemSPString);
                double itemQty = Double.parseDouble(itemQtyString);

                Item i = new Item(itemID, itemName, itemBP, itemSP, itemQty);
                System.out.println(i);

                Connection con = DBConnection.getInstance().getConnection();
                PreparedStatement pst = con.prepareStatement("INSERT INTO item VALUES (?,?,?,?,?)");
                pst.setInt(1, i.getID());
                pst.setString(2, i.getName());
                pst.setDouble(3, i.getBuyingPrice());
                pst.setDouble(4, i.getSellingPrice());
                pst.setDouble(5, i.getQty());

                boolean isAdded = pst.executeUpdate() > 0;

                if (isAdded) {
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Item added successfully");
                    clearFields();
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "Oops, that didn't work, please try again");
                }

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("An error occurred while connecting to MySQL DB");
                showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while connecting MySQL DB");
                e.printStackTrace();
            }
        }
    }

    private boolean validate(String itemIDString, String itemName, String itemBPString, String itemSPString, String itemQtyString) {
        if (itemIDString.equals("") || itemName.equals("") || itemBPString.equals("") || itemSPString.equals("") || itemQtyString.equals("")) {
            showAlert(Alert.AlertType.ERROR, "Missing inputs", "Please enter all details");
            return false;
        } else {
            try {
                int itemID = Integer.parseInt(itemIDString);
                double itemBP = Double.parseDouble(itemBPString);
                double itemSP = Double.parseDouble(itemSPString);
                double itemQty = Double.parseDouble(itemQtyString);

            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid inputs", "Item ID, buying price, selling price" +
                        " and qty should be numeric values");
                return false;
            }
        }
        return true;

    }

    private void clearFields() {
        txtItemID.setText("");
        txtItemName.setText("");
        txtItemBuyingPrice.setText("");
        txtItemSellingPrice.setText("");
        txtItemQty.setText("");
    }

    private void showAlert(Alert.AlertType type, String header, String content) {
        Alert a = new Alert(type);
        a.setHeaderText(header);
        a.setContentText(content);
        a.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}