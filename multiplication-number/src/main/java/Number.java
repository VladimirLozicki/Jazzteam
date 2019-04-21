import java.io.*;
import java.util.logging.Logger;

class Number {

    private static final Logger logger = Logger.getGlobal();

    private String sourceExpression;

    // TODO Иван строку переделть на файл
    String getStringFromFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            while ((str = reader.readLine()) != null) {
                if (!str.isEmpty()) {
                    sourceExpression=str;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
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

}

