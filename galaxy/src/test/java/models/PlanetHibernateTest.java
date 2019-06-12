package models;

import model.planet.Planet;
import org.testng.annotations.Test;
import services.ServicePlanet;

public class PlanetHibernateTest {
    @Test
    public void testAddAuto() {
        ServicePlanet servicePlanet = new ServicePlanet();
        Planet planet = new Planet(59.0);
        servicePlanet.savePlanet(planet);
    }

}