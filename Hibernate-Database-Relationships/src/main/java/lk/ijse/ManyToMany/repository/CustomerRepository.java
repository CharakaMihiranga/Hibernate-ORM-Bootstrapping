package lk.ijse.ManyToMany.repository;

import lk.ijse.ManyToMany.config.SessionFactoryConfig;
import lk.ijse.ManyToMany.entity.Customer;
//import entity.CustomerOld;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerRepository {
    private final  Session session;

    public CustomerRepository(){
        session= SessionFactoryConfig.getInstance().getSession();
    }

    public int saveCustomer(Customer customer){
        Transaction transaction=session.beginTransaction();
        try {

            int customerId = (int) session.save(customer);
            transaction.commit();
            session.close();
            return customerId;

        } catch (HibernateException e) {
          transaction.rollback();
          session.close();
          e.printStackTrace();
            return -1;
        }
    }

    //search
    public Customer getCustomer(int id){
        try {
            Customer customer=session.get(Customer.class,id);
            session.close();
            return customer;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw e;
        }

    }


    public boolean updateCustomer(Customer customer){
        Transaction transaction=session.beginTransaction();
        try {
            session.update(customer);
            transaction.commit();
            session.close();

            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean deleteCustomer(Customer customer){
        Transaction transaction= session.beginTransaction();
        try {
            session.delete(customer);
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
