public class HDD {
    boolean copyFromUSB(USB usb) {
        if (usb.hasData()) {
            return true;
        } else {
            return false;
        }
    }
}
