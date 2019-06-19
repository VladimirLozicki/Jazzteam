package utils;

import com.fasterxml.classmate.AnnotationConfiguration;
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
                configuration.addAnnotatedClass(Planet.class)
                        .addAnnotatedClass(Orbit.class)
                        .addAnnotatedClass(Satellite.class);
                StandardServiceRegistryBuilder builder1 = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder1.build());

            } catch (Exception e) {
                e.getMessage();
            }
        }
        return sessionFactory;
    }

}