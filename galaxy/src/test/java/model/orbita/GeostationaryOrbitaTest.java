package model.orbita;

import junit.framework.Assert;
import model.planet.Planet;
import model.planet.Sattelite;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class GeostationaryOrbitaTest {

    @Test
    public void testGoOutOnOrbita() {
        Sattelite sattelite = new Sattelite(6.5, "Moon");
        Planet planet = new Planet(10000, 100, "Kepler748b");
        GeostationaryOrbita geostationaryOrbita =
                new GeostationaryOrbita.GeostationaryBuilder(planet, sattelite).build();
        int actual = (int) geostationaryOrbita.heightOrbita();
        int expected = (int) geostationaryOrbita.heightRise();
        assertEquals(actual, expected);
    }


    @Test
    public void testNotOutOnOrbita() {
        Sattelite sattelite = new Sattelite(3.5, "Gf893");
        Planet planet = new Planet(10000, 100, "Kepler748b");
        GeostationaryOrbita geostationaryOrbita = new GeostationaryOrbita.GeostationaryBuilder(planet, sattelite).build();
        assertFalse(geostationaryOrbita.heightRise() > geostationaryOrbita.heightOrbita());
    }


    @Test
    public void testBeyondLimitsOrbita() {
        assertTrue(getOrbita().heightRise() > getOrbita().heightOrbita());
    }

    @Test
    public void testHeightRise() {
        Assert.assertEquals(getOrbita().heightRise(), 50.0);
    }

    public GeostationaryOrbita getOrbita() {
        Sattelite sattelite = new Sattelite(10, "Kepler6782");
        Planet planet = new Planet(10000, 100, "Kepler748b");
        GeostationaryOrbita geostationaryOrbita =
                new GeostationaryOrbita.GeostationaryBuilder(planet, sattelite).build();
        return geostationaryOrbita;
    }

}
