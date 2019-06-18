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
    Orbit orbit = new Orbit.Builder().acceleration(15.0).height(7.9).build1();

    @Test
    public void testSave() {
        ServiceOrbit service = new ServiceOrbit();
        //  service.savePlanet(orbit);

    }


    @Test
    public void testDelete() {
        ServiceOrbit service = new ServiceOrbit();
        //service.saveDelete(orbit);
    }


    @Test
    public void testCreate() {
        ServiceOrbit service = new ServiceOrbit();
        //   service.createPlanet(orbit);
    }

    @Test
    public void testUpdate() {
        ServiceOrbit service = new ServiceOrbit();
        //   service.createPlanet(orbit);
    }
}