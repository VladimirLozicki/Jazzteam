package dao;

import model.orbit.Orbit;
import model.planet.Planet;
import org.testng.annotations.Test;
import services.ServiceOrbit;
import services.ServicePlanet;

import static org.testng.Assert.*;

public class DaoPlanetTest {

    Planet planet = new Planet(1, 1, "Earth");

    @Test
    public void testCreate() {
        ServicePlanet servicePlanet = new ServicePlanet();
        servicePlanet.createPlanet(planet);
    }

    @Test
    public void testSave() {
        ServicePlanet servicePlanet = new ServicePlanet();
        servicePlanet.savePlanet(planet);
    }

    @Test
    public void testUpdate() {
        ServicePlanet servicePlanet = new ServicePlanet();
        servicePlanet.updatePlanet(planet);
    }

    @Test
    public void testDelete() {
        ServicePlanet servicePlanet = new ServicePlanet();
        servicePlanet.deletePlanet(planet);
    }
}