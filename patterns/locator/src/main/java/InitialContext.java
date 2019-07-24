public class InitialContext {
    public Object lookup(String serviceName) {
        if (serviceName.equalsIgnoreCase("Service1")) {
            return new Service1();
        } else if (serviceName.equalsIgnoreCase("Service2")) {
            return new Service2();
        }
        return null;
    }
}

