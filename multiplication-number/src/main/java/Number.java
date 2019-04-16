import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

class Number {

    private static final Logger logger = Logger.getGlobal();
    private String sourceExpression;

    String getStringFromFile(String name) {
        try {
            BufferedReader reader = createBuffer(name);
            String str;
            while ((str = reader.readLine()) != null) {
                if (!str.isEmpty()) {
                    sourceExpression = str;
                }
            }
            createBuffer(name);
        } catch (IOException e) {
            logger.info("Error" + e);
        }
        return sourceExpression;
    }

    int[] divisionExpression(String sourceExpression) {
        int k = Integer.parseInt(sourceExpression);
        int[] source = new int[sourceExpression.length()];
        for (int i = 0; i < sourceExpression.length(); i++) {
            source[i] = k % 10;
            k = k / 10;
        }
        return source;
    }

    int multiplicationOfNumbers(int[] numbers) {
        int result = 1;
        for (int i = 0; i < numbers.length; i++) {
            result *= numbers[i];
        }
        return result;
    }

    BufferedReader createBuffer(String name) throws FileNotFoundException {
        BufferedReader linkobject = new BufferedReader(new FileReader(name));
        return linkobject;
    }

}

