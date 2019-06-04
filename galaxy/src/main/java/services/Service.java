package services;

import dao.DAO;
import model.planet.Sattelite;

public class Service {

    private DAO dao = new DAO();

    public Service() {

    }

    public Sattelite findUser(int id) {
        return dao.findById(id);
    }

    public void saveSattelite(Sattelite sattelite) {
        dao.save(sattelite);
    }

    public void deleteSattelite(Sattelite sattelite) {
        dao.delete(sattelite);
    }

    public void updateSattelite(Sattelite sattelite) {
        dao.update(sattelite);
    }

    public void createSattelite(Sattelite sattelite) {
        dao.create(sattelite);
    }
}