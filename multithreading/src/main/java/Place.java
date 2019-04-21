import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Place {

    int[] place = {0, 0, 0, 0, 0, 0, 0, 0};
    private String places;
    public int takePlace(int i) {
        if (place[i] == 0) {
            place[i] = 1;
            return i;
        } else {
            return -1;
        }
    }

    String getStringFromFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            while ((str = reader.readLine()) != null) {
                if (!str.isEmpty()) {
                    places=str;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return places;
    }

}
