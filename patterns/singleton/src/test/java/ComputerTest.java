import org.testng.annotations.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class ComputerTest {

    Computer computer = new Computer();


    @Test
    public void testTwoObject() {
        computer.Launch("Linux");
    assertNotNull(computer.os);
}

    @Test
    public void testСhangeObject() {
        computer.Launch("Linux");
        computer.Launch("MacOS");
        String actual = computer.os.getName();
        String expected = "Linux";
        assertEquals(actual, expected);
    }
}