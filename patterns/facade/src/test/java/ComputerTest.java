import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ComputerTest {
    Computer computer = new Computer();

    @Test
    public void testPowerOn() {
        Computer computer = new Computer();
        String actual = computer.PowerOn();
        assertEquals(actual, "Power On");
    }

    @Test
    public void testPowerOff() {
        Computer computer = new Computer();
        String actual = computer.PowerOff();
        assertEquals(actual, "Power Off");
    }

    @Test
    public void testLoadUsb() {
        Computer computer = new Computer();
        assertTrue(computer.usb.load());
    }

    @Test
    public void testUnloadUsb() {
        Computer computer = new Computer();
        assertFalse(computer.usb.unload());
    }

    @Test
    public void testCopy() {
        assertTrue(computer.copy());
    }

    @Test
    public void testUnCopy() {
        Computer computer = new Computer();
        assertFalse(computer.hdd.copyFromUSB(computer.usb));
    }
}