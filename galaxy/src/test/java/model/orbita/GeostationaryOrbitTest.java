package model.orbita;

import junit.framework.Assert;
import model.planet.Planet;
import model.planet.Satellite;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class GeostationaryOrbitTest {


    @Test
    public void testGoOutOnOrbit() {
        Satellite satellite = new Satellite(6.5, "Moon");
        Planet planet = new Planet(10000, 100, "Kepler748b");
        GeostationaryOrbit geostationaryOrbita =
                new GeostationaryOrbit.GeostationaryBuilder(planet, satellite).build();
        int actual = (int) geostationaryOrbita.heightOrbita();
        int expected = (int) geostationaryOrbita.heightRise();
        assertEquals(actual, expected);
    }


    @Test
    public void testNotOutOnOrbit() {
        Satellite satellite = new Satellite(3.5, "Gf893");
        Planet planet = new Planet(10000, 100, "Kepler748b");
        GeostationaryOrbit geostationaryOrbita = new GeostationaryOrbit.GeostationaryBuilder(planet, satellite).build();
        assertFalse(geostationaryOrbita.heightRise() > geostationaryOrbita.heightOrbita());
    }


    @Test
    public void testBeyondLimitsOrbit() {
        assertTrue(getOrbit().heightRise() > getOrbit().heightOrbita());
    }

    @Test
    public void testHeightRise() {
        Assert.assertEquals(getOrbit().heightRise(), 50.0);
    }

    public GeostationaryOrbit getOrbit() {
        Satellite satellite = new Satellite(10, "Kepler6782");
        Planet planet = new Planet(10000, 100, "Kepler748b");
        GeostationaryOrbit geostationaryOrbita =
                new GeostationaryOrbit.GeostationaryBuilder(planet, satellite).build();
        return geostationaryOrbita;
    }

}
