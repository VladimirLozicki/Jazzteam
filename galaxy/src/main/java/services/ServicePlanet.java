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

    public void savePlanet(Planet sattelite) {
        daoPlanet.save(sattelite);
    }

    public void deletePlanet(Planet sattelite) {
        daoPlanet.delete(sattelite);
    }

    public void updatePlanet(Planet sattelite) {
        daoPlanet.update(sattelite);
    }

    public void createPlanet(Planet sattelite) {
        daoPlanet.create(sattelite);
    }
}




