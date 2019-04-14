import java.util.concurrent.ThreadLocalRandom;

/**
 *
 */
 class Parking extends Thread {
    private Place res;
    Parking(Place res){
        this.res=res;
    }

     public void run() {
         synchronized (res) {
            checkPlace();
         }
    }
    private void checkPlace() {
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

