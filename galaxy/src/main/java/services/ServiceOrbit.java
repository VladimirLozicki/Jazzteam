package services;

import dao.DaoOrbit;
import model.orbit.Orbit;
import org.hibernate.Session;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

public class ServiceOrbit {

    private DaoOrbit daoOrbit = new DaoOrbit();

    public ServiceOrbit() {

    }

    public Orbit find(int id) {
        return daoOrbit.findById(id);
    }

    public void save(Orbit orbit) {
        daoOrbit.save(orbit);
    }

    public void delete(Orbit orbit) {
        daoOrbit.delete(orbit);
    }

    public void update(Orbit orbit) {
        daoOrbit.update(orbit);
    }

    public void create(Orbit orbit) {
        daoOrbit.create(orbit);
    }

}
