package dao;

import model.planet.Satellite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import utils.HibernateSessionFactoryUtil;

public class DaoSattelite {

    @Autowired
    private SessionFactory sessionFactory;

    public Satellite findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Satellite.class, id);
    }
    public Satellite create(Satellite satellite) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(satellite);
        transaction.commit();
        session.close();
        return satellite;
    }

    public Satellite save(Satellite satellite) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(satellite);
        transaction.commit();
        session.close();
        return satellite;
    }


    public Satellite update(Satellite satellite) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(satellite);
        transaction.commit();
        session.close();
        return satellite;
    }


    public Satellite delete(Satellite satellite) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(satellite);
        transaction.commit();
        session.close();
        return satellite;
    }

}