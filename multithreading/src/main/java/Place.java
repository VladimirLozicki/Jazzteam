class Place {

    public int[] getPlace() {
        return place;
    }

    int[] place={0, 0, 0, 0, 0, 0, 0, 0};
    private String places;
    public int takePlace(int i) {
        if (place[i] == 0) {
            place[i] = 1;
            return i;
        } else {
            return -1;
        }
    }

}
