package models;

import model.planet.Satellite;
import org.testng.annotations.Test;
import services.ServiceSattelite;

public class SatelliteTest {

    @Test
    public void testAddAuto() {
        ServiceSattelite serviceSattelite = new ServiceSattelite();
        Satellite satellite = new Satellite("kepler");
        serviceSattelite.saveSattelite(satellite);
    }
}