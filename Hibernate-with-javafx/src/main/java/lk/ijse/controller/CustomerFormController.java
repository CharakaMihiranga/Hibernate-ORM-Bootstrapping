package lk.ijse.controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lk.ijse.entity.Customer;
import lk.ijse.model.CustomerModel;

public class CustomerFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtName;

    @FXML
    private VBox vBox;

    CustomerModel customerModel = new CustomerModel();

    public void initialize(){
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
    @FXML
    void btnDeleteOnAction(ActionEvent event) {
       int deleteID = Integer.parseInt(txtId.getText());
       customerModel.deleteCustomer(deleteID);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        String name = txtName.getText();
        String address = txtAddress.getText();
        String mobile = txtMobile.getText();

        customerModel.saveCustomer(new Customer(name,address,mobile));
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        customerModel.updateCustomer(Integer.parseInt(txtId.getText()),new Customer(
                txtName.getText(),
                txtAddress.getText(),
                txtMobile.getText()
        ));

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

        int id = Integer.parseInt(txtId.getText());

        Customer customer = customerModel.searchCustomer(id);

        if (customer != null){

            txtId.setText(String.valueOf(customer.getId()));
            txtName.setText(customer.getName());
            txtAddress.setText(customer.getAddress());
            txtMobile.setText(String.valueOf(customer.getMoNumber()));

        }
    }

}
