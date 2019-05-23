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
    Orbita orbita = new Orbita( 1.5, planetEarthType);
    @Test
    public void testCreatePlanetWithLife() {
        Planet planet = new Planet(5.6e24, 6500, 4, "Cepler748b", 5.8,
                22.1);
        Star myStars = new Star(1);
        Orbita myOrbita = new Orbita(1, planet);
        if (planet.getDensity() > planetEarthType.getMaxDensity()) {
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
        }
    }

    @Test
    public void testCheckMoreDistance() {
        Orbita orbita = new Orbita(1.5, planetEarthType);
        Planet planet = new Planet(600.0, 650, -20, "Cepler748b",
                5.0, 15.0);
        Star myStars = new Star(0.8);
        Orbita myOrbita = new Orbita(4, planet);
        if (planet.getDensity() < planetEarthType.getMinDensity()) {
            logger.info("density is more normal ");
        }
        if (planet.getRadius() > planetEarthType.getMaxRadius()) {
            logger.info("radius more normal");
        }
        if (planet.getTemperature() > planetEarthType.getMaxTemperature()) {
            logger.info("temperature more normal");
        }
        if (planet.getTemperature() > planetEarthType.getMinTemperature()) {
            logger.info("Planet very hot");
        }
        if (myStars.getLuminocity() > sun.getMaxLuminocity()) {
            logger.info("luminocity more normal");
        }
        if (planet.getRotationPeriod() > planetEarthType.getMaxRotatioPeriod()) {
            logger.info(" period more normal");

        }
    }
        @Test
        public void testCheckLessDistance () {
            Orbita orbita = new Orbita(1.5, planetEarthType);
            Planet planet = new Planet(600.0, 650, -20, "Cepler748b", 5.0,
                    15.0);
            Star myStars = new Star(0.8);
            Orbita myOrbita = new Orbita(0.1, planet);
            if (planet.getDensity() < planetEarthType.getMaxDensity()) {
                logger.info("density is less normal ");
            }
            if (planet.getRadius() < planetEarthType.getMinRadius()) {
                logger.info("radius less normal");
            }
            if (planet.getTemperature() < planetEarthType.getMinTemperature()) {
                logger.info("Planet very cold");
            }
            if (myStars.getLuminocity() < sun.getMinLuminocity()) {
                logger.info("luminocity less normal");
            }
            if (planet.getRotationPeriod() < planetEarthType.getMinRotatioPeriod()) {
                logger.info(" period less normal");
            }
        }

        @Test
        public void testCreatBalanceSystem () {
        Planet planet = new Planet(100.0, 1.0, 10, "Cepler748b", 5.0,
                        15.0);
        Sattelite sattelite = new Sattelite("kepler", 1000, 134325);
        Orbita orbita = new Orbita(10, planet, sattelite);
        double actual = orbita.run(planet.getWeight(), planet.getRadius());
          if(actual == 1.0 ){
              logger.info("This is balance system");
          }
            if(actual < 1.0 ){
                logger.info("This is not balance system");
                logger.info("Sattelite to fall on the planet");
            }
            else if (actual > 1.0 ){
                logger.info("This is Balance System");
                logger.info("Won't become a Sattelite");
            }
    }

}
