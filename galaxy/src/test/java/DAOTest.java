import DAO.DAO;
import config.DAOSatelliteConfig;
import model.planet.Sattelite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import javax.transaction.Transactional;


@Transactional
@ContextConfiguration(classes = {config.HibernateConf.class, DAOSatelliteConfig.class})
public class DAOTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private DAO dao;


    @Test
    public void testCreate() {
        Sattelite sattelite = new Sattelite();
        dao.create(sattelite);


    }

    @Test
    public void testUpdate() {

    }

    @Ignore
    @Test
    public void testDelete() {
    }

    @Ignore
    @Test
    public void testFind() {
    }
}