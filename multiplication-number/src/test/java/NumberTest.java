
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

/**
 * class Test
 */
public class NumberTest {

    Number number=new Number();
    String s =number.getSourceExpression();
    String name="/Users/vladimirlozickiy/Desktop/multimodule/multiplication-number/src/main/resources/actual.txt";
    @Test
    public void testGetResult() {
        s=number.ReadToFile(name);
        int actual=number.getResult(number.getNumbers());
        int decoded = number.getResult();
        assertEquals(actual, decoded);
    }

    @Test
    public void CorrectExpression() throws Exception {
        Number number = new Number();
        s= number.ReadToFile(name);
        assertFalse(number.CorrectExpression(s));
    }

    @Test
    public void CorrectExpr() throws Exception {
        Number number = new Number();
        s= number.ReadToFile(name);
        int actual = s.length();
        int expected = 1234;
        assertEquals(actual, getCountsOfDigits(expected));

    }

    public int getCountsOfDigits(long number) {
        return String.valueOf(Math.abs(number)).length();
    }
}