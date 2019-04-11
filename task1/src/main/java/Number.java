import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 */
public class Number {
    /**
     *
     */
    public String sourceExpression;
    public int result;
    private static final int VALUE = 24;
    /**
     * read to file
     * @param name
     * @return
     */
    public String ReadToFile(String name) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(name));
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
    /**
     *
     * @return
     */
    public int []  getNumbers(){
        int k = Integer.parseInt(sourceExpression);
        int [] numbers = new int[sourceExpression.length()];
        for (int i = 0; i <sourceExpression.length(); i++) {
            numbers[i] = k % 10;
            k = k / 10;
        }
        return numbers;
    }
    /**
     *
     * @param numbers
     */
    public int getResult(int [] numbers){
           int result=1;
           for(int i=0; i<numbers.length; i++){
               result*=numbers[i];
           }
        return result;
    }
    /**
     *
     * @param s
     * @return
     */
    public  String CorrectExpression(String s){
        StringBuilder sb = new StringBuilder(s.length());
        for(int i = 0; i < s.length(); i++){
            char p = s.charAt(i);
            if(p < 47 || p > 58 ){
                sb.append(p);
            }
        }
        return sb.toString();
    }

    /**
     *
     * @return
     */
    public String getSourceExpression(){
        return sourceExpression;
    }
    public int getResult(){
        return VALUE;
    }

}
