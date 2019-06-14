package services;

import dao.DaoSatellite;
import model.planet.Satellite;

public class ServiceSattelite {

    private DaoSatellite daoSatellite = new DaoSatellite();

    public ServiceSattelite() {

    }

    public Satellite findUser(int id) {
        return daoSatellite.findById(id);
    }

    public void saveSattelite(Satellite satellite) {
        daoSatellite.save(satellite);
    }

    public void deleteSattelite(Satellite satellite) {
        daoSatellite.delete(satellite);
    }

    public void updateSattelite(Satellite satellite) {
        daoSatellite.update(satellite);
    }

    public void createSattelite(Satellite satellite) {
        daoSatellite.create(satellite);
    }
}