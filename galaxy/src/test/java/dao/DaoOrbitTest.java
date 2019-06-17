package dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import model.orbit.Orbit;
import model.planet.Planet;
import model.planet.Satellite;
import org.testng.annotations.Test;
import services.ServiceOrbit;
import services.ServicePlanet;
import services.ServiceSattelite;

public class DaoOrbitTest {

    @Test
    public void testSave() {
//        Planet planet = new Planet(1, 1, "Earth");
//
//        Satellite satellite = new Satellite(1.8, "wjhfbhj");
//
//        ServiceSattelite serviceSattelite = new ServiceSattelite();
//        serviceSattelite.saveSattelite(satellite);
//        ServicePlanet servicePlanet = new ServicePlanet();
//        servicePlanet.savePlanet(planet);
        Orbit orbit = new Orbit.Builder().acceleration(15.0).height(7.9).build1();
        ServiceOrbit service = new ServiceOrbit();
        service.savePlanet(orbit);

    }


    @Test
    public void testDelete() {
        Planet planet = new Planet(1, 1, "д");

        Satellite satellite1 = new Satellite("Europe");

        Orbit orbit = new Orbit.Builder()
                .acceleration(1).build1();

        ServiceOrbit service = new ServiceOrbit();
        service.savePlanet(orbit);
    }



    @Test
    public void testCreate() {
        Planet planet = new Planet(1, 1, "д");

        Satellite satellite1 = new Satellite("Europe");
        Orbit orbit = new Orbit.Builder()
                .acceleration(1).build1();
        ServiceOrbit service = new ServiceOrbit();
        service.createPlanet(orbit);
    }
}