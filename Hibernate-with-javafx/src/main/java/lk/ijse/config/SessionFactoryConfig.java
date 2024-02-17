package lk.ijse.config;

import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;
    private static SessionFactory sessionFactory;

    private SessionFactoryConfig(){

        try{

            Properties properties = new Properties();
            InputStream inputStream = SessionFactoryConfig.class.getClassLoader().getResourceAsStream("hibernate.properties");
            properties.load(inputStream);

            Configuration configuration = new org.hibernate.cfg.Configuration();
            configuration.setProperties(properties);

            configuration.addAnnotatedClass(Customer.class);
            sessionFactory = configuration.buildSessionFactory();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static SessionFactoryConfig getInstance() throws IOException {
        return factoryConfig == null ? new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }

}
