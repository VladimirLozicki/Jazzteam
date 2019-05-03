import mylist.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MyListTest {

    @Test
    public void testAddBackInteger() {
        MyList<Integer> myList = new MyList();
        myList.addBack(3);
        myList.addBack(2);
        myList.addBack(5);
        int i = 5;
        assertEquals(Integer.parseInt(myList.List().get(2)), i);
    }

    @Test
    public void testAddBackString() {
        MyList<String> myList = new MyList();
        myList.addBack("First");
        myList.addBack("Second");
        myList.addBack("Third");
        String expected = "Third";
        assertEquals(myList.List().get(2), expected);
    }

    @Test
    public void testDeleteBackElement() {
        MyList<Integer> myList = new MyList();
        myList.addBack(3);
        myList.addBack(2);
        myList.addBack(5);
        myList.deleteElement(2);
        int[] expected = {3, 5};
        assertEquals(myList.List().size(), expected.length);
    }

    @Test
    public void testAddFrontInteger() {
        MyList<Integer> myList = new MyList();
        myList.addFront(3);
        myList.addFront(2);
        myList.addFront(5);
        int i = 5;
        assertEquals(Integer.parseInt(myList.List().get(0)), i);
    }

    @Test
    public void testAddFrontString() {
        MyList<String> myList = new MyList();
        myList.addFront("First");
        myList.addFront("Second");
        myList.addFront("Third");
        String expected = "Third";
        assertEquals(myList.List().get(0), expected);
    }

}