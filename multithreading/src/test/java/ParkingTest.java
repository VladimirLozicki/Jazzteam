import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ParkingTest {
    private static final Logger logger = Logger.getGlobal();
    Place commonResource = new Place();
 // TODO Иван подумать над допольнительными тестами
    @Test
    public void testcheckPlace() {
        int actual;
        int exprected = 1;
        for (int i = 1; i < 2; i++) {
            Thread t = new Thread(new Parking(commonResource));
            t.start();
            try {
                t.join();
                actual = commonResource.place[0];
                assertEquals(actual, exprected);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testCountPlace() {
       assertNotNull(commonResource.place.length);
    }
}