//package model.planet;
//
//import model.orbit.Orbit;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.logging.Logger;
//
//import static junit.framework.Assert.assertEquals;
//
//
//public class SatelliteTest {
//    private static final Logger logger = Logger.getGlobal();
//
//    @Test
//    public void testSatellite() {
//        Planet planetEarthType = new Planet(81400, 10, "Mars");
//        Satellite satellite = new Satellite(100, 19000);
//        Orbit orbit = new Orbit.Builder()
//                .planet(planetEarthType)
//                .satellite(satellite)
//                .height(1500.0)
//                .build();
//        assertEquals(getConsist(planetEarthType, satellite, orbit).size(), 0);
//    }
//
//    @Test
//    public void testMoreGravitySatellite() {
//        Planet planetEarthType = new Planet(814000, 10, "Mars");
//        Satellite satellite = new Satellite(100, 19000);
//        Orbit orbit = new Orbit.Builder()
//                .planet(planetEarthType)
//                .satellite(satellite)
//                .height(1500.0)
//                .build();
//        assertEquals(getConsist(planetEarthType, satellite, orbit).get(0), "gravity more");
//    }
//
//    @Test
//    public void testLessGravitySatellite() {
//        Planet planetEarthType = new Planet(810, 10, "Mars");
//        Satellite satellite = new Satellite(100, 19000);
//        Orbit orbit = new Orbit.Builder()
//                .planet(planetEarthType)
//                .satellite(satellite)
//                .height(1500.0)
//                .build();
//        assertEquals(getConsist(planetEarthType, satellite, orbit).get(0), "gravity less");
//    }
//
//    @Test
//    public void testVelocityMoreSatellite() {
//        Planet planetEarthType = new Planet(81400, 10, "Mars");
//        Satellite satellite = new Satellite(1000, 19000);
//        Orbit orbit = new Orbit.Builder()
//                .planet(planetEarthType)
//                .satellite(satellite)
//                .height(1500.0)
//                .build();
//        assertEquals(getConsist(planetEarthType, satellite, orbit).get(0), "velocity more");
//    }
//
//
//    @Test
//    public void testVelocityLessSatellite() {
//        Planet planetEarthType = new Planet(81400, 10, "Mars");
//        Satellite satellite = new Satellite(-2, 19000);
//        Orbit orbit = new Orbit.Builder()
//                .planet(planetEarthType)
//                .satellite(satellite)
//                .height(1500.0)
//                .build();
//        assertEquals(getConsist(planetEarthType, satellite, orbit).get(0), "velocity less");
//    }
//
//    private ArrayList<String> getConsist(Planet planet, Satellite satellite, Orbit orbit) {
//        ArrayList list = new ArrayList();
//        if (orbit.powerGravity() > 1000) {
//            list.add("gravity more");
//        } else if (orbit.powerGravity() < 100) {
//            list.add("gravity less");
//        } else if (satellite.getVelocity() < 0) {
//            list.add("velocity less");
//        } else if (satellite.getVelocity() > 100) {
//            list.add("velocity more");
//        }
//        if (list.size() == 0) {
//        } else {
//            logger.info("Check" + list);
//        }
//        return list;
//    }
//}