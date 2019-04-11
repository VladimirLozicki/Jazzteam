import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.AssertJUnit.assertEquals;

/**
 * class Test
 */
public class NumberTest {
    /**
     *  check answer
     */
    @Test
    public void testGetResult() {
        Number number=new Number();
        number.sourceExpression=number.ReadToFile("/Users/vladimirlozickiy/Desktop/multimodule/task1/src/main/resources/actual.txt");
        int actual=number.getResult(number.getNumbers());
        int decoded = number.getResult();
        assertEquals(actual, decoded);
    }
    /**
     *    check the correct of expression
     */
    @Test
    public void CorrectExpression() throws Exception {
        Number number = new Number();
        number.sourceExpression= number.ReadToFile("/Users/vladimirlozickiy/Desktop/multimodule/task1/src/main/resources/actual.txt");
        String y = number.CorrectExpression(number.sourceExpression);
        if(y.length()!=0){
            throw new Exception("Correct expression");
        }
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void CorrectExpr() throws Exception {
        Number number = new Number();
        number.sourceExpression = number.ReadToFile("/Users/vladimirlozickiy/Desktop/multimodule/task1/src/main/resources/actual.txt");
        int actual = number.sourceExpression.length();
        int expected = 1234;
        assertEquals(actual, getCountsOfDigits(expected));

    }
    /**
     *
     * @param number
     * @return
     */
    public int getCountsOfDigits(long number) {
        return String.valueOf(Math.abs(number)).length();
    }
}