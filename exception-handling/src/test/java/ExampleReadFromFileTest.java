import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

    @Test(expectedExceptions = FileNotFoundException.class)
    public void testFileNotFound() {
        getLink().exampleReadFile(setAdress());
    }

    @Test(expectedExceptions = IOException.class)
    public void testSecurityException() {
        getLink().exampleReadFile(setAdress());
    }

    private String setAdress() {
        //String name="/Users/vladimirlozickiy/Desktop/multimodule/exception-handling/src/main/resources/expression.txt";
        String name = getClass().getResource("/expression.txt").getPath();
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