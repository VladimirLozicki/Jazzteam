import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;


import static org.testng.Assert.*;

public class ExampleReadFromFileTest {

    File name = new File("./src/main/resources/expression.txt");
    ExampleReadFromFile file = new ExampleReadFromFile();
    // TODO  Иван пару тестов  негативных и позитивных

    @Test
    public void testCheckReadFile() {
        assertTrue(name.canRead());
    }

    @Test
    public void testCheckWriteFile() {
        assertTrue(name.canWrite());
    }

    @Test
    public void testCheckExists() {
        assertTrue(name.exists());
    }


    @Test
    public void testCheckIsFile() {
        assertTrue(name.isFile());
    }

    @Test(dataProvider = "data")
    public void testTheResult(String[] input) {
        ExampleReadFromFile exampleReadFromFile = new ExampleReadFromFile();
        String actual=exampleReadFromFile.exampleReadFile(name);
        assertEquals(actual, input[0]);
    }

    @DataProvider(name = "data")
    public Object[] getData() {
        return new Object[]{
                "1234",
        };
    }



    @Test
    public void testGetSourceExpression() {
        String actual = file.exampleReadFile(name);
        assertNotNull(actual);
    }


    @Test(expectedExceptions = FileNotFoundException.class)
    public void testFileNotFound() throws FileNotFoundException {
        String name = new File("src/main/resources/1.txt")
                .getAbsolutePath();
        file.createStream(new File(name));
    }
}