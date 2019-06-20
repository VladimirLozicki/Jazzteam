package model.massiveastronomicalobject;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StarTest {

    @Test
    public void testGetTemperature() {
        Star sun = new Star(10000, 1.0);
        int expected = 314159265;
        assertEquals((int) sun.getTemperature(), expected);
    }
}