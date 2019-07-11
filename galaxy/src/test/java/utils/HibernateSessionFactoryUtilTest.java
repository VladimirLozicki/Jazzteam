package utils;

import model.orbit.Galaxy;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HibernateSessionFactoryUtilTest {
    private static SessionFactory sessionFactory;

//
//    @Test
//    public  void testHibernate(){
//      assertNotNull(get());
//    }
//
//    public SessionFactory get(){
//        Configuration configuration = new Configuration().configure();
//        configuration.addAnnotatedClass(Galaxy.class);
//        StandardServiceRegistryBuilder builder1 = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties());
//        sessionFactory = configuration.buildSessionFactory(builder1.build());
//        return sessionFactory;
//    }
}