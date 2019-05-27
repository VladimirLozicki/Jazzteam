package model.planet;

import model.orbita.Gravity;
import org.testng.annotations.Test;

public class GravityTest {
    @Test
    public void testGravity() {
        Sattelite sattelite = new Sattelite(178.0);
        Planet planet = new Planet(16965, 10000.0, 4.0, "Kepler748b", 5.8,
                22.1);
        Gravity gravity = new Gravity(planet,sattelite);
        System.out.println(gravity.gravitation());
    }

}