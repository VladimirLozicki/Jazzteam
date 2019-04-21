import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ServiceLocatorTest {
    Service service1 = ServiceLocator.getService("Service1");
    Service newservice1 = ServiceLocator.getService("Service1");
    Service service2 = ServiceLocator.getService("Service2");
    Service newservice2 = ServiceLocator.getService("Service2");
    @Test
    public void testGetService1() {
      String actual = service1.getName();
      String expected = "Service1";
      assertEquals(actual, expected);
    }

    @Test
    public void testGetService1Cache() {
        String actual = service2.getName();
        String expected = "Service2";
        assertEquals(actual, expected);
    }

    @Test
    public void testGetServiceCache1() {
        String newEmail = newservice1.getName();
        String expected = "Service1";
        assertEquals(newEmail, expected);
    }

    @Test
    public void testGetServiceCache2() {
        String newEmail = newservice2.getName();
        String expected = "Service2";
        assertEquals(newEmail, expected);
    }
}