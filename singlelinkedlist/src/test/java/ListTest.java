import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ListTest {

    @Test
    public void testAddBackInteger() {
        List<Integer> ml = new List();
        ml.addBack(3);
        ml.addBack(2);
        ml.addBack(5);
        int i = 5;
        assertEquals(Integer.parseInt(ml.List().get(2)), i);
    }

    @Test
    public void testAddBackString() {
        List<String> ml = new List();
        ml.addBack("First");
        ml.addBack("Second");
        ml.addBack("Third");
        String expected = "Third";
        assertEquals(ml.List().get(2), expected);
    }

    @Test
    public void testDeleteBackElement() {
        List<Integer> ml = new List();
        ml.addBack(3);
        ml.addBack(2);
        ml.addBack(5);
        ml.deleteElement(2);
        int[] expected = {3, 5};
        assertEquals(ml.List().size(), expected.length);
    }

    @Test
    public void testAddFrontInteger() {
        List<Integer> ml = new List();
        ml.addFront(3);
        ml.addFront(2);
        ml.addFront(5);
        int i = 5;
        assertEquals(Integer.parseInt(ml.List().get(0)), i);
    }

    @Test
    public void testAddFrontString() {
        List<String> ml = new List();
        ml.addFront("First");
        ml.addFront("Second");
        ml.addFront("Third");
        String expected = "Third";
        assertEquals(ml.List().get(0), expected);
    }

}