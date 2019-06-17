package model.controller;

import javafx.print.PageLayout;
import model.orbit.Orbit;

import model.planet.Planet;
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

    @GetMapping(value = "/planet")
    public ModelAndView orbit() {
        return new ModelAndView("planet", "command", new Orbit());
    }


    @PostMapping(value = "/addOrbit")
    public String addOrbit(@ModelAttribute("mvc-dispatcher") Orbit orbit,
                           ModelMap model) {

        model.addAttribute("weight", orbit.getPlanet().getWeight());
        model.addAttribute("radius", orbit.getPlanet().getRadius());
//        model.addAttribute("height", orbit.getHeight());
//        model.addAttribute("name", orbit.getSatellite().getName());
//        model.addAttribute("velocity", orbit.getSatellite().getVelocity());
//        model.addAttribute("acceleration", orbit.getAcceleration());
//        model.addAttribute("result", orbit.getMessage());
//        model.addAttribute("result1", orbit.getVelocity());
//        model.addAttribute("result2", orbit.getWay());
        return "result";
    }

    @PostMapping(value = "/save")
    public String saveOrbit(@ModelAttribute("mvc-dispatcher") Orbit orbit) {

        ServiceOrbit serviceOrbit = new ServiceOrbit();
        serviceOrbit.savePlanet(orbit);
        return "result";
    }
}