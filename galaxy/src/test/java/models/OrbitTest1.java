package models;

import com.sun.org.apache.xpath.internal.operations.Or;
import model.orbita.Orbit;
import model.planet.Planet;
import model.planet.Satellite;
import org.testng.annotations.Test;
import services.ServiceOrbit;
import services.ServiceSattelite;

import static org.testng.Assert.*;

public class OrbitTest1 {
    @Test
    public void testAddAuto() {

        Planet planet = new Planet(1, 1, "д");

        Satellite satellite1 = new Satellite("Europe");
        Orbit orbit = new Orbit.Builder(planet).satellite(satellite1)
                .acceleration(1).a(planet.getName()).build1();
        ServiceOrbit service = new ServiceOrbit();


//        System.out.println(orbit.getPlanet().getWeight());
//        System.out.println(orbit.getSatellite().getName());
        service.savePlanet(orbit);
    }

}