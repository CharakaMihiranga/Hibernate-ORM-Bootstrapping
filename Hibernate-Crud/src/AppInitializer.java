import config.SessionFactoryConfig;
import embedded.MobileNumber;
import embedded.NameIdentifier;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AppInitializer {

    public static void main(String[] args) {

        try {

            //Save

            System.out.println("------------------Save-------------------------");
            Session session = SessionFactoryConfig
                    .getInstance()
                    .getSession();

            Transaction transaction = session.beginTransaction();

            Customer customer = new Customer();

            customer.setId(1);

            NameIdentifier nameIdentifier = new NameIdentifier();

            nameIdentifier.setFirstName("Charaka");
            nameIdentifier.setMiddleName("V");
            nameIdentifier.setLastName("Mihiranga");

            customer.setName(nameIdentifier);
            customer.setAddress("Colombo");
            customer.setSalary(30000);

            MobileNumber mobileNumber = new MobileNumber();
            mobileNumber.setType("Mobile");
            mobileNumber.setMoNumber(715825704);

            MobileNumber homeNumber =  new MobileNumber();
            homeNumber.setType("Home");
            homeNumber.setMoNumber(1145585555);

            List<MobileNumber> mobileNumbers =  new ArrayList<>();
            mobileNumbers.add(mobileNumber);
            mobileNumbers.add(homeNumber);

            customer.setMobileNumbers(mobileNumbers);

            session.save(customer);

            transaction.commit();

            System.out.println("------------------Saved-------------------------");

            session.close();

//
//            //2 Get
//
//          System.out.println("------------------Read-------------------------");
//
//            Session getSession = SessionFactoryConfig
//                    .getInstance().getSession();
//
//            Customer existingCustomer =
//                    getSession
//                            .get(Customer.class,1);
//
//            System.out.println("Existing customer :"+existingCustomer);
//
//            System.out.println("------------------Read Completed-------------------------");
//
//            getSession.close();
//
//
//            //Update
//
//            System.out.println("------------------Update-------------------------");
//
//            Session updateSession =
//                    SessionFactoryConfig
//                            .getInstance().getSession();
//
//            Transaction updateTransaction =
//                    updateSession.beginTransaction();
//
//            Customer existingCus = updateSession.get(Customer.class,1);
//
//            existingCus.setAddress("Colombo");
//            updateSession.update(existingCus);
//
//            updateTransaction.commit();
//
//            System.out.println("------------------Updated-------------------------");
//
//            updateSession.close();
//
//
//            //Delete
//
//            System.out.println("------------------Delete-------------------------");
//
//            Session deleteSession =
//                    SessionFactoryConfig.getInstance().getSession();
//
//            Transaction deleteTransaction = deleteSession
//                    .beginTransaction();
//
//            Customer deleteCus = deleteSession.get(Customer.class,1);
//
//            deleteSession.delete(deleteCus);
//
//            deleteTransaction.commit();
//
//            System.out.println("------------------Deleted-------------------------");
//
//            deleteSession.close();



        } catch (Exception e) {

            e.printStackTrace();

            System.out.println("Error :"+ e.getMessage());

        }
    }
}