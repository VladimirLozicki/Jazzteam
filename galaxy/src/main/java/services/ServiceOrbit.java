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

    public void savePlanet(Orbit satellite) {
        daoPlanet.save(satellite);
    }

    public void deletePlanet(Orbit satellite) {
        daoPlanet.delete(satellite);
    }

    public void updatePlanet(Orbit satellite) {
        daoPlanet.update(satellite);
    }

    public void createPlanet(Orbit satellite) {
        daoPlanet.create(satellite);
    }
}
