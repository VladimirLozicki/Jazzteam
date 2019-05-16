package DAO;

import model.planet.Sattelite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import utils.HibernateSessionFactoryUtil;

import javax.transaction.Transactional;

public class DAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Sattelite findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Sattelite.class, id);
    }

    @Transactional
    public Sattelite create(Sattelite sattelite) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(sattelite);
        transaction.commit();
        session.close();
        return sattelite;
    }

    public Sattelite save(Sattelite sattelite) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(sattelite);
        transaction.commit();
        session.close();
        return sattelite;
    }

    public void update(Sattelite sattelite) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(sattelite);
        transaction.commit();
        session.close();
    }

    public Sattelite delete(Sattelite sattelite) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(sattelite);
        transaction.commit();
        session.close();
        return sattelite;
    }

}