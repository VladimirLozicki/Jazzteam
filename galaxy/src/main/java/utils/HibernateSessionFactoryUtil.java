package utils;

import model.orbita.Orbit;
import model.planet.Satellite;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration1 = new Configuration().configure();
                configuration1.addAnnotatedClass(Orbit.class);
                StandardServiceRegistryBuilder builder1 = new StandardServiceRegistryBuilder().applySettings(configuration1.getProperties());
                sessionFactory = configuration1.buildSessionFactory(builder1.build());
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}