import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;

public class ParkingTest {
    private static final Logger logger = Logger.getGlobal();
    Place commonResource = new Place();

    @Test
    public void testZeroThread() {
        start(0);
        int actual = checkPlace(commonResource.getPlace());
        int expected = 8;
        assertEquals(actual, expected);
    }

    @Test
    public void testRunTwoThread() {
        start(2);
        int actual = checkPlace(commonResource.getPlace());
        int expected = 2;
        assertEquals(actual, expected);
    }

    @Test
    public void testThreadMorePlace() {
        start(10);
        int actual = checkPlace(commonResource.getPlace());
        int expected = 8;
        assertEquals(actual, expected);
    }

    public void start(int countThread) {
        for (int i = 0; i < countThread; i++) {
            Thread t = new Thread(new Parking(commonResource));
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int checkPlace(int[] place) {
        int countPlace = 0;
        for (int i = 0; i < place.length; i++) {
            if (place[i] == 1) {
                countPlace++;
            } else {
                continue;
            }
        }
        return countPlace;
    }


}