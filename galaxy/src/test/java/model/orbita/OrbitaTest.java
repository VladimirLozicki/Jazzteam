package model.orbita;

import model.planet.Planet;
import model.planet.Sattelite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OrbitaTest {

    @Test
    public void testCreatBalanceSystem() {
        Planet planet = new Planet(100.0, 10.0, "Kepler48b");
        Sattelite sattelite = new Sattelite("Europe");
        Orbita orbita = new Orbita.Builder(planet).sattelite(sattelite).build();
        assertEquals(orbita.accelerationGravity(), 1.0);
    }

    @Test
    public void testSatteliteGoLimitPlanet() {
        Planet planet = new Planet(100.0, 5.0, "Kepler74");
        Sattelite sattelite = new Sattelite("Europe");
        Orbita orbita = new Orbita.Builder(planet).sattelite(sattelite).build();
        assertEquals(orbita.accelerationGravity(), 4.0);
    }

    @Test
    public void testSatteliteFallOnPlanet() {
        Planet planet = new Planet(100.0, 100.0, "Mars");
        Sattelite sattelite = new Sattelite("Europe");
        Orbita orbita = new Orbita.Builder(planet).sattelite(sattelite).build();
        assertEquals(orbita.accelerationGravity(), 0.01);

    }

    @Test
    public void testAccelerationGravity() {
        double actual = getSystem().accelerationGravity();
        assertEquals(actual, 68.75);
    }

    @Test
    public void testpowerGravity() {
        double actual = getSystem().powerGravity();
        assertEquals(actual, 68.75);
    }

    public Orbita getSystem() {
        Planet planet = new Planet(687500.0, 100.0, "Kepler48b");
        Sattelite sattelite = new Sattelite(100.0);
        Orbita orbita = new Orbita.Builder(planet).sattelite(sattelite).height(1000).build();
        return orbita;
    }

    @Test
    public void getStem() {
        Planet planet = new Planet(687500.0, 100.0, "Kepler48b");
        Sattelite sattelite = new Sattelite(100.0, 100.0);
        //Orbita orbita = new Orbita.Builder(planet).sattelite(sattelite).height(1000).build();
        Orbita orbita = new Orbita();
        orbita.run();

    }
}