package dao;

import model.orbita.Orbit;
import model.planet.Planet;
import model.planet.Satellite;
import org.testng.annotations.Test;
import services.ServiceOrbit;

import static org.testng.Assert.*;

public class DaoOrbitTest {

    @Test
    public void testSave() {
        Planet planet = new Planet(1, 1, "Earth");

        Satellite satellite1 = new Satellite("Europe");
        Orbit orbit = new Orbit.Builder(planet).satellite(satellite1)
                .acceleration(1).a(planet.getName()).build1();
        ServiceOrbit service = new ServiceOrbit();
        service.savePlanet(orbit);
    }


    @Test
    public void testDelete() {
        Planet planet = new Planet(1, 1, "д");

        Satellite satellite1 = new Satellite("Europe");
        Orbit orbit = new Orbit.Builder(planet).satellite(satellite1)
                .acceleration(1).a(planet.getName()).build1();
        ServiceOrbit service = new ServiceOrbit();
        service.deletePlanet(orbit);
    }

    @Test
    public void testUpdate() {
        Planet planet = new Planet(1, 1, "д");

        Satellite satellite1 = new Satellite("Europe");
        Orbit orbit = new Orbit.Builder(planet).satellite(satellite1)
                .acceleration(1).a(planet.getName()).build1();
        ServiceOrbit service = new ServiceOrbit();
        service.updatePlanet(orbit);
    }

    @Test
    public void testCreate() {
        Planet planet = new Planet(1, 1, "д");

        Satellite satellite1 = new Satellite("Europe");
        Orbit orbit = new Orbit.Builder(planet).satellite(satellite1)
                .acceleration(1).a(planet.getName()).build1();
        ServiceOrbit service = new ServiceOrbit();
        service.createPlanet(orbit);
    }
}