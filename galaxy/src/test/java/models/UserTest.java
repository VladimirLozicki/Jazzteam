package models;

import model.planet.Sattelite;
import org.testng.annotations.Test;
import services.Service;

public class UserTest {

    @Test
    public void testAddAuto() {
        Service service = new Service();
//        Sattelite sattelite = new Sattelite("Moon", 72394, 100000);
//        service.saveSattelite(sattelite);
        Sattelite sattelite = new Sattelite("Earth", 6400, 18680000);
        service.saveSattelite(sattelite);
        //service.createSattelite(sattelite);
    }
}