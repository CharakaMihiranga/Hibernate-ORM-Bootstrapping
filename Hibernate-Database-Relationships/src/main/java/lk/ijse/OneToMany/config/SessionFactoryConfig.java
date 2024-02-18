package lk.ijse.OneToMany.config;

import lk.ijse.OneToMany.entity.CustomerOneToMany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {
    private static SessionFactoryConfig factoryConfig;
    private static SessionFactory sessionFactory;

    private SessionFactoryConfig(){

//        //create Session factory through native bootstrapping
//
//
//        //1.create a service registry
//        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .configure()
//                .build();
//
//        //2. Creates a Metadata Object
//        Metadata metadata = new MetadataSources(serviceRegistry)
//                .addAnnotatedClass(Customer.class)
//                .getMetadataBuilder()
//                .build();
//
//        //3. Creates a Session Factory
//
//        sessionFactory = metadata.buildSessionFactory();


//        // Simple way to create session factory object
//        sessionFactory = new MetadataSources(
//                new StandardServiceRegistryBuilder()
//                        .configure()
//                        .build())
//                .addAnnotatedClass(Customer.class)
//                .getMetadataBuilder()
//                .build()
//                .buildSessionFactory();

        // 02/18 -- > Create a sessionFactory using Configuration

         sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(CustomerOneToMany.class)
                .buildSessionFactory();

    }

    public static SessionFactoryConfig getInstance(){

//        if (null == factoryConfig){
//            factoryConfig = new SessionFactoryConfig();
//            return factoryConfig;
//        } else {
//            return factoryConfig;
//        }

        return (null == factoryConfig)
                ? factoryConfig = new SessionFactoryConfig()
                : factoryConfig;
    }

    public Session getSession(){

       //Return the session
        return sessionFactory.openSession();

    }

}
