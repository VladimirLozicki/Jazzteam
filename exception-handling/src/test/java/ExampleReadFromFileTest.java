import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

import static org.testng.Assert.*;

public class ExampleReadFromFileTest {

    @Test
    public void testGetSourceExpression() throws Exception {
        int actual = returnLengthExpression();
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void testCreateStream() {
        FileInputStream actual = getLink().createStream(setAdress());
        assertNotNull(actual);
    }

    @Test(expectedExceptions = Exception.class)
    public void testFileNotFound() {
        String name = new File("src/main/resources/1.txt")
                .getAbsolutePath();
        getLink().exampleReadFile(name);
    }

    private String setAdress() {
        String name = new File("src/main/resources/expression.txt")
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