package lk.ijse.ManyToMany;

import lk.ijse.ManyToMany.embedd.Name_Identifier;
//import entity.CustomerOld;
import lk.ijse.ManyToMany.entity.Customer;
import lk.ijse.ManyToMany.repository.CustomerRepository;
import lk.ijse.OneToMany.config.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppIntializer {
    public static void main(String[] args) {

        try{

            CustomerRepository customerRepository=new CustomerRepository();
            customerRepository.saveCustomer(new Customer(1, "Charaka", "Deniyaya"));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}