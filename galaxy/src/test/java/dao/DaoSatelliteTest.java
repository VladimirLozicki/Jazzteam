package dao;

import model.planet.Satellite;
import org.testng.annotations.Test;
import services.ServiceSattelite;

import static org.testng.Assert.*;

public class DaoSatelliteTest {
    Satellite satellite = new Satellite(1.8, "wjhfbhj");

    @Test
    public void testCreate() {
        ServiceSattelite serviceSattelite = new ServiceSattelite();
        serviceSattelite.createSattelite(satellite);

    }

    @Test
    public void testSave() {
        ServiceSattelite serviceSattelite = new ServiceSattelite();
        serviceSattelite.saveSattelite(satellite);
    }

    @Test
    public void testUpdate() {
        ServiceSattelite serviceSattelite = new ServiceSattelite();
        serviceSattelite.updateSattelite(satellite);
    }

    @Test
    public void testDelete() {
        ServiceSattelite serviceSattelite = new ServiceSattelite();
        serviceSattelite.deleteSattelite(satellite);
    }
}