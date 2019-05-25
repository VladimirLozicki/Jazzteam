package model.planet;

import model.massiveastronomicalobject.Star;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;

public class PlanetTest {
    private static final Logger logger = Logger.getGlobal();

    /*
    *
    *CREATE PLANET EARTH TYPE
    * */
    SolidPlanet planetEarthType = new SolidPlanet(5.97e24, 6371, "Earth",
            11.0, 12.0, 5.0, 6.0,
            6200, 6700, 0, 25, 22,
            24);
    Star sun = new Star(0.8, 1.3);
    @Test
    public void testCreatePlanetWithLife() {
        Planet planet = new Planet(5.6e24, 6500, 4, "Kepler748b", 5.8,
                22.1);
        Star myStars = new Star(1);
        ArrayList<String> list = new ArrayList<>();
        if (planet.getDensity() > planetEarthType.getMaxDensity()) {
            list.add("density is more normal ");
        } else if (planet.getDensity() < planetEarthType.getMinDensity()) {
            list.add("density is less normal ");
        } else if (planet.getRadius() > planetEarthType.getMaxRadius()) {
            list.add("radius more normal");
        } else if (planet.getRadius() < planetEarthType.getMinRadius()) {
            list.add("radius less normal");
        } else if (planet.getTemperature() > planetEarthType.getMaxTemperature()) {
            list.add("temperature more normal");
        } else if (planet.getTemperature() < planetEarthType.getMinTemperature()) {
            list.add("temperature less  normal");
        } else if (myStars.getLuminocity() > sun.getMaxLuminocity()) {
            list.add("luminocity more normal");
        } else if (myStars.getLuminocity() < sun.getMinLuminocity()) {
            list.add("luminocity less normal");
        } else if (planet.getRotationPeriod() > planetEarthType.getMaxRotatioPeriod()) {
            list.add(" period more normal");
        } else if (planet.getRotationPeriod() < planetEarthType.getMinRotatioPeriod()) {
            list.add(" period less normal");
        }
        assertEquals(list.size(), 0);
    }

//    @Test
//    public void testCheckMoreDistance() {
//        Orbita orbita = new Orbita(1.5, planetEarthType);
//        Planet planet = new Planet(600.0, 65000, 30, "Kepler748b",
//                17.0, 35.0);
//        Star myStars = new Star(0.8);
//        Orbita myOrbita = new Orbita(4, planet);
//
//        if (planet.getDensity() > planetEarthType.getMinDensity()) {
//            logger.info("density is more normal ");
//        }
//        if (planet.getRadius() > planetEarthType.getMaxRadius()) {
//            logger.info("radius more normal");
//        }
//        if (planet.getTemperature() > planetEarthType.getMaxTemperature()) {
//            logger.info("temperature more normal");
//        }
//        if (planet.getTemperature() > planetEarthType.getMinTemperature()) {
//            logger.info("Planet very hot");
//        }
//        if (myStars.getLuminocity() > sun.getMaxLuminocity()) {
//            logger.info("luminocity more normal");
//        }
//        if (planet.getRotationPeriod() > planetEarthType.getMaxRotatioPeriod()) {
//            logger.info(" period more normal");
//        }
//    }

//    @Test
//    public void testCheckLessDistance() {
//        Orbita orbita = new Orbita(1.5, planetEarthType);
//        Planet planet = new Planet(600.0, 650, -20, "Cepler748b", 5.0,
//                15.0);
//        Star myStars = new Star(0.8);
//        Orbita myOrbita = new Orbita(0.1, planet);
//        if (planet.getDensity() < planetEarthType.getMaxDensity()) {
//            logger.info("density is less normal ");
//        }
//        if (planet.getRadius() < planetEarthType.getMinRadius()) {
//            logger.info("radius less normal");
//        }
//        if (planet.getTemperature() < planetEarthType.getMinTemperature()) {
//            logger.info("Planet very cold");
//        }
//        if (myStars.getLuminocity() < sun.getMinLuminocity()) {
//            logger.info("luminocity less normal");
//        }
//        if (planet.getRotationPeriod() < planetEarthType.getMinRotatioPeriod()) {
//            logger.info(" period less normal");
//        }
//    }
}
