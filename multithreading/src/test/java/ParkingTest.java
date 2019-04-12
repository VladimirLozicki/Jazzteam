import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParkingTest {
    @Test
    public void testRun() {
     Place r = new Place();
        int actual=r.getSize();
        int decoded=6;
        assertEquals(actual,decoded);
    }

    @Test
    public void testValue() {
        Place s = new Place();
        int [] expected = {0,0,0,0,0,0};
        assertEquals(s.getPlaces(), expected);
    }

    @Test
    @AfterClass
    public  void checkPlace() {
        Place place = new Place();
        assertNotNull(place.getSize());
    }
}