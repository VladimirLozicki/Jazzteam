package dao;

import model.orbit.Galaxy;
import model.orbit.Orbit;
import model.planet.Planet;
import org.testng.annotations.Test;
import services.ServiceGalaxy;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class DaoOrbitTest {

    @Test
    public void testCreate() {
        ArrayList<Orbit> orbits = new ArrayList<>();
        Galaxy galaxy = new Galaxy();
        Planet planet = new Planet(1.0, 2.9, "kepler");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .height(1000)
                .build1();
        orbits.add(orbit);
        galaxy.setOrbit(orbits);
        ServiceGalaxy service = new ServiceGalaxy();
        service.create(galaxy);
        assertNotNull(service.find(1));
        service.delete(galaxy);
    }

    @Test
    public void testUpdate() {
        Galaxy galaxy = new Galaxy();
        ServiceGalaxy service = new ServiceGalaxy();
        service.save(galaxy);
       assertNotEquals(galaxy, service.find(1));
       service.delete(galaxy);
    }
}