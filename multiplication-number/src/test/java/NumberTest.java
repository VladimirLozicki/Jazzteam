import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class NumberTest {
    @Test(dataProvider = "data")
    public void testTheResult(String[] input) {
        int actual = getLink().multiplicationOfNumbers(
                getLink().divisionExpression(input[0]));
        int expected = Integer.parseInt(input[1]);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return new Object[][]{
                {"1234", "24" },
                {"1479", "252" },
                {"0000", "0" },

        };
    }

    @Test
    public void testDivisionExpression() {
        int[] expected = {4, 3, 2, 1};
        assertEquals(getLink().divisionExpression(getExpressionOfFile()), expected);
    }

    @Test
    public void testLengthExpression() {
        assertTrue(expectedLengthExpression());
    }

    @Test
    public void testOnSpaces() {
        assertTrue(containsWhiteSpace(getExpressionOfFile()));
    }

    @Test
    public void testOnOtherCharacters() {
        String actual = getExpressionOfFile();
        assertTrue(сheckOtherCharacters(actual));
    }

    private boolean сheckOtherCharacters(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            switch (p) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '(':
                case ')':
                    sb.append(p);
            }
            if ((p < 47 || p > 58)) {
                sb.append(p);
            }
        }
        if (sb.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private String getExpressionOfFile() {
        String line = getLink().getStringFromFile(setAddress());
        return line;
    }

    private Number getLink() {
        Number object = new Number();
        return object;
    }

    private String setAddress() {
        String name = new File("src/main/resources/expression.txt").getAbsolutePath();
        return name;
    }


    boolean expectedLengthExpression() {
        if (getExpressionOfFile().length() != 4) {
            return false;
        } else {
            return true;
        }
    }

    private boolean containsWhiteSpace(String sourceExpression) {
        char[] chArray = sourceExpression.toCharArray();
        for (int i = 0; i < chArray.length; i++) {
            if (chArray[i] == ' ') {
                return false;
            }
        }
        return true;
    }

}