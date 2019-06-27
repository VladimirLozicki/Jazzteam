package model;

import com.sun.tools.javac.util.List;
import model.orbit.Galaxy;
import model.orbit.Orbit;
import model.planet.Planet;
import model.planet.Satellite;
import org.testng.annotations.Test;
import services.ServiceOrbit;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class GalaxyTest {

    @Test
    public void testGetId() {
        ArrayList<Orbit> orbits = new ArrayList<>();
        Galaxy galaxy = new Galaxy();
        Planet planet = new Planet();
        Satellite satellite = new Satellite("kepler");
        Orbit orbit = new Orbit.Builder()
                .satellite(satellite)
                .planet(planet)
                .height(1000)
                .build1();

        orbits.add(orbit);
        galaxy.setOrbit(orbits);
        ServiceOrbit service = new ServiceOrbit();
        service.create(galaxy);
    }
}