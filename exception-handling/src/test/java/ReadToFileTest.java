
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class ReadToFileTest {

    String name="/Users/vladimirlozickiy/Desktop/multimodule/exception-handling/src/main/java/expression.txt";
    @Test
    public void testReadToFile() throws Exception {
        ReadToFile newfile = new ReadToFile();
        int count=4;
        String decoded=newfile.ReadToFile(name);
        assertEquals(count,decoded.length());
    }

    @Test
    public void testReadToFile1() throws Exception {
        ReadToFile newfile = new ReadToFile();
        String decoded="1234";
        assertEquals(newfile.ReadToFile(name), decoded);
    }

    @Ignore
    @org.testng.annotations.Test(expectedExceptions = Exception.class)
    public void Exception() throws Exception {
        ReadToFile s = new ReadToFile();
        s.ReadToFile(name);
    }
}