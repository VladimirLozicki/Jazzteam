package dao;

import model.Galaxy.Galaxy;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.transaction.Transactional;

import static utils.HibernateSessionFactoryUtil.getSessionFactory;

public class DaoGalaxy {

    @Transactional
    public Galaxy findById(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Galaxy galaxy = session.get(Galaxy.class, id);
        transaction.commit();
        session.close();
        return galaxy;
    }

    @Transactional
    public Galaxy save(Galaxy galaxy) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(galaxy);
        transaction.commit();
        session.close();
        return galaxy;
    }


    @Transactional
    public Galaxy delete(Galaxy galaxy) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(galaxy);
        transaction.commit();
        session.close();
        return galaxy;
    }

}