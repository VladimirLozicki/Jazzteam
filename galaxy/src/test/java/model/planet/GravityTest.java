package model.planet;

import model.orbita.Gravity;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class GravityTest {
    @Test
    public void testGravity() {
        Sattelite sattelite = new Sattelite(2.23, 0.1);
        Planet planet = new Planet(10.0, 5.0, 4.0, "Kepler79858b", 5.8,
                22.1);
        Gravity gravity = new Gravity(planet,sattelite);
        int actual = (int)gravity.gravitationOnSurface();
        int expected = (int) gravity.gravitationPowerOnOrbita();
        assertEquals(actual, expected);
    }
}