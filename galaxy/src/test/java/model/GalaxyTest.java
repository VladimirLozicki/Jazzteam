package model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import model.massiveastronomicalobject.MassiveAstronomicalObject;
import model.orbit.Galaxy;
import model.orbit.Orbit;
import model.planet.Planet;
import model.planet.Satellite;
import org.testng.annotations.Test;
import services.ServiceOrbit;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

import static com.mysql.cj.xdevapi.Type.JSON;
import static org.testng.Assert.*;

public class GalaxyTest {

    Galaxy galaxy = new Galaxy();

    @Test
    public void testSave() {
        ArrayList<Orbit> orbits = new ArrayList<>();
        Galaxy galaxy = new Galaxy();
        Planet planet = new Planet(1.0, 2.9, "name");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)

                .build1();
        orbits.add(orbit);
        galaxy.setOrbit(orbits);
        ServiceOrbit service = new ServiceOrbit();
        service.save(galaxy);
    }

    @Test
    public void testToBumpInto() {
        ArrayList<Orbit> orbits = new ArrayList<>();

        Planet planet = new Planet(30, 2.9, "name");
        Orbit orbit = new Orbit.Builder()
                .planet(planet)
                .height(2)
                .build1();

        Orbit orbit2 = new Orbit.Builder()
                .planet(planet)
                .height(0)
                .build1();

        Orbit orbit1 = new Orbit.Builder().height(100).build1();
        orbits.add(orbit);
        orbits.add(orbit2);
        orbits.add(orbit1);
        MassiveAstronomicalObject massiveAstronomicalObject = new MassiveAstronomicalObject(100.0);
        galaxy.setMassiveAstronomicalObject(massiveAstronomicalObject);
        galaxy.setOrbit(orbits);
        run();
        assertEquals(galaxy.getMassiveAstronomicalObject().getWeight(), 130.0);
    }

    private void run() {
        for (int i = 0; i < 4; i++) {
            galaxy.getStateObject();
        }
    }

    @Test
    public void tes() {

        Planet planet = new Planet(1.0, 1.0);
        Orbit orbit = new Orbit.Builder().height(100).acceleration(1).planet(planet).build1();
        ArrayList<Orbit> list = new ArrayList<>();
        list.add(orbit);
        Galaxy galaxy = new Galaxy();
        galaxy.setOrbit(list);
        MassiveAstronomicalObject massiveAstronomicalObject = new MassiveAstronomicalObject(1, 1.0);

        Gson gson = new Gson();
        galaxy.setMassiveAstronomicalObject(massiveAstronomicalObject);
        String json = gson.toJson(galaxy);
        System.out.println(json);
    }
}