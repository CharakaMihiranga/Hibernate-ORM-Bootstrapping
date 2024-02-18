package lk.ijse.controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lk.ijse.entity.Customer;
import lk.ijse.model.CustomerModel;
import lk.ijse.repository.CustomerRepository;

import java.io.IOException;

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

    CustomerRepository customerRepository =  new CustomerRepository();

    public CustomerFormController() throws IOException {
    }

    public void initialize(){
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
    @FXML
    void btnDeleteOnAction(ActionEvent event) {

       int deleteID = Integer.parseInt(txtId.getText());

       try {

           customerRepository = new CustomerRepository();

           Customer delete =  customerRepository.getCustomer(deleteID);

           customerRepository = new CustomerRepository();

           boolean isDeleted = customerRepository.deleteCustomer(delete);

           if (isDeleted) {
               new Alert(Alert.AlertType.CONFIRMATION, "Customer Deleted!").show();
             }

       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        int id = 0;
        String name = txtName.getText();
        String address = txtAddress.getText();
        String mobile = txtMobile.getText();

        int isSaved = customerRepository.saveCustomer(new Customer(id,name,address,mobile));

        if(isSaved > 0){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Saved!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

//        customerModel.updateCustomer(Integer.parseInt(txtId.getText()),new Customer(
//                txtName.getText(),
//                txtAddress.getText(),
//                txtMobile.getText()
//        ));

       try{

           customerRepository = new CustomerRepository();

           int id = Integer.parseInt(txtId.getText());

          boolean isUpdated = customerRepository.updateCustomer(
                new Customer(
                   id,
                   txtName.getText(),
                   txtAddress.getText(),
                   txtMobile.getText()
           ));

          if (isUpdated){
              new Alert(Alert.AlertType.CONFIRMATION,"Customer Updated!").show();
          }

       } catch (NumberFormatException | IOException e) {
           throw new RuntimeException(e);
       }

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

        int id = Integer.parseInt(txtId.getText());

//        Customer customer = customerModel.searchCustomer(id);


        try{
            customerRepository = new CustomerRepository();

            Customer customer = customerRepository.getCustomer(id);

            if (customer != null){

                txtId.setText(String.valueOf(customer.getId()));
                txtName.setText(customer.getName());
                txtAddress.setText(customer.getAddress());
                txtMobile.setText(String.valueOf(customer.getMoNumber()));

            }else{
                new Alert(Alert.AlertType.ERROR,"Customer not found!").show();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
