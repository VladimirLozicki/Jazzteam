import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;


public class ReadToFileTest {

    /**
     * check length expression
     * @throws Exception
     */
    @org.testng.annotations.Test
    public void testReadToFile() throws Exception {
        ReadToFile newfile = new ReadToFile();
        int count=4;
        String decoded=newfile.ReadToFile("/Users/vladimirlozickiy/Desktop/multimodule/ExceptionHandling/src/main/java/expression.txt");
        assertEquals(count,decoded.length());
    }
    /**
     * write you expression
     * @throws Exception
     */
    @org.testng.annotations.Test
    public void testReadToFile1() throws Exception {
        ReadToFile newfile = new ReadToFile();
        String decoded="1234";
        assertEquals(newfile.ReadToFile("/Users/vladimirlozickiy/Desktop/multimodule/ExceptionHandling/src/main/java/expression.txt"), decoded);
    }
    /**
     *
     * @throws Exception
     */
    @Ignore
    @org.testng.annotations.Test(expectedExceptions = Exception.class)
    public void Exception() throws Exception {
        ReadToFile s = new ReadToFile();
        s.ReadToFile("/Users/vladimirlozickiy/Desktop/multimodule/ExceptionHandling/src/main/java/expression.txt");
    }
}