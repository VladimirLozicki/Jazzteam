public class OS {

    private static OS instance;
    public String name;

    String getName() {
        return name;
    }

    private OS(String name) {
        this.name = name;
    }

    public static OS getInstance(String name) {
        if (instance == null) {
            instance = new OS(name);
        }
        return instance;
    }
}
