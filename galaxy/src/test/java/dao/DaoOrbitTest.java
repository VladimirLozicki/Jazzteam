package dao;

import model.Galaxy;
import model.orbit.Orbit;
import model.planet.Planet;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import services.ServiceGalaxy;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class DaoOrbitTest {


    @Test
    @AfterMethod
    public void testCreate() {
        ArrayList<Orbit> orbits = new ArrayList<>();
        Galaxy galaxy = new Galaxy();
        Planet planet = new Planet(1.0, 2.9, "kepler");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .height(1000)
                .build();
        orbits.add(orbit);
        galaxy.setOrbits(orbits);
        ServiceGalaxy service = new ServiceGalaxy();
        service.save(galaxy);
        assertNotNull(service.find(186));
       // service.delete(galaxy);
    }

    @Test
    public void testUpdate() {
        Galaxy galaxy = new Galaxy();
        ServiceGalaxy service = new ServiceGalaxy();
        service.save(galaxy);
       assertNotEquals(galaxy, service.find(186));
       service.delete(galaxy);
    }
}