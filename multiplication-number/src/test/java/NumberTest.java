import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.testng.Assert.*;

public class NumberTest {
    
    @Test
    public void testLengthExpression() throws IOException {
        int actual = Integer.parseInt(String.valueOf(
                getLink().createBuffer(setAdress()).readLine().length()));
        int expected=3;
        assertEquals(actual, expected);
    }

    @Test
    public void createBuffer() throws FileNotFoundException {
        assertNotNull((getLink().createBuffer(setAdress())));
    }

    @Test
    public void closeBuffer() throws IOException {
        assertNull(getLink().closeBuffer(setAdress()));
    }

    @Test
    public void testTheResult(){
        int actual = getLink().multiplicationOfNumbers(
                getLink().divisionExpression(sourceExpression()));
        int expected=6;
        assertEquals(actual, expected);
    }

    @Test
    public void testInputOnSpaces() {
       String actual=sourceExpression();
       assertFalse(containsWhiteSpace(actual));
    }

     @Test
     public void testInputOnOtherSymbols() {
         String actual = sourceExpression();
         assertTrue(сheckOtherCharacters(actual));
     }







    private boolean сheckOtherCharacters(String s ){
        StringBuilder sb = new StringBuilder(s.length());
        for(int i = 0; i < s.length(); i++){
            char p = s.charAt(i);
            switch (p){
                case '+':
                case '-':
                case '*':
                case '/':
                case '(':
                case ')':
                    sb.append(p);
            }
            if((p < 47 || p > 58)){
                sb.append(p);
            }
        }
        if(sb.length()==0){
           return true;
        }
        else {
           return false;
        }
    }

    private String sourceExpression(){
        String line=getLink().getStringFromFile(setAdress());
        return line;
    }

    private Number getLink(){
        Number object=new Number();
        return object;
    }

    private  boolean containsWhiteSpace(String sourceExpression){
        if(sourceExpression != null){
            for(int i = 0; i < sourceExpression.length(); i++){
                if(Character.isWhitespace(sourceExpression.charAt(i))){
                    return true;
                }
            }
        }
        return false;
    }


    private String setAdress(){
        String name =
                "/Users/vladimirlozickiy/Desktop/multimodule/multiplication-number/src/main/resources/expression.txt";
        //  String name ="/Users/vladimirlozickiy/Desktop/multimodule/exception-handling/src/main/resources/empty.txt";
       // String name = null;
        return name;
    }

    boolean IOException(IOException exception, String name){
        getLink().getStringFromFile(name);
        if(exception==null){
            return true;
        }else
            return false;
    }
}