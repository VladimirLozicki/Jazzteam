import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.testng.Assert.*;


public class ReadToFileTest {


    @Test
    public void testGetSourceExpression() throws Exception {
        int actual=returnLengthExpression();
        int expected = 3;
        assertEquals(actual, expected);
 }

    @Test
    public void testCreateStream() throws Exception {
        FileInputStream actual=getLink().createStream(setAdress());
        assertNotNull(actual);
    }

    @Test
    public void testCloseStream() throws Exception {
        FileInputStream actual=getLink().closeStream(setAdress());
        assertNull(actual);
    }
    @Test
    public void testCreateStringBuilder() throws Exception {
        StringBuilder actual=getLink().createStringBuilder();
        assertNotNull(actual);
    }

    @Test
    public void testNoPathSpecified() throws Exception {
        assertNotNull(setAdress());
    }

    @Test
    public void testFileNotFound() throws IOException {
        FileNotFoundException exception=null;
        assertTrue(FileNotFoundException(exception, setAdress()));
    }

    @Test
    public void testReadFile() throws IOException {
        IOException exception=null;
        assertTrue(IOException(exception, setAdress()));
    }

    private String setAdress(){
        String name ="/Users/vladimirlozickiy/Desktop/multimodule/exception-handling/src/main/resources/expression.txt";
        //  String name ="/Users/vladimirlozickiy/Desktop/multimodule/exception-handling/src/main/resources/empty.txt";
        return name;
    }
    private ReadToFile  getLink(){
        ReadToFile objectFile = new ReadToFile();
        return objectFile;
    }

    private int returnLengthExpression() throws Exception {
        return getLink().ReadToFile(setAdress()).length();
    }

    boolean FileNotFoundException(FileNotFoundException exception, String name) throws IOException {
        FileInputStream inputStream = null;
        getLink().getSourceExpression(inputStream, name);
        if(exception==null){
            return true;
        }else
            return false;
    }

    boolean IOException(IOException exception, String name) throws IOException {
        FileInputStream inputStream = null;
        getLink().getSourceExpression(inputStream, name);
        if(exception==null){
            return true;
        }else
            return false;
    }
}