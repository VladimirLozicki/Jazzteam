package models;

import model.planet.Sattelite;
import org.testng.annotations.Test;
import services.Service;

public class SatteliteTest {

    @Test
    public void testAddAuto() {
         Service service = new Service();
         Sattelite sattelite = new Sattelite("Kepler134", 1892, 724);
         service.saveSattelite(sattelite);
        //Sattelite sattelite = new Sattelite("Earth", 6400, 18680000);
       // service.saveSattelite(sattelite);
        //service.createSattelite(sattelite);

    }
}