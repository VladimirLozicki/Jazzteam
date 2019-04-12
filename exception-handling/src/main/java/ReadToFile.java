import java.io.*;
import java.util.ArrayList;

public class ReadToFile {
      private String sourceExpression;
    ArrayList<Character> list = new ArrayList<>();
    public String ReadToFile(String name) throws Exception {
        FileInputStream inputStream=null;
        try {
             inputStream = new FileInputStream(name);
            int i=-1;
            StringBuilder br = new StringBuilder();
            while((i=inputStream.read())!=-1){
                list.add((char) i);
                br.append((char)i);
            }
            sourceExpression=br.toString();
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        catch (Exception exception){
            if(inputStream==null){
                 throw new Exception("file empty");
            }
        }
        finally {
            try{
                if(inputStream!=null)
                    inputStream.close();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        return sourceExpression;
    }
    public void get(){
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i));
        }
    }

}
