package lk.ijse.ManyToMany.HibernateLifecycle;

import lk.ijse.ManyToMany.config.SessionFactoryConfig;
import lk.ijse.ManyToMany.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersistantState{
    public static void main(String[] args) {

        Session session = SessionFactoryConfig
                .getInstance()
                .getSession();

        //transient
        Customer customer = new Customer();
        customer.setId(7);
        customer.setName("Abc");
        customer.setAddress("Colombo");

        boolean contains = session.contains(customer);

        if (contains){
            System.out.println("This object is Persistant");
        }else{
            System.out.println("This object is Transient");
        }

        //Persistant State

        Transaction transaction = session.beginTransaction();

        int cusId = (int) session.save(customer);

        transaction.commit();

        System.out.println("Cus_id : "+ cusId);

        boolean isPersistant = session.contains(customer);

        if (isPersistant){
            System.out.println("This object is in Persistant state");
        }else{
            System.out.println("This object is not in Persistant state");
        }

        session.close();
    }
}
