import org.testng.annotations.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class ComputerTest {

    Computer computer = new Computer();


    @Test
    public void testTwoObject() {
        launch("Linux");
    assertNotNull(computer.os);
}

    @Test
    public void testСhangeObject() {
        launch("Linux");
        launch("MacOS");
        String actual = computer.os.getName();
        String expected = "Linux";
        assertEquals(actual, expected);
    }

    public  void  launch(String name){
        computer.Launch(name);
    }
}



