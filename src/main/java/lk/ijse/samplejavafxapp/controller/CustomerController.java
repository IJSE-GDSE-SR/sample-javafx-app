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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.samplejavafxapp.model.Customer;

public class CustomerController {
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
            Customer customer = new Customer(Integer.parseInt(customerIDString), customerName, customerPhone, customerEmail);
            System.out.println(customer);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Customer added successfully");
            clearFields();
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
}