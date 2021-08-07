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
    private Label lblFormSubmitText;
    @FXML
    private Button btnAddCustomer;

    @FXML
    protected void onClickBtnAddCustomer() {
        if(lblFormSubmitText != null) {
            int customerID = Integer.parseInt(txtCustomerID.getText());
            String customerName = txtCustomerName.getText();
            String customerPhone = txtCustomerPhone.getText();
            String customerEmail = txtCustomerEmail.getText();

            Customer customer = new Customer(customerID, customerName, customerPhone, customerEmail);
            System.out.println(customer);
            lblFormSubmitText.setText("Customer added successfully");
        }
    }
}