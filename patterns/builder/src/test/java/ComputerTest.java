import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ComputerTest {

    Computer firstComputer = new Computer.Builder()
            .Age(8)
            .Display("IPS")
            .Manipulators("Key+Mouse")
            .OS("MacOS")
            .build();

    Computer secondComputer = new Computer.Builder()
            .Age(10)
            .Display("LG")
            .Manipulators("Key+Mouse")
            .OS("Windows")
            .build();

    @Test
    public void testGetOS() {
        assertEquals(firstComputer.getOS(), "MacOS");
        assertEquals(secondComputer.getOS(), "Windows");
    }

    @Test
    public void testGetManipulators() {
        assertEquals(firstComputer.getManipulators(), "Key+Mouse");
        assertEquals(secondComputer.getManipulators(), "Key+Mouse");
    }

    @Test
    public void testGetDisplay() {
        assertEquals(firstComputer.getDisplay(), "IPS");
        assertEquals(secondComputer.getDisplay(), "LG");
    }

    @Test
    public void testGetAge() {
        assertEquals(firstComputer.getAge(), 8);
        assertEquals(secondComputer.getAge(), 10);
    }
}