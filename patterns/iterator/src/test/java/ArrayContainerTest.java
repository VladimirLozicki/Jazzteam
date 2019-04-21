import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class ArrayContainerTest {
    ArrayContainer arrayContainer = new ArrayContainer();
    Iterator iterator = arrayContainer.getIterator();

    @Test
    public void testOneIteration() {
        assertEquals(getArrayList().get(1), "1");
    }

    @Test
    public void testThreeIteration() {
        assertEquals(getArrayList().get(3), "3");
    }

    @Test
    public void testArray() {
        assertNotNull(getArrayList());
    }

    @Test
    public void testHasNext() {
        assertTrue(iterator.hasNext());
    }

    public ArrayList getArrayList() {
        ArrayList<String> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next().toString());
        }
        return list;
    }

}