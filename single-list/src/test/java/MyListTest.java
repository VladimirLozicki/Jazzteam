import mylist.MyList;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class MyListTest {

    @Test
    public void testAddBackInteger() {
        MyList<Integer> myList = new MyList();
        myList.addBack(3);
        myList.addBack(2);
        String expected = "2";
        assertEquals(myList.List().get(1), expected);
    }

    @Test
    public void testDeleteBackElement() {
        MyList<Integer> myList = new MyList();
        myList.addFront(3);
        myList.addFront(2);
        String expected = "2";
        assertEquals(myList.List().get(0), expected);
    }

    @Test
    public void testDeleteFirstElement() {
        MyList<Integer> myList = new MyList();
        myList.addBack(5);
        myList.deleteElement(5);
        assertNotNull(myList.List().size());
    }

}