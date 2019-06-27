package dao;


import model.orbit.Galaxy;
import model.orbit.Orbit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import utils.HibernateSessionFactoryUtil;

import javax.transaction.Transactional;


public class DaoOrbit {
    @Autowired
    private SessionFactory sessionFactory;

    public Galaxy findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Galaxy.class, id);
    }

    @Transactional
    public Galaxy create(Galaxy orbit) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(orbit);
        transaction.commit();
        session.close();
        return orbit;
    }

    @Transactional
    public Galaxy save(Galaxy orbit) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(orbit);
        transaction.commit();
        session.close();
        return orbit;
    }

    @Transactional
    public Galaxy update(Galaxy orbit) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(orbit);
        transaction.commit();
        session.close();
        return orbit;
    }


    @Transactional
    public Galaxy delete(Galaxy orbit) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(orbit);
        transaction.commit();
        session.close();
        return orbit;
    }
}