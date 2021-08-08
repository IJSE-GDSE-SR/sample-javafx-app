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
import lk.ijse.samplejavafxapp.model.Customer;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    @FXML
    private TextField txtCustomerID;
    @FXML
    private TextField txtCustomerName;
    @FXML
    private TextField txtCustomerPhone;
    @FXML
    private TextField txtCustomerEmail;
    @FXML
    private Button btnAddCustomer;

    @FXML
    protected void onClickBtnAddCustomer() {
        String customerIDString = txtCustomerID.getText();
        String customerName = txtCustomerName.getText();
        String customerPhone = txtCustomerPhone.getText();
        String customerEmail = txtCustomerEmail.getText();

        boolean isValidated = validate(customerIDString, customerName, customerPhone, customerEmail);

        if (isValidated) {
            try {
                Customer c = new Customer(Integer.parseInt(customerIDString), customerName, customerPhone, customerEmail);
                System.out.println(c);

                Connection con = DBConnection.getInstance().getConnection();
                PreparedStatement pst = con.prepareStatement("INSERT INTO customer VALUES (?,?,?,?)");
                pst.setInt(1, c.getID());
                pst.setString(2, c.getName());
                pst.setString(3, c.getPhone());
                pst.setString(4, c.getEmail());

                boolean isAdded = pst.executeUpdate() > 0;

                if (isAdded) {
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Customer added successfully");
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

    private void clearFields() {
        txtCustomerID.setText("");
        txtCustomerName.setText("");
        txtCustomerPhone.setText("");
        txtCustomerEmail.setText("");
    }

    private void showAlert(Alert.AlertType type, String header, String content) {
        Alert a = new Alert(type);
        a.setHeaderText(header);
        a.setContentText(content);
        a.show();
    }

    private boolean validate(String customerIDString, String customerName, String customerPhone, String customerEmail) {
        if (customerIDString.equals("") || customerName.equals("") || customerPhone.equals("") || customerEmail.equals("")) {
            showAlert(Alert.AlertType.ERROR, "Missing inputs", "Please enter all details");
            return false;
        } else {
            try {
                int customerID = Integer.parseInt(customerIDString);
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid Customer ID", "Customer ID should be a number");
                return false;
            }
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}