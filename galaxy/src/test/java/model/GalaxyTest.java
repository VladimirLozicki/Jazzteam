package model;
import model.orbit.Galaxy;
import model.orbit.Orbit;
import model.planet.Planet;
import model.planet.Satellite;
import org.testng.annotations.Test;
import services.ServiceOrbit;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class GalaxyTest {

    @Test
    public void testGetId() {
        ArrayList<Orbit> orbits= new ArrayList<>();
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
}