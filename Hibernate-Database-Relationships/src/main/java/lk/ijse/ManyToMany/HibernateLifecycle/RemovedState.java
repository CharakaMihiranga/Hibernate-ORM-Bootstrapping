package lk.ijse.ManyToMany.HibernateLifecycle;

import lk.ijse.ManyToMany.config.SessionFactoryConfig;
import lk.ijse.ManyToMany.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RemovedState {
    public static void main(String[] args) {

        Session session = SessionFactoryConfig
                .getInstance()
                .getSession();

        Customer customer = session.get(Customer.class,1);
        boolean isContains = session.contains(customer);
        extracted(isContains);

        Transaction transaction = session.beginTransaction();

        session.delete(customer);

        transaction.commit();

        boolean contains = session.contains(customer);
        extracted(contains);
    }

    private static void extracted(boolean isContains) {

        if (isContains){
            System.out.println("Customer is in persistant state");
        }else {
            System.out.println("Customer is in removed state");
        }
    }
}
