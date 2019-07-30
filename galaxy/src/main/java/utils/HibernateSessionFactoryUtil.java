package utils;

import model.galaxy.Galaxy;
import model.massiveastronomicalobject.MassiveAstronomicalObject;
import model.orbit.Orbit;
import model.planet.Planet;
import org.hibernate.HibernateException;
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
                configuration
                        .addAnnotatedClass(Orbit.class)
                        .addAnnotatedClass(Planet.class)
                        .addAnnotatedClass(MassiveAstronomicalObject.class)
                        .addAnnotatedClass(Galaxy.class);
                StandardServiceRegistryBuilder builder1 = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder1.build());

            } catch (HibernateException e) {
                e.getMessage();
            }
        }
        return sessionFactory;
    }

}