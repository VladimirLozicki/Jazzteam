package model.controller;

import model.orbit.Orbit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    Orbit orbit1;

    @GetMapping(value = "/planet")
    public ModelAndView orbit() {
        return new ModelAndView("planet", "command", new Orbit());
    }

    @PostMapping(value = "/addOrbit")
    public String addOrbit(@ModelAttribute("mvc-dispatcher") Orbit orbit,
                           ModelMap model) {
        // model.addAttribute(orbit);
        model.addAttribute("weight", orbit.getPlanet().getWeight());
        model.addAttribute("radius", orbit.getPlanet().getRadius());
        model.addAttribute("planet_name", orbit.getPlanet().getName());
        model.addAttribute("satellite_name", orbit.getSatellite().getName());
        model.addAttribute("velocity", orbit.getSatellite().getVelocity());
        model.addAttribute("height", orbit.getHeight());
        model.addAttribute("acceleration", orbit.getAcceleration());
        model.addAttribute("time", orbit.getTime());
        model.addAttribute("result", orbit.getMessage());
        model.addAttribute("result1", orbit.getVelocity());
        model.addAttribute("result2", orbit.getWay());
        save(orbit);
        return "result";
    }

    public void save(Orbit orbit) {
        ServiceOrbit service = new ServiceOrbit();
        service.save(orbit);

    }

    @PostMapping(value = "/save")
    public String saveOrbit(Orbit orbit) {
        ServiceOrbit serviceOrbit = new ServiceOrbit();
        serviceOrbit.save(orbit);
        return "result";
    }


    @GetMapping(value = "/get")
    public String getOrbit(Model modelMap) {
        ServiceOrbit service = new ServiceOrbit();
        Orbit orbit = service.find(4);
        modelMap.addAttribute("weight", orbit.getPlanet().getWeight());
        modelMap.addAttribute("weight", orbit.getPlanet().getWeight());
        modelMap.addAttribute("radius", orbit.getPlanet().getRadius());
        modelMap.addAttribute("planet_name", orbit.getPlanet().getName());
        modelMap.addAttribute("satellite_name", orbit.getSatellite().getName());
        modelMap.addAttribute("velocity", orbit.getSatellite().getVelocity());
        modelMap.addAttribute("height", orbit.getHeight());
        modelMap.addAttribute("acceleration", orbit.getAcceleration());
        modelMap.addAttribute("time", orbit.getTime());
        modelMap.addAttribute("result", orbit.getMessage());
        modelMap.addAttribute("result1", orbit.getVelocity());
        modelMap.addAttribute("result2", orbit.getWay());
        return "new";
    }


    @GetMapping(value = "/g")
    public String get(Model modelMap) {
        ServiceOrbit service = new ServiceOrbit();
        Orbit orbit = service.find(4);
        modelMap.addAttribute("weight", orbit.getPlanet().getWeight());
        modelMap.addAttribute("weight", orbit.getPlanet().getWeight());
        modelMap.addAttribute("radius", orbit.getPlanet().getRadius());
        modelMap.addAttribute("planet_name", orbit.getPlanet().getName());
        modelMap.addAttribute("satellite_name", orbit.getSatellite().getName());
        modelMap.addAttribute("velocity", orbit.getSatellite().getVelocity());
        modelMap.addAttribute("height", orbit.getHeight());
        modelMap.addAttribute("acceleration", orbit.getAcceleration());
        modelMap.addAttribute("time", orbit.getTime());
        modelMap.addAttribute("result", orbit.getMessage());
        modelMap.addAttribute("result1", orbit.getVelocity());
        modelMap.addAttribute("result2", orbit.getWay());
        return "new";
    }
}