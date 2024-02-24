package lk.ijse.ManyToMany.config;

import lk.ijse.ManyToMany.entity.Customer;
//import entity.CustomerOld;
import lk.ijse.ManyToMany.entity.Item;
import lk.ijse.ManyToMany.entity.Order;
import lk.ijse.ManyToMany.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {
    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;
    private SessionFactoryConfig(){
        /*//1. Creates a Service Registry
        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder().configure().build();

        //2.
        Metadata metadata=new MetadataSources(serviceRegistry)
                .addAnnotatedClass(CustomerOld.class)
                .getMetadataBuilder().build();

        //3.Create a Session Factory
        sessionFactory = metadata.buildSessionFactory();*/

        //1. Creates a Service Registry
//        StandardServiceRegistry serviceRegistry =
//                new StandardServiceRegistryBuilder().configure().build();

        //2.
        //Metadata metadata=new MetadataSources( new StandardServiceRegistryBuilder().configure().build())
                //.addAnnotatedClass(CustomerOld.class)
               // .getMetadataBuilder().build();

        //3.Create a Session Factory
//        sessionFactory = new MetadataSources( new StandardServiceRegistryBuilder().configure().build())
//                .addAnnotatedClass(CustomerOld.class)
//                .getMetadataBuilder().build().buildSessionFactory();

        sessionFactory=new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(OrderDetail.class)
                .buildSessionFactory();

    }
    public static SessionFactoryConfig getInstance(){
        /*if (null == factoryConfig){
            return factoryConfig=new SessionFactoryConfig();
        }
        else {
            return factoryConfig;
        }*/
        return (factoryConfig == null) ? factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }
    public Session getSession(){


        //Create and Open the Session
        return sessionFactory.openSession();

    }
}
