public class Main {

    private  static final int COUNT=33;
    public static void main(String args []){
        Place place = new Place();
        for(int i=0; i<COUNT; i++){
            Thread thread= new Thread(new Parking(place));
          thread.start();

      }
    }

    }