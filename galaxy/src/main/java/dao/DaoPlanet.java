package dao;

import model.planet.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import utils.HibernateSessionFactoryUtil;

import javax.transaction.Transactional;

public class DaoPlanet {
    @Autowired
    private SessionFactory sessionFactory;

    public Planet findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Planet.class, id);
    }

    @Transactional
    public Planet create(Planet planet) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(planet);
        transaction.commit();
        session.close();
        return planet;
    }

    public Planet save(Planet planet) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(planet);
        transaction.commit();
        session.close();
        return planet;
    }


    public Planet update(Planet planet) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(planet);
        transaction.commit();
        session.close();
        return planet;
    }


    public Planet delete(Planet planet) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(planet);
        transaction.commit();
        session.close();
        return planet;
    }
}