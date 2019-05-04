package DAO;

import model.planet.Sattelite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class DAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Sattelite create(Sattelite sattelite) {
        Session session=sessionFactory.getCurrentSession();
        session.getSessionFactory();
        session.save(sattelite);
        session.flush();
        return sattelite;
    }

    public Sattelite update(Sattelite sattelite ){
        sessionFactory.getCurrentSession().update(sattelite);
        return sattelite;
    }
    public Sattelite delete(Sattelite sattelite){
        sessionFactory.getCurrentSession().delete(sattelite);
        sessionFactory.getCurrentSession().flush();
        return sattelite;
    }
    public Sattelite find(Sattelite sattelite ){
        sessionFactory.getCurrentSession().find(Sattelite.class, sattelite);
        sessionFactory.getCurrentSession().flush();
        return sattelite;
    }
}
