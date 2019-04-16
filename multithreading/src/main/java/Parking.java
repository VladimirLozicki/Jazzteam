class Parking implements Runnable {
    Place res;

    Parking(Place res) {
        this.res = res;
    }

    public void run() {
        synchronized (res) {
            for (int j = 0; j < res.place.length; j++) {
                if (res.place[j] == 0) {
                    res.takePlace(j);
                    break;
                }
            }
            Thread.interrupted();
        }
    }
}