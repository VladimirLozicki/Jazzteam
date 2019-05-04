package model.planet;

import model.Orbita;
import model.massiveastronomicalobject.Star;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class PlanetTest {

    private static final Logger logger = Logger.getGlobal();
    Planet perfectPlanet = new Planet(5.97e24, 6371, 20,
            "", 24, 11.186, 5.50,
            5.79, 6300, 6400, 0, 30);
    Star sun = new Star(0.8, 1.3);

    Planet planet = new Planet(5.97e20, 6371, 2, "", 11.0, 10.0, 1.0);
    Star myStars = new Star(1);
    Orbita orbita = new Orbita(1, planet);

    @Test
    public void testPlanet() {
        if (planet.getDensity() > perfectPlanet.getMaxDensity()
                || planet.getDensity() < perfectPlanet.getMinDensity()) {
            logger.info("density is not within normal limits");
        }
        if (planet.getRadius() > perfectPlanet.getMaxRadius()
                || planet.getRadius() < perfectPlanet.getMinRadius()) {
            logger.info("radius not normal");
        }
        if (planet.getTemperature() > perfectPlanet.getMaxTemperature()
                || planet.getTemperature() < perfectPlanet.getMinTemperature()) {
            logger.info("temperature not normal");
        }
        if (myStars.getLuminocity() > sun.getMaxLuminocity()
                || myStars.getLuminocity() < sun.getMinLuminocity()) {
            logger.info("luminocity start not normal");
        }
    }

}