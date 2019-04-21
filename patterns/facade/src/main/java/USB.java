public class USB {
    private boolean usbFlash = false;

    public boolean hasData() {
        return usbFlash;
    }

    boolean load() {
        usbFlash = true;
        return usbFlash;
    }

    boolean unload() {
        usbFlash = false;
        return usbFlash;
    }
}
