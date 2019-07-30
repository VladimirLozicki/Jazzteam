package services;

import dao.DaoGalaxy;
import model.galaxy.Galaxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:beans.xml")
public class ServiceGalaxy {

    @Qualifier("daoGalaxy")
    private DaoGalaxy daoGalaxy;

    public ServiceGalaxy() {
        /*
         * must be for beans
         */
    }

    public ServiceGalaxy(DaoGalaxy provider) {
        this.daoGalaxy = provider;
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


}