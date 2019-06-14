package model.controller;

import model.orbita.Orbit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrbitController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "planet", method = RequestMethod.GET)
    public ModelAndView orbit() {
        return new ModelAndView("planet", "command", new Orbit());
    }


    @RequestMapping(value = "/addOrbit", method = RequestMethod.POST)
    public String addOrbit(@ModelAttribute("mvc-dispatcher") Orbit orbit,
                           ModelMap model) {
        model.addAttribute("weight", orbit.getPlanet().getWeight());
        model.addAttribute("radius", orbit.getPlanet().getRadius());
        model.addAttribute("height", orbit.getHeight());
        model.addAttribute("velocity", orbit.getSatellite().getVelocity());
        model.addAttribute("acceleration", orbit.getAcceleration());
        model.addAttribute("result", orbit.getMessage());
        model.addAttribute("result1", orbit.getVelocity());
        model.addAttribute("result2", orbit.getWay());
        return "result";
    }
}