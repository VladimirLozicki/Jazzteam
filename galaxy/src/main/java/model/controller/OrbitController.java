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
        model.addAttribute("weight", orbit.getPlanet().getWeight());
        model.addAttribute("radius", orbit.getPlanet().getRadius());
        model.addAttribute("planet_name", orbit.getPlanet().getName());
        model.addAttribute("satellite_name", orbit.getSatellite().getName());
        model.addAttribute("velocity", orbit.getSatellite().getVelocity());
        model.addAttribute("height", orbit.getHeight());
        model.addAttribute("acceleration", orbit.getAcceleration());
        model.addAttribute("result", orbit.getMessage());
        model.addAttribute("result1", orbit.getVelocity());
        model.addAttribute("result2", orbit.getWay());
        writeOrbit(orbit);
        return "result";
    }

    public void writeOrbit(Orbit orbit) {
        ServiceOrbit service = new ServiceOrbit();
        service.save(orbit);
    }

    @PostMapping(value = "/save")
    public String getOrbit(@ModelAttribute("command") Orbit orbit, ModelMap modelMap) {
        ServiceOrbit service = new ServiceOrbit();
        orbit= service.findUser(1);
        modelMap.addAttribute("weight", orbit.getPlanet().getWeight());
        modelMap.addAttribute("radius", orbit.getPlanet().getRadius());
        modelMap.addAttribute("planet_name", orbit.getPlanet().getName());
        modelMap.addAttribute("height", orbit.getHeight());
        modelMap.addAttribute("acceleration", orbit.getAcceleration());
        modelMap.addAttribute("result", orbit.getMessage());
        return "new";
    }

}