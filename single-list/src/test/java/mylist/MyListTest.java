package mylist;

import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.testng.Assert.*;

public class MyListTest {

    @Test
    public void testAddFront() {
        MyList<Integer> myList = new MyList();
        myList.addBack(5);
        myList.deleteElement(5);
        assertNotNull(myList.List().size());
    }

    @Test
    public void testAddBack() {
        MyList<Integer> myList = new MyList();
        myList.addBack(3);
        myList.addBack(2);
        String expected = "2";
        assertEquals(myList.List().get(1), expected);
    }

    @Test
    public void testDeleteElement() {
        MyList<Integer> myList = new MyList();
        myList.addFront(3);
        myList.addFront(2);
        String expected = "2";
        assertEquals(myList.List().get(0), expected);
    }

}