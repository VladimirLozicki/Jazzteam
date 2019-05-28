package model.planet;

import model.massiveastronomicalobject.Star;
import model.orbita.Orbita;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

public class PlanetTest {
    private static final Logger logger = Logger.getGlobal();
    double attitude=2.09999508929799;


    SolidPlanet planetEarthType = new SolidPlanet(5.97e24, 6371, "Earth",
            11.0, 12.0, 5.0, 6.0,
            6200, 6700, 0, 25, 22,
            24);
    Star sun = new Star(10000, 1.0);
    ArrayList<String> list = new ArrayList<>();
    @Test
    public void testCreatePlanetWithLife() {
        Planet planet = new Planet(5.6e24, 6500, "Kepler748b", 5.8,
                22.1);
        //Star myStars = new Star(1);
      Orbita orbita = new Orbita(planetEarthType,sun, 149600000);
        if (planet.getDensity() > planetEarthType.getMaxDensity()) {
            list.add("density is more normal ");
        } else if (planet.getDensity() < planetEarthType.getMinDensity()) {
            list.add("density is less normal ");
        } else if (planet.getRadius() > planetEarthType.getMaxRadius()) {
            list.add("radius more normal");
        } else if (planet.getRadius() < planetEarthType.getMinRadius()) {
            list.add("radius less normal");
            list.add("temperature less  normal");
        } else if (planet.getRotationPeriod() > planetEarthType.getMaxRotatioPeriod()) {
            list.add(" period more normal");
        } else if (planet.getRotationPeriod() < planetEarthType.getMinRotatioPeriod()) {
            list.add(" period less normal");
        }
        //assertEquals(list.size(), 0);
        System.out.println(getAttitude(sun, orbita));
    }

    @Test
    public void testCheckMoreDistance() {
        Planet planet = new Planet(670.0, 670.0,  "Kepler748b",
                17.0, 35.0);
        Star myStars = new Star(1.0, 0.6);
        Orbita orbita = new Orbita(planet, myStars, 10000);
        double actual=getAttitude(myStars, orbita);
        assertTrue(actual < attitude);

    }

    @Test
    public void testCheckLessDistance() {
        Planet planet1 = new Planet(6000.0, 650.0,  "Kepler748b",
                17.0, 35.0);
        Star myStars = new Star(100, 0.5);
        Orbita orbita = new Orbita(planet1, myStars, 100);
        double actual=getAttitude(myStars, orbita);
        assertTrue(actual > attitude);
    }


    public double getAttitude(Star star, Orbita orbita){
        return star.Temperature()/orbita.getHeight();
    }


}
