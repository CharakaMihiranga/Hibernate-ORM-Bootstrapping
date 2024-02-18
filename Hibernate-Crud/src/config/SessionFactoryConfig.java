package config;

import com.sun.xml.bind.api.impl.NameConverter;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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


        // 02/18 -- > Create a sessionFactory using Configuration

        sessionFactory = new MetadataSources(
                new StandardServiceRegistryBuilder()
                        .configure()
                        .build())
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .build()
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
