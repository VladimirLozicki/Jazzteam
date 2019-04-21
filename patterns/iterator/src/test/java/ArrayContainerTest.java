import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class ArrayContainerTest {
    ArrayContainer arrayContainer = new ArrayContainer();
    Iterator iterator = arrayContainer.getIterator();

    @Test
    public void testOneIteration() {
        ArrayList<String> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next().toString());
        }
        assertEquals(list.get(1), "1");
        assertEquals(list.get(3), "3");
    }

    @Test
    public void testHasNext() {
        assertTrue(iterator.hasNext());
    }





}
