import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        start();
    }

    private static void start(){
        ReadToFile file = new ReadToFile();
        try {
            file.ReadToFile("/Users/vladimirlozickiy/Desktop/multimodule/exception-handling/src/main/java/expression.txt");
            file.get();
        }catch (Exception ex){
            ex.getMessage();
        }
    }
}
