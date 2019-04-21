import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class ArrayContainerTest {
    ArrayContainer arrayContainer = new ArrayContainer();
    Iterator iterator = arrayContainer.getIterator();

    @Test
    public void testOneIteration() {
        ArrayList<String>list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next().toString());
        }
        assertEquals(list.get(1), "1");
    }   


    @Test(dataProvider = "data")
    public void testTheResult(String[] input) {
            assertEquals(arrayContainer.array, input[1]);
    }

    @DataProvider(name = "data")
    public Object[] getData() {
        return new Object[]{
                "1",
                "2",
                "3",
                "4",
                "5",
        };
    }

}