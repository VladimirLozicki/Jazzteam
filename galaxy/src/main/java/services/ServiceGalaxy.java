package services;

import dao.GalaxyDao;
import model.galaxy.Galaxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:beans.xml")
public class ServiceGalaxy {

    @Qualifier("daoGalaxy")
    private GalaxyDao galaxyDao;

    public ServiceGalaxy() {
        /*
         * must be for beans
         */
    }

    public ServiceGalaxy(GalaxyDao provider) {
        this.galaxyDao = provider;
    }

    public Galaxy find(int id) {
        return galaxyDao.findById(id);
    }

    public void save(Galaxy galaxy) {
        galaxyDao.save(galaxy);
    }

    public void delete(Galaxy galaxy) {
        galaxyDao.delete(galaxy);
    }


}