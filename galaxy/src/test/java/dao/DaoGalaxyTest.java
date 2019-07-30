package dao;

import model.galaxy.Galaxy;
import model.orbit.Orbit;
import model.planet.Planet;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import services.ServiceGalaxy;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static utils.HibernateSessionFactoryUtil.getSessionFactory;

@ContextConfiguration(locations = {"classpath:beans.xml"})
public class DaoGalaxyTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ServiceGalaxy serviceGalaxy;

    @Autowired
    private Galaxy galaxy;

    private ArrayList<Orbit> orbits = new ArrayList<>();

    @Test
    public void testSave() {
        serviceGalaxy.save(getSystem());
        assertNotEquals(galaxy, serviceGalaxy.find(getMaxId()));
    }

    @Test
    public void testFindById() {
        assertEquals(serviceGalaxy.find(getMaxId()).getId(), 911);
    }

    @AfterMethod
    public void delete() {
        orbits.clear();
        serviceGalaxy.delete(galaxy);
    }

    private int getMaxId() {
        Session session = getSessionFactory().openSession();
        int id = (int) session.createSQLQuery("select max(id) from galaxy")
                .uniqueResult();
        session.close();
        return id;
    }

    private Galaxy getSystem() {
        Planet planet = new Planet(1.0, 2.9, "kepler");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .height(1000)
                .build();
        orbits.add(orbit);
        galaxy.setOrbits(orbits);
        return galaxy;
    }
}