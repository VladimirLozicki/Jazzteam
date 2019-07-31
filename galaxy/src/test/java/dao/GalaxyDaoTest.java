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

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static utils.HibernateSessionFactoryUtil.getSessionFactory;

@ContextConfiguration(locations = {"classpath:beans.xml"})
public class GalaxyDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ServiceGalaxy serviceGalaxy;

    private ArrayList<Orbit> orbits = new ArrayList<>();

    @BeforeMethod
    public void saveGalaxy() {
        serviceGalaxy.save(getSystem());
    }

    @AfterMethod
    public void delete() {
        orbits.clear();
        serviceGalaxy.delete(serviceGalaxy.find(getMaxId()));
    }

    @Test
    public void testSave() {
        assertNotNull(serviceGalaxy.find(getMaxId()));
    }

    @Test
    public void testFindById() {
        assertEquals(serviceGalaxy.find(getMaxId()).getOrbits().get(0).getHeight(), 90.0);
    }

    private Galaxy getSystem() {
        Galaxy galaxy = new Galaxy();
        Planet planet = new Planet(1.0, 2.9, "kepler");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .height(90)
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