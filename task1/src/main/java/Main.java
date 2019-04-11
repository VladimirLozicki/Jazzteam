import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     *
     * @param args
     */
    public static void main(String args []){
       Number number = new Number();
       number.sourceExpression=number.ReadToFile("/Users/vladimirlozickiy/Desktop/multimodule/task1/src/main/resources/actual.txt");
        int value[] = new int[number.getNumbers().length];
        for(int i=0; i<value.length; i++){
            value[i]=number.getNumbers()[i];
        }
        number.result=number.getResult(value);
        System.out.println(number.result);
    }
}
