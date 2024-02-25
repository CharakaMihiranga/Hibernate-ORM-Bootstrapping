package lk.ijse.ManyToMany;

import lk.ijse.ManyToMany.embedd.Name_Identifier;
//import entity.CustomerOld;
import lk.ijse.ManyToMany.entity.Customer;
import lk.ijse.ManyToMany.entity.Order;
import lk.ijse.ManyToMany.repository.CustomerRepository;
import lk.ijse.OneToMany.config.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AppIntializer {
    public static void main(String[] args) {


        //save customer
        /*Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        MobileNumber homeNumber=new MobileNumber();
        homeNumber.setTyp("home");
        homeNumber.setMobileNo("0416547654");

        MobileNumber handPhoneNumber=new MobileNumber();
        handPhoneNumber.setTyp("handPhone");
        handPhoneNumber.setMobileNo("0786547654");
        CustomerOld customer = getCustomer();

        List<MobileNumber> mobileNumbers=new ArrayList<>();
        mobileNumbers.add(handPhoneNumber);
        mobileNumbers.add(homeNumber);

        customer.setMobile(mobileNumbers);

        session.save(customer);
        transaction.commit();
        session.close();*/



//        CustomerRepository customerRepository=new CustomerRepository();
//        customerRepository.saveCustomer(new Customer(1, "Mahinda", "Madamulana"));
//


        //view
//        Session getSession = SessionFactoryConfig.getInstance().getSession();
//        CustomerOld existingCustomer = getSession.get(CustomerOld.class, 1);
//        System.out.println(existingCustomer);
//        getSession.close();


       /* CustomerRepository customerRepository=new CustomerRepository();
         ///get kiyanne search(meka)
        System.out.println( customerRepository.getCustomer(1));*/



        //delete CustomerOld

//        Session deleteSession=SessionFactoryConfig
//                .getInstance().getSession();
//        Transaction deletetransaction=deleteSession.beginTransaction();
//        CustomerOld deleteCustomer=deleteSession.get(CustomerOld.class,1);
//        System.out.println("delete"+deleteCustomer);
//        deleteSession.delete(deleteCustomer);
//        deletetransaction.commit();
//        deleteSession.close();

//        customerRepository=new CustomerRepository();
//        CustomerOld customer=customerRepository.getCustomer(1);
//        customer.setAddress("matale");
//        customerRepository.updateCustomer(customer);



       /* CustomerRepository get = new CustomerRepository();
        CustomerRepository delete = new CustomerRepository();
        CustomerOld customer = get.getCustomer(1);
        delete.deleteCustomer(customer);*/



        //update
//        Session updateSession = SessionFactoryConfig.getInstance().getSession();
//        CustomerOld customer1 = updateSession.get(CustomerOld.class, 001);
//        System.out.println("Existing CustomerOld : "+customer);
//        Transaction updateTransaction = updateSession.beginTransaction();
//        customer.setAddress("Colombo");
//        updateTransaction.commit();
//        updateSession.update(customer1);
//        System.out.println("Updated CustomerOld : "+customer);
//        updateSession.close();



       /* CustomerRepository customerRepository = new CustomerRepository();

        //update
        CustomerRepository customerRepository1 = new CustomerRepository();
        CustomerOld customer = customerRepository.getCustomer(1);
        customer.setAddress("Calton Niwasa");
        customerRepository1.updateCustomer(customer);*/


//
//        CustomerRepository customerRepository = new CustomerRepository();
//        customerRepository.getAllCustomerNative();
//
//        customerRepository = new CustomerRepository();
//        List<Customer> allCustomerJPQL = customerRepository.getAllCustomerJPQL();
//        for (Customer customer : allCustomerJPQL) {
//            System.out.println(customer);
//        }

//        //get Orders by cus_id
//
//        CustomerRepository customerRepository = new CustomerRepository();
//        List<Order> orderList = customerRepository.getOrdersByCustomerID(1);
//
//        for ( Order order : orderList) {
//
//            System.out.println(order);
//
//        }



        //get all Customers using HQL Queries
        CustomerRepository customerRepository = new CustomerRepository();
        List<Customer> customerHQL = customerRepository.getCustomerHQL();

        for (Customer customer : customerHQL){
            System.out.println(customer);
        }

    }
}