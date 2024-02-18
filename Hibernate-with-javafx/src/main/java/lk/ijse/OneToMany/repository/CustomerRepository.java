package lk.ijse.OneToMany.repository;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class CustomerRepository {
    private final Session session;
    public CustomerRepository() throws IOException {
        session = SessionFactoryConfig
                .getInstance()
                .getSession();
    }

    public int saveCustomer(Customer customer){

        Transaction transaction = session.beginTransaction();

        try{

            int customerID = (int) session.save(customer);

            transaction.commit();

            session.close();

            return customerID;

        } catch (HibernateException e) {

           transaction.rollback();
           session.close();
           e.printStackTrace();

        }
        return (-1);
    }

    public Customer getCustomer(int id){

        try {

            Customer customer = session.get(Customer.class,id);

            session.close();

            return customer;

        } catch (Exception e) {
            session.close();
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateCustomer(Customer customer){

        Transaction transaction = session.beginTransaction();

        try{

            session.update(customer);
            transaction.commit();
            session.close();

            return true;

        } catch (Exception e) {

            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;

        }
    }
    public boolean deleteCustomer(Customer cutomer){

        Transaction transaction = session.beginTransaction();

        try{

            session.delete(cutomer);
            transaction.commit();
            session.close();
            return true;

        } catch (Exception e) {
           transaction.rollback();
           session.close();
           e.printStackTrace();
           return false;
        }
    }
}
