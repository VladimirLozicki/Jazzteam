package services;

import dao.DaoPlanet;
import model.planet.Planet;

public class ServicePlanet {
    private DaoPlanet daoPlanet = new DaoPlanet();

    public ServicePlanet() {

    }

    public Planet findUser(int id) {
        return daoPlanet.findById(id);
    }

    public void savePlanet(Planet satellite) {
        daoPlanet.save(satellite);
    }

    public void deletePlanet(Planet satellite) {
        daoPlanet.delete(satellite);
    }

    public void updatePlanet(Planet satellite) {
        daoPlanet.update(satellite);
    }

    public void createPlanet(Planet satellite) {
        daoPlanet.create(satellite);
    }
}




