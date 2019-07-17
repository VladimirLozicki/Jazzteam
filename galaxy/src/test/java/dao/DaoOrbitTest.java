package dao;

import model.orbit.Galaxy;
import model.orbit.Orbit;
import model.planet.Planet;
import model.planet.Satellite;
import org.testng.TestException;
import org.testng.annotations.Test;
import services.ServiceOrbit;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class DaoOrbitTest {
ArrayList<Orbit> list;
    @Test(expectedExceptions = NullPointerException.class)
    public void testFindById() throws FileNotFoundException {
        Galaxy galaxy = new Galaxy();

        Orbit orbit = new Orbit.Builder()
                .height(1000)
                .build1();
     list.add(orbit);
     galaxy.setOrbit(list);
        ServiceOrbit service = new ServiceOrbit();
        service.save(galaxy);
        service.find(2).getOrbit();
    }

//    @Test
//    public void testCreate() {
//        Galaxy galaxy=new Galaxy();
//        Satellite satellite = new Satellite("kepler");
//        Orbit orbit = new Orbit.Builder()
//                .satellite(satellite)
//                .height(1000)
//                .build1();
//
//        ServiceOrbit service = new ServiceOrbit();
//        service.create(orbit);
//       // assertNotNull(service.find(129));
//    }
//
//    @Test
//    public void testSave() {
//        Planet planet = new Planet();
//        Satellite satellite = new Satellite("kepler");
//        Orbit orbit = new Orbit.Builder()
//                .planet(planet)
//                .satellite(satellite)
//                .build1();
//
//        ServiceOrbit service = new ServiceOrbit();
//        service.create(orbit);
//        assertNotNull(service.find(129));
//    }
//
//    @Test
//    public void testUpdate() {
//        ServiceOrbit service = new ServiceOrbit();
//        Orbit orbit = new Orbit.Builder()
//                .height(1)
//                .build1();
//        Orbit orbit1 = new Orbit.Builder()
//                .height(1)
//                .build1();
//        service.create(orbit);
//        service.create(orbit1);
//        assertNotEquals(service.find(129), service.find(2));
//
//    }
//
//    @Test
//    public void testDelete() {
//        Planet planet = new Planet();
//        Satellite satellite = new Satellite("kepler");
//        Orbit orbit = new Orbit.Builder()
//                .planet(planet)
//                .satellite(satellite)
//                .build1();
//
//        ServiceOrbit service = new ServiceOrbit();
//        service.save(orbit);
//        Orbit orbit1 =   service.find(129);
//        service.delete(orbit);
//        assertNotEquals(orbit, orbit1);
//    }
}