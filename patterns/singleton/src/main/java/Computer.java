public class Computer {
    public OS os;

    public void Launch(String osName)
    {
        os = os.getInstance(osName);
    }
}
