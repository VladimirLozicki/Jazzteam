import java.util.concurrent.ThreadLocalRandom;

/**
 *
 */
public class Parking extends Thread {
    Place res;
    Parking(Place res){
        this.res=res;
    }
    /**
     *
     */
     public void run() {
         synchronized (res) {
            checkPlace();
         }
    }
    public  void checkPlace() {
        int i;
        while(true){
           i= ThreadLocalRandom.current().nextInt(res.getSize());
            if(res.getPlaces()[i]==0) {
                res.getPlaces()[i] = 1;
                System.out.println(this.getId() + " припарковался на " + i);
                break;
            }
            try {
                Thread.sleep(100);
                Thread.interrupted();
            } catch (InterruptedException e) {
            }
        }
    }

}

