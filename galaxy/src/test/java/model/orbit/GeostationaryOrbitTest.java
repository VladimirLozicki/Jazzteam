package model.orbit;

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
        GeostationaryOrbit geostationaryOrbit = (GeostationaryOrbit) new GeostationaryOrbit
                .GeostationaryBuilder(planet, satellite)
                .build1();
        int actual = (int) geostationaryOrbit.heightOrbit();
        int expected = (int) geostationaryOrbit.heightRise();
        assertEquals(actual, expected);
    }

    @Test
    public void testNotOutOnOrbit() {
        Satellite satellite = new Satellite(3.5, "Gf893");
        Planet planet = new Planet(10000, 100, "Kepler748b");
        GeostationaryOrbit geostationaryOrbit = (GeostationaryOrbit) new GeostationaryOrbit
                .GeostationaryBuilder(planet, satellite)
                .build1();
        assertFalse(geostationaryOrbit.heightRise() > geostationaryOrbit.heightOrbit());
    }

    @Test
    public void testBeyondLimitsOrbit() {
        assertTrue(getOrbit().heightRise() > getOrbit().heightOrbit());
    }

    @Test
    public void testHeightRise() {
        Assert.assertEquals(getOrbit().heightRise(), 50.0);
    }

    public GeostationaryOrbit getOrbit() {
        Satellite satellite = new Satellite(10, "Kepler6782");
        Planet planet = new Planet(10000, 100, "Kepler748b");
        GeostationaryOrbit geostationaryOrbit = (GeostationaryOrbit) new GeostationaryOrbit
                .GeostationaryBuilder(planet, satellite)
                .build1();
        return geostationaryOrbit;
    }

}
