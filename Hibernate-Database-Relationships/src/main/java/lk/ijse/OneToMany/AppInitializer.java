package lk.ijse.OneToMany;


import lk.ijse.OneToMany.config.SessionFactoryConfig;
import lk.ijse.OneToMany.entity.CustomerOneToMany;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AppInitializer {

    public static void main(String[] args) {

        try {

            //Save

            System.out.println("------------------Save-------------------------");
            Session session = SessionFactoryConfig
                    .getInstance()
                    .getSession();

            Transaction transaction = session.beginTransaction();

            CustomerOneToMany customer = new CustomerOneToMany();

            customer.setId(1);
            customer.setName("Charaka V Mihiranga");
            customer.setAddress("Colombo");

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
//            CustomerOld existingCustomer =
//                    getSession
//                            .get(CustomerOld.class,1);
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
//            CustomerOld existingCus = updateSession.get(CustomerOld.class,1);
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
//            CustomerOld deleteCus = deleteSession.get(CustomerOld.class,1);
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