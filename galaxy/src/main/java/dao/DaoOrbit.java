package dao;


import com.sun.org.apache.xpath.internal.operations.Or;
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
    public Orbit create(Orbit orbit) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(orbit);
        transaction.commit();
        session.close();
        return orbit;
    }

    public Orbit save(Orbit orbit) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(orbit);
        transaction.commit();
        session.close();
        return orbit;
    }


    public Orbit update(Orbit orbit) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(orbit);
        transaction.commit();
        session.close();
        return orbit;
    }


    public Orbit delete(Orbit orbit) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(orbit);
        transaction.commit();
        session.close();
        return orbit;
    }

}
