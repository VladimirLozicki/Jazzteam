package dao;

import model.Galaxy.Galaxy;
import model.orbit.Orbit;
import model.planet.Planet;
import org.hibernate.Session;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.ServiceGalaxy;

import java.util.ArrayList;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static utils.HibernateSessionFactoryUtil.getSessionFactory;

public class DaoGalaxyTest {
    private Galaxy galaxy = new Galaxy();
    private ArrayList<Orbit> orbits = new ArrayList<>();
    private ServiceGalaxy service = new ServiceGalaxy();

    @Test
    public void testSave() {
        getSystem();
        service.save(galaxy);
        Galaxy newGalaxy = service.find(getMaxId());
        assertNotEquals(galaxy, newGalaxy);
    }

    @Test
    public void testUpdate() {
        service.save(galaxy);
        assertNotEquals(galaxy, service.find(getMaxId()));
    }

    @AfterMethod
    public void delete() {
        orbits.clear();
        service.delete(galaxy);
    }

    @BeforeMethod
    public void deleteBD() {
        Session session = getSessionFactory().openSession();
        session.createSQLQuery("DELETE TABLE galaxy");
        session.close();
    }

    private int getMaxId() {
        Session session = getSessionFactory().openSession();
        int id = (int) session.createSQLQuery("select max(id) from galaxy")
                .uniqueResult();
        session.close();
        return id;
    }

    private void getSystem() {
        Planet planet = new Planet(1.0, 2.9, "kepler");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .height(1000)
                .build();
        orbits.add(orbit);
        galaxy.setOrbits(orbits);
    }
}