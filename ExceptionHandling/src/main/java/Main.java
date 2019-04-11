import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    /**
     * @param args
     */
    public static void main(String args[]) throws Exception {
       ReadToFile file = new ReadToFile();
      file.ReadToFile("/Users/vladimirlozickiy/Desktop/multimodule/ExceptionHandling/src/main/java/expression.txt");
      file.get();
    }
}
