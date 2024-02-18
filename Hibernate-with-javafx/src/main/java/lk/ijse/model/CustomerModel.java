package lk.ijse.model;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class CustomerModel {


    public void saveCustomer(Customer customer) {
        try {
            Session session = SessionFactoryConfig
                    .getInstance()
                    .getSession();

            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            session.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCustomer(int id,Customer customer) {

        try {


            Session updateSession =
                    SessionFactoryConfig
                            .getInstance().getSession();

            Customer existingCus = updateSession.get(Customer.class,id);

            Transaction updateTransaction =
                    updateSession.beginTransaction();

            existingCus.setName(customer.getName());
            existingCus.setAddress(customer.getAddress());
            existingCus.setMoNumber(customer.getMoNumber());

           updateSession.update(existingCus);

           updateTransaction.commit();

           updateSession.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer searchCustomer(int id){
        try {

            Session getSession = SessionFactoryConfig
                    .getInstance().getSession();

            Customer existingCustomer =
                    getSession
                            .get(Customer.class,id);


            if (existingCustomer != null){
                return existingCustomer;
            }else {
                getSession.close();
            }
            return null;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteCustomer(int id ){
       try {
           Session deleteSession =
                   SessionFactoryConfig.getInstance().getSession();

           Transaction deleteTransaction = deleteSession
                   .beginTransaction();

           Customer deleteCus = deleteSession.get(Customer.class,id);

           deleteSession.delete(deleteCus);

           deleteTransaction.commit();

           deleteSession.close();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
        return false;
    }
}