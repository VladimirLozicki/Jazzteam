import mylist.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MyListTest {

    @Test
    public void testAddBackInteger() {
        MyList<Integer> ml = new MyList();
        ml.addBack(3);
        ml.addBack(2);
        ml.addBack(5);
        int i = 5;
        assertEquals(Integer.parseInt(ml.List().get(2)), i);
    }

    @Test
    public void testAddBackString() {
        MyList<String> ml = new MyList();
        ml.addBack("First");
        ml.addBack("Second");
        ml.addBack("Third");
        String expected = "Third";
        assertEquals(ml.List().get(2), expected);
    }

    @Test
    public void testDeleteBackElement() {
        MyList<Integer> ml = new MyList();
        ml.addBack(3);
        ml.addBack(2);
        ml.addBack(5);
        ml.deleteElement(2);
        int[] expected = {3, 5};
        assertEquals(ml.List().size(), expected.length);
    }

    @Test
    public void testAddFrontInteger() {
        MyList<Integer> ml = new MyList();
        ml.addFront(3);
        ml.addFront(2);
        ml.addFront(5);
        int i = 5;
        assertEquals(Integer.parseInt(ml.List().get(0)), i);
    }

    @Test
    public void testAddFrontString() {
        MyList<String> ml = new MyList();
        ml.addFront("First");
        ml.addFront("Second");
        ml.addFront("Third");
        String expected = "Third";
        assertEquals(ml.List().get(0), expected);
    }

}