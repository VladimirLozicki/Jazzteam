package multiplication;

import java.io.*;
import java.util.logging.Logger;

public class MultiplicationNumber {

    private static final Logger logger = Logger.getGlobal();

    private String sourceExpression;

    // TODO Иван строку переделать на файл
  public  String getStringFromFile(File file) {
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

   public int[] divisionExpression(String sourceExpression) {
        int k = Integer.parseInt(sourceExpression);
        int[] source = new int[sourceExpression.length()];
        for (int i = 0; i < sourceExpression.length(); i++) {
            source[i] = k % 10;
            k = k / 10;
        }
        return source;
    }

   public int multiplicationOfNumbers(int[] numbers) {
        int result = 1;
        for (int i = 0; i < numbers.length; i++) {
            result *= numbers[i];
        }
        return result;
    }

}

