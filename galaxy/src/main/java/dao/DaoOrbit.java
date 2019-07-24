package dao;


import model.orbit.Galaxy;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import utils.HibernateSessionFactoryUtil;

import javax.transaction.Transactional;

import static utils.HibernateSessionFactoryUtil.getSessionFactory;


public class DaoOrbit {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public Galaxy findById(int id) {
        Galaxy galaxy;
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        galaxy=session.get(Galaxy.class, id);
        transaction.commit();
        session.close();
        return galaxy;
    }

    @Transactional
    public Galaxy create(Galaxy galaxy) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(galaxy);
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

//    @Transactional
//    public Galaxy save(Galaxy galaxy) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        transaction.commit();
//        try {
//            session.save(galaxy);
//            transaction.commit();
//            session.flush();
//        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
//        }

//        Session session;
//        try {
//            session = getSessionFactory().getCurrentSession();
//        } catch (HibernateException ex) {
//            session = getSessionFactory().openSession();
//        }
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            session.save(galaxy);
//            transaction.commit();
//        } catch (HibernateException ex) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
//        }


//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(galaxy);
//        transaction.commit();
//        session.close();
     //   return galaxy;
  //  }


    @Transactional
    public Galaxy update(Galaxy galaxy) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(galaxy);
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