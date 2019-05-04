package model.planet;

import model.Orbita;
import model.massiveastronomicalobject.Star;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class PlanetTest {

    private static final Logger logger = Logger.getGlobal();
    SolidPlanet planetEarthType = new SolidPlanet(5.97e24, 6371, "Earth",
            11.0, 12.0, 5.0, 6.0,
            6200, 6700, 0, 25, 22,
            24 );
    Star sun = new Star(0.8, 1.3);
    Orbita orbita = new Orbita(0.8, 1.5, planetEarthType);

    @Test
    public void testCreatePlanetWithLife() {
        Planet planet = new Planet(6000.0, 6500, 4, "Cepler748b", 5.8, 22.1);
        Star myStars = new Star(1);
        Orbita myOrbita = new Orbita(1, planet);
        if (planet.getDensity() > planetEarthType.getMaxDensity() ) {
            logger.info("density is more normal ");
        } else if (planet.getDensity() < planetEarthType.getMinDensity()) {
            logger.info("density is less normal ");
        } else if (planet.getRadius() > planetEarthType.getMaxRadius()) {
            logger.info("radius more normal");
        } else if (planet.getRadius() < planetEarthType.getMinRadius()) {
            logger.info("radius less normal");
        } else if (planet.getTemperature() > planetEarthType.getMaxTemperature()) {
            logger.info("temperature more normal");
        } else if (planet.getTemperature() < planetEarthType.getMinTemperature()) {
            logger.info("temperature less  normal");
        } else if (myStars.getLuminocity() > sun.getMaxLuminocity()) {
            logger.info("luminocity more normal");
        } else if (myStars.getLuminocity() < sun.getMinLuminocity()) {
            logger.info("luminocity less normal");
        } else if (planet.getRotationPeriod() > planetEarthType.getMaxRotatioPeriod()) {
            logger.info(" period more normal");
        } else if (planet.getRotationPeriod() < planetEarthType.getMinRotatioPeriod()) {
            logger.info(" period less normal");
        } else if (myOrbita.getDistance() > orbita.getMaxDistance()) {
            logger.info("distance more normal");
        } else if (myOrbita.getDistance() < orbita.getMinDistance()) {
            logger.info("distance more normal");
        }
    }



    @Test
    public void testCheckDistanc() {
        Star sun = new Star(0.8, 1.3);
        Orbita orbita = new Orbita(0.8, 1.5, planetEarthType);
        Planet planet = new Planet(600.0, 650, -20, "Cepler748b",
                5.0, 15.0);
        Star myStars = new Star(0.8);
        Orbita myOrbita = new Orbita(4, planet);

        if (planet.getDensity() > planetEarthType.getMaxDensity()) {
            logger.info("density is more normal ");
        }  if (planet.getDensity() < planetEarthType.getMinDensity()) {
            logger.info("density is less normal ");
        }  if (planet.getRadius() > planetEarthType.getMaxRadius()) {
            logger.info("radius more normal");
        }  if (planet.getRadius() < planetEarthType.getMinRadius()) {
            logger.info("radius less normal");
        }  if (planet.getTemperature() > planetEarthType.getMaxTemperature()) {
            logger.info("temperature more normal");
        }  if (planet.getTemperature() < planetEarthType.getMinTemperature()) {
            logger.info("Planet very cold");
        }  if (myStars.getLuminocity() > sun.getMaxLuminocity()) {
            logger.info("luminocity more normal");
        }  if (myStars.getLuminocity() < sun.getMinLuminocity()) {
            logger.info("luminocity less normal");
        }  if (planet.getRotationPeriod() > planetEarthType.getMaxRotatioPeriod()) {
            logger.info(" period more normal");
        }  if (planet.getRotationPeriod() < planetEarthType.getMinRotatioPeriod()) {
            logger.info(" period less normal");
        }  if (myOrbita.getDistance() > orbita.getMaxDistance()) {
            logger.info("distance more normal");
        }  if (myOrbita.getDistance() < orbita.getMinDistance()) {
            logger.info("distance more normal");
        }
    }


}