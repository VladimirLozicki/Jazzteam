package models;

        import model.planet.Sattelite;
        import org.testng.annotations.Test;
        import services.Service;

public class SatteliteTest {

    @Test
    public void testAddAuto() {
        Service service = new Service();
        Sattelite sattelite = new Sattelite("Kepler134", 1892);
        service.saveSattelite(sattelite);
    }
}