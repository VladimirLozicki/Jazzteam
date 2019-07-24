package controller;
import model.orbit.Galaxy;
import model.orbit.Orbit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import services.ServiceGalaxy;

import javax.transaction.Transactional;


@Controller
public class GalaxyController {
    ServiceGalaxy serviceGalaxy = new ServiceGalaxy();
    Galaxy galaxy;

    @GetMapping(value = "/")
    public String index() {
        return "/index";
    }

    @GetMapping(value = "/galaxy")
    public ModelAndView orbit() {
        return new ModelAndView("galaxy", "command", new Orbit());
    }

    @GetMapping(value = "/result")
    public String getResult(ModelMap modelMap) {
        setSystem(modelMap, galaxy);
        return "result";
    }

    @PostMapping(value = "/galaxy")
    public String add(@RequestBody Galaxy galaxy1) {
        galaxy=galaxy1;
        galaxy1.run();
        return "result";
    }

    @PostMapping(value = "/res")
    public String getResults(ModelMap modelMap) {
        setSystem(modelMap, galaxy);
        return "result";
    }

    @PostMapping(value = "/save")
    public String save(ModelMap modelMap) {
        serviceGalaxy.create(galaxy);
        setSystem(modelMap, galaxy);
        return "result";
    }

    @Transactional
    @PostMapping(value = "/upload")
    public String upload(ModelMap modelMap) {
        galaxy = serviceGalaxy.find(132);
        Galaxy.setI(galaxy.get());
        galaxy.run();
        setSystem(modelMap, galaxy);
        return "result";
    }

    private void setSystem(ModelMap modelMap, Galaxy galaxy) {
        modelMap.addAttribute("orbits", galaxy.getOrbit());
        modelMap.addAttribute("time", galaxy.getTime());
        modelMap.addAttribute("weight", galaxy.getMassiveAstronomicalObject().getWeight());
        modelMap.addAttribute("radius", galaxy.getMassiveAstronomicalObject().getRadius());
    }
}