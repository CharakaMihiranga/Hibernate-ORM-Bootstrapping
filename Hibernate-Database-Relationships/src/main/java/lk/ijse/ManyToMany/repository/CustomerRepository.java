package lk.ijse.ManyToMany.repository;

//import entity.CustomerOld;
import lk.ijse.ManyToMany.config.SessionFactoryConfig;
import lk.ijse.ManyToMany.entity.Customer;
import lk.ijse.ManyToMany.entity.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

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
            e.printStackTrace();    ///apu error eka balaganna
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

    public List<Customer> getAllCustomer(){
        String sql="SELECT * FROM customer";
        NativeQuery query=session.createSQLQuery(sql);
        List<Customer> list=query.list();
        for (Customer customer:list){
            System.out.println(customer);
        }
        session.close();
        return list;
    }

    //Using JPQL Query
    public List<Customer> getAllCustomerJPQL() {
        String sql = "SELECT C FROM Customer AS C";
        Query query = session.createQuery(sql);
        List<Customer> list = query.list();
        session.close();
        return list;
    }


    //Using Native SQL Query
    public List<Object[]> getAllCustomerNative() {
        String sql = "SELECT * FROM customer";
        NativeQuery query = session.createSQLQuery(sql);
        List<Object[]> list = query.list();
        for (Object customer : list) {
            System.out.println(customer);
        }
        session.close();
        return list;
    }


//    public List<Customer> getAllCustomerJPQL() {
//        String sql = "SELECT C FROM Customer AS C";
//        Query query = session.createQuery(sql);
//        List<Customer> list = query.list();
//        session.close();
//        return list;
//    }

    //Join query with where clause
    public List<Order> getOrdersByCustomerID(int cusId) {

        String sql = "SELECT O FROM Order AS O\n " +
                "INNER JOIN Customer AS C ON O.customer.id = C.id\n" +
                " WHERE O.customer.id = :cus_id ";

        Query query = session.createQuery(sql);
        query.setParameter("cus_id", cusId);
        List list = query.list();
        session.close();
        return list;

        //you can return order type -->
//
//        List<Order> orderList = query.list();
//        session.close();
//        return orderList;
    }

        //get Customer using HQL Queries
        public List<Customer> getCustomerHQL(){

            String sql = "FROM Customer";
            Query query = session.createQuery(sql);
            List<Customer> list = query.list();
            session.close();
            return list;

    }


}
