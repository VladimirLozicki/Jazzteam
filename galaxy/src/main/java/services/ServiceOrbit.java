package services;

import dao.DaoOrbit;
import model.orbit.Orbit;
import org.springframework.ui.ModelMap;

public class ServiceOrbit {
    private DaoOrbit daoPlanet = new DaoOrbit();

    public ServiceOrbit() {

    }

    public Orbit findUser(int id) {
        return daoPlanet.findById(id);
    }

    public void save(Orbit orbit) {
        daoPlanet.save(orbit);
    }

    public void delete(Orbit orbit) {
        daoPlanet.delete(orbit);
    }

    public void update(Orbit orbit) {
        daoPlanet.update(orbit);
    }

    public void create(Orbit orbit) {
        daoPlanet.create(orbit);
    }
}
