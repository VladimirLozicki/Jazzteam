import java.util.ArrayList;
        import java.util.List;

public class Main {
    /**
     *
     * @param args
     */
    public static void main(String args []){
       start();
    }

    private static void start(){
        Number number = new Number();
        
        number.ReadToFile(
                "/Users/vladimirlozickiy/Desktop/multimodule/multiplication-number/src/main/resources/actual.txt");
        int value[] = new int[number.getNumbers().length];
        for(int i=0; i<value.length; i++){
            value[i]=number.getNumbers()[i];
        }
        System.out.println(number.getResult(value));
    }
}
