public class Computer {
    Power power = new Power();
    USB usb = new USB();
    HDD hdd = new HDD();


    boolean copy() {
        if (power.on() == "Power On" && usb.load() == true) {
            power.on();
            usb.load();
            hdd.copyFromUSB(usb);
            return true;
        } else {
            return false;
        }

    }

    String PowerOn() {
        return power.on();
    }


    String PowerOff() {
        return power.off();
    }


}
