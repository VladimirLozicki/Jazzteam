import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ManTest {
    Man newMan = new Man();

    @Test
    public void testSleepingActivity() {

        newMan.setActivity(new Sleeping());
        String actual = newMan.executeActivity();
        String expected = "Sleeping";
        assertEquals(actual, expected);
    }

    @Test
    public void testWorkingActivity() {
        newMan.setActivity(new Working());
        String actual = newMan.executeActivity();
        String expected = "Working";
        assertEquals(actual, expected);
    }

    @Test
    public void testRunActivity() {
        newMan.setActivity(new Run());
        String actual = newMan.executeActivity();
        String expected = "Running";
        assertEquals(actual, expected);
    }

    @Test
    public void testReadingActivity() {
        newMan.setActivity(new Reading());
        String actual = newMan.executeActivity();
        String expected = "Reading";
        assertEquals(actual, expected);
    }
}