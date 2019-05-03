import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayContainerTest {
    ArrayContainer arrayContainer = new ArrayContainer();
    // TODO  добавить негативные тесты
    @Test
    public void testOneIteration() {
        assertEquals(getsIterator(1), "1");
    }

    @Test
    public void testTwoIteration() {
        assertEquals(getsIterator(2), "2");
    }

    @Test
    public void testThreeIteration() {
        assertEquals(getsIterator(3), "3");
    }

    @Test
    public void testFourIteration() {
        assertEquals(getsIterator(4), "4");
    }

    @Test
    public void testFiveIteration() {
        assertEquals(getsIterator(5), "5");
    }

    @Test
    public void testSixIteration() {
        assertEquals(getsIterator(6), "6");
    }

    @Test
    public void testArray() {
        assertNotNull(arrayContainer.array.length);
    }

    public Object getsIterator(int count) {

        Iterator iterator= arrayContainer.getIterator();
        for (int i = 0; i < count; i++) {
            iterator.next();
        }
        return iterator.next();
    }


}