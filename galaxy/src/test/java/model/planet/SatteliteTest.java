package model.planet;

import model.orbita.Orbita;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

import static org.testng.Assert.*;


public class SatteliteTest {
    private static final Logger logger = Logger.getGlobal();

    @Test
    public void testSatellite() {
        Planet planetEarthType = new Planet(81400, 10, "Mars");
        Sattelite sattelite = new Sattelite(100, 19000);
        Orbita orbita = new Orbita(planetEarthType, sattelite, 1500.0);
        assertEquals(getConsist(planetEarthType, sattelite, orbita).size(), 0);
    }

    @Test
    public void testMoreGravitySatellite() {
        Planet planetEarthType = new Planet(814000, 10, "Mars");
        Sattelite sattelite = new Sattelite(100, 19000);
        Orbita orbita = new Orbita(planetEarthType, sattelite, 1500.0);
        assertEquals(getConsist(planetEarthType, sattelite, orbita).get(0), "gravity more");
    }

    @Test
    public void testLessGravitySatellite() {
        Planet planetEarthType = new Planet(810, 10, "Mars");
        Sattelite sattelite = new Sattelite(100, 19000);
        Orbita orbita = new Orbita(planetEarthType, sattelite, 1500.0);
        assertEquals(getConsist(planetEarthType, sattelite, orbita).get(0), "gravity less");
    }

    @Test
    public void testVelocityMoreSatellite() {
        Planet planetEarthType = new Planet(81400, 10, "Mars");
        Sattelite sattelite = new Sattelite(1000, 19000);
        Orbita orbita = new Orbita(planetEarthType, sattelite, 1500.0);
        assertEquals(getConsist(planetEarthType, sattelite, orbita).get(0), "velocity more");
    }

    @Test
    public void testVelocityLessSatellite() {
        Planet planetEarthType = new Planet(81400, 10, "Mars");
        Sattelite sattelite = new Sattelite(-2, 19000);
        Orbita orbita = new Orbita(planetEarthType, sattelite, 1500.0);
        assertEquals(getConsist(planetEarthType, sattelite, orbita).get(0), "velocity less");
    }

    private ArrayList<String> getConsist(Planet planet, Sattelite sattelite, Orbita orbita) {
        ArrayList list = new ArrayList();
        if (orbita.PowerGravity() > 1000) {
            list.add("gravity more");
        } else if (orbita.PowerGravity() < 100) {
            list.add("gravity less");
        } else if (sattelite.getVelocity() < 0) {
            list.add("velocity less");
        } else if (sattelite.getVelocity() > 100) {
            list.add("velocity more");
        }
        if (list.size() == 0) {
        } else {
            logger.info("Check" + list);
        }
        return list;
    }
}