package services;

import dao.DaoOrbit;
import model.orbit.Galaxy;
import model.orbit.Orbit;
import org.hibernate.Session;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

public class ServiceOrbit {

    private DaoOrbit daoOrbit = new DaoOrbit();

    public ServiceOrbit() {

    }

    public Galaxy find(int id) {
        return daoOrbit.findById(id);
    }

    public void save(Galaxy orbit) {
        daoOrbit.save(orbit);
    }

    public void delete(Galaxy orbit) {
        daoOrbit.delete(orbit);
    }

    public void update(Galaxy orbit) {
        daoOrbit.update(orbit);
    }

    public void create(Galaxy orbit) {
        daoOrbit.create(orbit);
    }

}