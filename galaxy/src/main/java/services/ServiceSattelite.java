package services;

import dao.DaoSattelite;
import model.planet.Satellite;

public class ServiceSattelite {

    private DaoSattelite daoSattelite = new DaoSattelite();

    public ServiceSattelite() {

    }

    public Satellite findUser(int id) {
        return daoSattelite.findById(id);
    }

    public void saveSattelite(Satellite satellite) {
        daoSattelite.save(satellite);
    }

    public void deleteSattelite(Satellite satellite) {
        daoSattelite.delete(satellite);
    }

    public void updateSattelite(Satellite satellite) {
        daoSattelite.update(satellite);
    }

    public void createSattelite(Satellite satellite) {
        daoSattelite.create(satellite);
    }
}