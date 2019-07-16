package model.controller;

import model.orbit.Orbit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import services.ServiceOrbit;


@Controller
public class OrbitController {
    @GetMapping(value = "/")
    public String index() {
        return "/index";
    }

    @GetMapping(value = "/planet")
    public ModelAndView orbit() {
        return new ModelAndView("planet", "command", new Orbit());
    }

    @PostMapping(value = "/addOrbit")
    public String addOrbit(@ModelAttribute("mvc-dispatcher") Orbit orbit,
                           ModelMap model) {
        setOrbit(model, orbit);
        save(orbit);
        return "result";
    }

    @GetMapping(value = "/getSystem")
    public String getO(ModelMap model) {
        ServiceOrbit service = new ServiceOrbit();
        Orbit orbit = service.find(129);
        getOrbit(orbit, model);
        return "new";
    }

    private void save(Orbit orbit) {
        ServiceOrbit service = new ServiceOrbit();
        service.create(orbit);
    }

    @PostMapping(value = "/save")
    public String saveOrbit(@ModelAttribute("command") Orbit orbit, ModelMap modelMap) {
        ServiceOrbit serviceOrbit = new ServiceOrbit();
        serviceOrbit.save(orbit);
        return "result";
    }


    @PostMapping(value = "/get")
    public String getOrbit(Orbit orbit, ModelMap modelMap) {
        setOrbit(modelMap, orbit);
        return "new";
    }


    public void setOrbit(ModelMap model, Orbit orbit) {
        model.addAttribute("weight", orbit.getPlanet().getWeight());
        model.addAttribute("radius", orbit.getPlanet().getRadius());
        model.addAttribute("planet_name", orbit.getPlanet().getName());
        model.addAttribute("satellite_name", orbit.getSatellite().getName());
        model.addAttribute("velocity", orbit.getSatellite().getVelocity());
        model.addAttribute("height", orbit.getHeight());
        model.addAttribute("acceleration", orbit.getAcceleration());
        model.addAttribute("time", orbit.getTime());
        model.addAttribute("result", orbit.getStateOfSystem());
        model.addAttribute("result1", orbit.getVelocity());
        model.addAttribute("result2", orbit.getWay());
    }
}