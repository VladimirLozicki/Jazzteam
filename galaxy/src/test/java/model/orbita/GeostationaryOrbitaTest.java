package model.orbita;

import model.planet.Planet;
import model.planet.Sattelite;
import org.testng.annotations.Test;

public class GeostationaryOrbitaTest {

    @Test
    public void testGetHeightOrbita() {
        Sattelite sattelite = new Sattelite(10.0);
        Planet planet = new Planet(5.6e2, 6500, 4, "Kepler748b", 5.8,
                22.1);
        GeostationaryOrbita orbita = new GeostationaryOrbita(planet, sattelite);
        System.out.println(orbita.getHeightOrbita());
        System.out.println(orbita.getHeightRise());
       // assertEquals(orbita.getHeightOrbita());
    }
}