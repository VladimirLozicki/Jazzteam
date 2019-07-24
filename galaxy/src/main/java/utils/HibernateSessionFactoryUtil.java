package utils;

import model.massiveAstronomicalObject.MassiveAstronomicalObject;
import model.orbit.Galaxy;
import model.orbit.Orbit;
import model.planet.Planet;
import model.planet.Satellite;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateSessionFactoryUtil {
    private    static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static  SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration
                        .addAnnotatedClass(Orbit.class)
                        .addAnnotatedClass(Planet.class)
                        .addAnnotatedClass(Satellite.class)
                        .addAnnotatedClass(MassiveAstronomicalObject.class)
                        .addAnnotatedClass(Galaxy.class);
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