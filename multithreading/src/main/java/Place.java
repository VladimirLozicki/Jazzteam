class Place {
    int[] place = {0, 0, 0, 0, 0, 0, 0, 0};
    public int takePlace(int i) {
        if (place[i] == 0) {
            place[i] = 1;
            return i;
        } else {
            return -1;
        }
    }

}
