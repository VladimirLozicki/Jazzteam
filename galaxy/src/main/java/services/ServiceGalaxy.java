package services;

import dao.DaoGalaxy;
import model.Galaxy.Galaxy;


public class ServiceGalaxy {

    private DaoGalaxy daoGalaxy = new DaoGalaxy();


    public Galaxy find(int id) {
        return daoGalaxy.findById(id);
    }

    public void save(Galaxy galaxy) {
        daoGalaxy.save(galaxy);
    }

    public void delete(Galaxy galaxy) {
        daoGalaxy.delete(galaxy);
    }

    public void update(Galaxy galaxy) {
        daoGalaxy.update(galaxy);
    }

}