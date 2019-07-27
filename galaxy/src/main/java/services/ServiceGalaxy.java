package services;

import dao.DaoGalaxy;
import model.Galaxy.Galaxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:beans.xml")
public class ServiceGalaxy {

    @Qualifier("daoGalaxy")
    private DaoGalaxy daoGalaxy;

    /**
     * must be for beans
     */
    public ServiceGalaxy() {
    }

    public Galaxy find(int id) {
        return daoGalaxy.findById(id);
    }

    public void save(Galaxy galaxy) {
        daoGalaxy.save(galaxy);
    }

    public void delete(Galaxy galaxy) {
        daoGalaxy.delete(galaxy);
    }

    public ServiceGalaxy(DaoGalaxy provider) {
        this.daoGalaxy = provider;
    }
}