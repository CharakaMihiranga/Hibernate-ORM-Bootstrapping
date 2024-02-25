package lk.ijse.ManyToMany.HibernateLifecycle;

import lk.ijse.ManyToMany.config.SessionFactoryConfig;

import lk.ijse.ManyToMany.entity.Customer;
import org.hibernate.Session;

public class TransientState {
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
    }
}
