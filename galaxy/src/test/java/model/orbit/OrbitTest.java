package model.orbit;

import model.planet.Planet;
import org.testng.annotations.Test;

public class OrbitTest {

    @Test
    public void testAccelerationGravity() {
        Planet planet = new Planet(40000.0, 100.0, "Kepler48b");
        planet.setVelocity(10);
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .height(100)
                .build();
       // assertEquals(orbit.accelerationGravity(), 1.0);
    }
}