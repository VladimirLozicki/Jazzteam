package model;

import model.massiveastronomicalobject.MassiveAstronomicalObject;
import model.orbit.Galaxy;
import model.orbit.Orbit;
import model.planet.Planet;
import org.testng.annotations.Test;
import services.ServiceOrbit;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class GalaxyTest {

    Galaxy galaxy = new Galaxy();

    @Test
    public void testSave() {
        ArrayList<Orbit> orbits = new ArrayList<>();
        Galaxy galaxy = new Galaxy();
        Planet planet = new Planet(1.0, 2.9, "name");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .build1();
        orbits.add(orbit);
        galaxy.setOrbit(orbits);
        ServiceOrbit service = new ServiceOrbit();
        service.save(galaxy);
    }

    @Test
    public void testToBumpInto() {
        ArrayList<Orbit> orbits = new ArrayList<>();
        Planet planet = new Planet(30, 2.9, "name");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .height(2)
                .build1();

        Orbit orbit2 = new Orbit.Builder()
                .planet(planet)
                .height(0)
                .build1();

        Orbit orbit1 = new Orbit.Builder().height(100).build1();
        orbits.add(orbit);
        orbits.add(orbit2);
        orbits.add(orbit1);
        MassiveAstronomicalObject massiveAstronomicalObject = new MassiveAstronomicalObject(100.0);
        galaxy.setMassiveAstronomicalObject(massiveAstronomicalObject);
        galaxy.setOrbit(orbits);
        assertEquals(galaxy.getMassiveAstronomicalObject().getWeight(), 130.0);
    }
}