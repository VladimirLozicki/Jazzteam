import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;

public class ParkingTest {
    private static final Logger logger = Logger.getGlobal();

    @Test
    public void testRun() {
        int actual = getLinkPlace().place.length;
        int decoded = 8;
        assertEquals(actual, decoded);
    }

    @Test
    public void testcheckPlace() {
        Place commonResource = new Place();
        int actual;
        int exprected = 1;
        for (int i = 1; i < 5; i++) {
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

    private Place getLinkPlace() {
        Place link = new Place();
        return link;
    }

}