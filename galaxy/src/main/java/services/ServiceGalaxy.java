package services;

import dao.DaoOrbit;
import model.Galaxy;


public class ServiceGalaxy {

    private DaoOrbit daoOrbit = new DaoOrbit();


    public Galaxy find(int id) {
        return daoOrbit.findById(id);
    }

    public void save(Galaxy galaxy) {
        daoOrbit.save(galaxy);
    }

    public void delete(Galaxy galaxy) {
        daoOrbit.delete(galaxy);
    }

    public void update(Galaxy galaxy) {
        daoOrbit.update(galaxy);
    }

    public void create(Galaxy galaxy) {
        daoOrbit.create(galaxy);
    }

}