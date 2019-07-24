package model;

import model.massiveAstronomicalObject.MassiveAstronomicalObject;
import model.orbit.Galaxy;
import model.orbit.Orbit;
import model.planet.Planet;
import org.testng.annotations.Test;
import services.ServiceGalaxy;

import java.util.ArrayList;
import static org.testng.Assert.*;

public class GalaxyTest {

    Galaxy galaxy = new Galaxy();
    ArrayList<Orbit> orbits = new ArrayList<>();
    ServiceGalaxy serviceGalaxy = new ServiceGalaxy();
    @Test
    public void testSave() {
        Galaxy galaxy1 = new Galaxy();
        Planet planet = new Planet(1.0, 2.9, "name");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .build1();
        orbits.add(orbit);
        Orbit orbit1 = new Orbit.Builder()
                .acceleration(1)
                .build1();
        orbits.add(orbit1);
        galaxy1.setOrbit(orbits);
        MassiveAstronomicalObject massiveAstronomicalObject = new MassiveAstronomicalObject();
        galaxy1.setMassiveAstronomicalObject(massiveAstronomicalObject);

        serviceGalaxy.save(galaxy1);
        Galaxy newGalaxy = serviceGalaxy.find(132);
        assertNotEquals(galaxy1, newGalaxy);
        serviceGalaxy.delete(galaxy1);
    }


    @Test
    public void testGetWay() {
        assertEquals(getSystem().getOrbit().get(0).getPlanet().getVelocity() * 5, 500.0);
    }

    private Galaxy getSystem() {
        Galaxy galaxy = new Galaxy();
        MassiveAstronomicalObject massiveAstronomicalObject =
                new MassiveAstronomicalObject(100.0, 10.0);
        ArrayList<Orbit> orbits = new ArrayList<>();
        Planet planet = new Planet(687500.0, 100.0, "Kepler48b");
        planet.setVelocity(100);
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .height(1000)
                .build1();
        orbits.add(orbit);
        galaxy.setOrbit(orbits);
        galaxy.setMassiveAstronomicalObject(massiveAstronomicalObject);
        return galaxy;
    }
}