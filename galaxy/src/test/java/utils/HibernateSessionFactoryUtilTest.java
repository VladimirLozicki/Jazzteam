package utils;

import com.sun.istack.NotNull;
import dao.DaoOrbit;
import model.orbit.Orbit;
import model.planet.Planet;
import model.planet.Satellite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;
import services.ServiceOrbit;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;

import static org.testng.Assert.*;

public class HibernateSessionFactoryUtilTest {
    private static SessionFactory sessionFactory;


    @Test
    public  void testHibernate(){
      assertNotNull(get());
    }


    public SessionFactory get(){
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Planet.class);
        StandardServiceRegistryBuilder builder1 = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder1.build());
        return sessionFactory;
    }
}