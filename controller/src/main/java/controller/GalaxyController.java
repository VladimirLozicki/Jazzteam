package controller;

import model.Galaxy;
import model.orbit.Orbit;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import services.ServiceGalaxy;

import javax.transaction.Transactional;

import static utils.HibernateSessionFactoryUtil.getSessionFactory;

@Controller
public class GalaxyController {
    private ServiceGalaxy serviceGalaxy = new ServiceGalaxy();
    private Galaxy galaxy;
    private String result = "result";

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

    @PostMapping(value = "/updateResult")
    public String getCurrent(ModelMap modelMap) {
        setSystem(modelMap, galaxy);
        return result;
    }

    @PostMapping(value = "/save")
    public String save(ModelMap modelMap) {
        serviceGalaxy.save(galaxy);
        setSystem(modelMap, galaxy);
        return result;
    }

    @Transactional
    @PostMapping(value = "/upload")
    public String upload(ModelMap modelMap) {
        galaxy = serviceGalaxy.find(getMaxId());
        Galaxy.setI(galaxy.get());
        galaxy.run();
        setSystem(modelMap, galaxy);
        return result;
    }

    private void setSystem(ModelMap modelMap, Galaxy galaxy) {
        modelMap.addAttribute("orbits", galaxy.getOrbit());
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