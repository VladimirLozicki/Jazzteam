package control;

import model.galaxy.Galaxy;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import services.ServiceGalaxy;
import javax.transaction.Transactional;
import static utils.HibernateSessionFactoryUtil.getSessionFactory;

@Controller
public class GalaxyController {

    @Qualifier("serviceGalaxy")
    private ServiceGalaxy serviceGalaxy;

    @Qualifier("galaxy")
    private Galaxy galaxy;

    private String result = "result";

    public GalaxyController(ServiceGalaxy serviceGalaxy) {
        this.serviceGalaxy = serviceGalaxy;
    }

    @GetMapping(value = "/")
    public String galaxyPage() {
        return "/galaxy";
    }

    @GetMapping(value = "/result")
    public String getResult(ModelMap modelMap) {
        setSystem(modelMap, galaxy);
        return result;
    }

    @PostMapping(value = "/galaxy")
    public String startSystem(@RequestBody Galaxy galaxyFromJson) {
        galaxy = galaxyFromJson;
        galaxy.run();
        return result;
    }

    @PostMapping(value = "/back")
    public String back() {
        galaxy.killTime();
        return "/galaxy";
    }

    @PostMapping(value = "/new")
    public String save(ModelMap modelMap) {
        serviceGalaxy.save(galaxy);
        setSystem(modelMap, galaxy);
        return result;
    }

    @Transactional
    @PostMapping(value = "/upload")
    public String upload(ModelMap modelMap) {
        galaxy = serviceGalaxy.find(getMaxId());
        Galaxy.setI(galaxy.getTime());
        galaxy.run();
        setSystem(modelMap, galaxy);
        return result;
    }

    private void setSystem(ModelMap modelMap, Galaxy galaxy) {
        modelMap.addAttribute("orbits", galaxy.getOrbits());
        modelMap.addAttribute("time", galaxy.getTime());
        modelMap.addAttribute("weight", galaxy.getMassiveAstronomicalObject().getWeight());
        modelMap.addAttribute("radius", galaxy.getMassiveAstronomicalObject().getRadius());
    }

    private int getMaxId() {
        Session session = getSessionFactory().openSession();
        int id = (int) session.createSQLQuery("select max(id) from galaxy")
                .uniqueResult();
        session.close();
        return id;
    }
}