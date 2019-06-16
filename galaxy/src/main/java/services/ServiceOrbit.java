package services;

import com.sun.org.apache.xpath.internal.operations.Or;
import dao.DaoOrbit;
import dao.DaoPlanet;
import model.orbita.Orbit;
import model.planet.Planet;

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

//    public void deletePlanet(Planet satellite) {
//        daoPlanet.delete(satellite);
//    }
//
    public void updatePlanet(Orbit satellite) {
        //daoPlanet.update(satellite);
    }
//
//    public void createPlanet(Planet satellite) {
//        daoPlanet.create(satellite);
//    }

}
