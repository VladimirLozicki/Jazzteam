package dao;

import model.galaxy.Galaxy;
import model.orbit.Orbit;
import model.planet.Planet;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.ServiceGalaxy;

import java.util.ArrayList;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static utils.HibernateSessionFactoryUtil.getSessionFactory;

@ContextConfiguration(locations = {"classpath:beans.xml"})
public class DaoGalaxyTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ServiceGalaxy serviceGalaxy;

    private ArrayList<Orbit> orbits = new ArrayList<>();

    @BeforeMethod
    public void saveGalaxy() {
        serviceGalaxy.save(getSystem());
    }

    @Test
    public void testSave() {
        assertNotNull(serviceGalaxy.find(getMaxId()));
    }

    @Test
    public void testFindById() {
        assertNotSame(getSystem(),serviceGalaxy.find(getMaxId()));
    }

    @AfterMethod
    public void delete() {
        orbits.clear();
        serviceGalaxy.delete(getSystem());
    }

    private Galaxy getSystem() {
        Galaxy galaxy = new Galaxy();
        Planet planet = new Planet(1.0, 2.9, "kepler");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .height(1000)
                .build();
        orbits.add(orbit);
        galaxy.setOrbits(orbits);
        return galaxy;
    }

    private int getMaxId() {
        Session session = getSessionFactory().openSession();
        int id = (int) session.createSQLQuery("select max(id) from galaxy")
                .uniqueResult();
        session.close();
        return id;
    }
}