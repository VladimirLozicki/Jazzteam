public class ServiceLocator {
    private static Cache cache = new Cache();

    public static Service getService(String serviceName) {
        Service service = cache.getServices(serviceName);
        if (service != null) {
            return service;
        }
        InitialContext context = new InitialContext();
        Service service1 = (Service) context.lookup(serviceName);
        cache.addService(service1);
        return service1;
    }
}