package dao;


import model.orbit.Orbit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import utils.HibernateSessionFactoryUtil;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public class DaoOrbit {
    @Autowired
    private SessionFactory sessionFactory;

    public Orbit findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Orbit.class, id);
    }

    @Transactional
    public Orbit create(Orbit planet) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(planet);
        transaction.commit();
        session.close();
        return planet;
    }

    public Orbit save(Orbit planet) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(planet);
        transaction.commit();
        session.close();
        return planet;
    }


    public Orbit update(Orbit planet) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(planet);
        transaction.commit();
        session.close();
        return planet;
    }


    public Orbit delete(Orbit planet) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(planet);
        transaction.commit();
        session.close();
        return planet;
    }


}
