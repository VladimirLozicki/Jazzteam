package utils;

import model.orbit.Orbit;
import model.planet.Planet;
import model.planet.Satellite;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Orbit.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

//                Configuration configuration1 = new Configuration().configure();
//                configuration1.addAnnotatedClass(Planet.class);
//                StandardServiceRegistryBuilder builder1 = new StandardServiceRegistryBuilder().applySettings(configuration1.getProperties());
//                sessionFactory = configuration1.buildSessionFactory(builder1.build());

//
//                Configuration configuration3 = new Configuration().configure();
//                configuration3.addAnnotatedClass(Satellite.class);
//                StandardServiceRegistryBuilder builder3 = new StandardServiceRegistryBuilder().applySettings(configuration3.getProperties());
//                sessionFactory = configuration3.buildSessionFactory(builder3.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }

}