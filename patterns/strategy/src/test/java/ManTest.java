import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ManTest {
    Man newMan = new Man();

    @Test
    public void testSleepingActivity() {
        newMan.setActivity(new Sleeping());
        String expected = "Sleeping";
        assertEquals(activity(), expected);
    }

    @Test
    public void testWorkingActivity() {
        newMan.setActivity(new Working());
        String expected = "Working";
        assertEquals(activity(), expected);
    }

    @Test
    public void testRunActivity() {
        newMan.setActivity(new Run());
        String expected = "Running";
        assertEquals(activity(), expected);
    }

    @Test
    public void testReadingActivity() {
        newMan.setActivity(new Reading());

        String expected = "Reading";
        assertEquals(activity(),expected);
    }


    public String activity() {
        return newMan.executeActivity();
    }
}