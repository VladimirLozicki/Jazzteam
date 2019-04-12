import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    /**
     *
     * @param args
     */
    private  static final int COUNT=33;
    public static void main(String args []){
        Place place = new Place();
        for(int i=0; i<COUNT; i++){
            Thread thread= new Thread(new Parking(place));
          thread.start();

      }
    }
    public static int getCount(){
        return COUNT;
    }

    }