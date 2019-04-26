import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArrayContainerTest {
    ArrayContainer arrayContainer = new ArrayContainer();
    Iterator iterator = arrayContainer.getIterator();


//    @Test
//    public void testOneIteration() {
//        iterator.next();
//        assertEquals(iterator.next(), "1");
//    }
//
//    @Test
//    public void testTwoIteration() {
//        iterator.next();
//        iterator.next();
//        assertEquals(iterator.next(), "2");
//    }

    
    @Test
    public void testArray() {
        assertNotNull(arrayContainer.array.length);
    }



}