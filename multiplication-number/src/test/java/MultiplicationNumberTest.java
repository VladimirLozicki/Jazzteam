import multiplication.MultiplicationNumber;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

// TODO больше негативных тестов
public class MultiplicationNumberTest {
    File name = new File("./src/main/resources/expression.txt");

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
                {"1234", "24"},
                {"1479", "252"},
                {"0000", "0"},
                {"832", "48"},

        };
    }

    @Test
    public void testCheckReadFile() {
        assertTrue(name.canRead());
    }

    @Test
    public void testCheckWriteFile() {
        assertTrue(name.canWrite());
    }

    @Test
    public void testCheckExists() {
        assertTrue(name.exists());
    }


    @Test
    public void testCheckIsFile() {
        assertTrue(name.isFile());
    }

    @Test
    public void testDivisionExpression() {
        int[] expected = {4, 3, 2, 1};
        assertEquals(getLink().divisionExpression(getLink().getStringFromFile(name)), expected);
    }

    @Test
    public void testOnSpaces() {
        assertTrue(containsWhiteSpace(getLink().getStringFromFile(name)));
    }


    @Test(dataProvider = "exp")
    public void testOnOtherCharacters(String[] input) {
        assertFalse(isNumeric(input[0]));
    }


    // TODO Иван убрать избыточную логику из тестов


    private MultiplicationNumber getLink() {
        MultiplicationNumber object = new MultiplicationNumber();
        return object;
    }


// TODO Иван параметризировать сигнатуру метода


    private boolean expectedLengthExpression(String s) {
        if (s.length() != 4) {
            return false;
        } else {
            return true;
        }
    }


    @Test(dataProvider = "expression")
    public void testExpectedLengthExpression(String[] input) {
        assertFalse(expectedLengthExpression(input[0]));
    }

    @DataProvider(name = "expression")
    public Object[] getFalseData() {
        return new Object[]{
                "1",
                "42",
                "835",
                "63718",
                "0",
                "637",
                ""

        };
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

    private boolean isNumeric(String str) {
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @DataProvider(name = "exp")
    public Object[] checkCharacter() {
        return new Object[]{
                ".",
                ">>>>*",
                "<>%@()(!#)",
                ",",
                "__",
                "±",

        };
    }
}