import org.testng.annotations.Test;
import java.io.File;

import static org.testng.Assert.*;

public class ExampleReadFromFileTest {

    @Test
    public void testGetSourceExpression() throws Exception {
        int actual = returnLengthExpression();
        int expected = 2;
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = Exception.class)
    public void testFileNotFound() {
        String name = new File("src/main/resources/1.txt")
                .getAbsolutePath();
        getLink().exampleReadFile(name);
    }

    private String setAdress() {
        String name = new File("src/main/resources/exception.txt")
                .getAbsolutePath();
        return name;
    }

    private ExampleReadFromFile getLink() {
        ExampleReadFromFile objectFile = new ExampleReadFromFile();
        return objectFile;
    }

    private int returnLengthExpression() {
        return getLink().exampleReadFile(setAdress()).length();
    }
}