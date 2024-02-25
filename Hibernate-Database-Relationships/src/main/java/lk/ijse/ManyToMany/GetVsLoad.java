package lk.ijse.ManyToMany;

import lk.ijse.ManyToMany.config.SessionFactoryConfig;
import lk.ijse.ManyToMany.entity.Customer;
import org.hibernate.Session;

public class GetVsLoad {
    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();

        Customer customer = new Customer();

        customer.setName("Deshan");
        customer.setAddress("Nakiyadeniya");
        session.save(customer);
        session.close();

        // 1.Get

        Session getSession = SessionFactoryConfig.getInstance().getSession();
        System.out.println("------------ GET ----------------");
        Customer getCustomer = getSession.get(Customer.class, 1);
        System.out.println("Customer Id of Get: " + getCustomer.getId());
        System.out.println("Customer Name of Get :"+getCustomer.getName());
        getSession.close();


        //Load
        Session loadsession= SessionFactoryConfig.getInstance().getSession();
        System.out.println("------LOAD------");
        Customer loadCustomer = loadsession.load(Customer.class, 1);
        System.out.println("Customer Id of get :"+loadCustomer.getId());
        System.out.println("Customer name of get :"+ loadCustomer.getName());
        loadsession.close();
    }
}
