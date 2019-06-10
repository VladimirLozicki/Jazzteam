package model.controller;

import model.planet.Planet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlanetController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }
    @RequestMapping(value = "planet", method = RequestMethod.GET)
    public ModelAndView planet() {
        return new ModelAndView("planet", "command", new Planet());
    }
    @RequestMapping(value = "/addPlanet", method = RequestMethod.POST)
    public String addPlanet(@ModelAttribute("mvc-dispatcher") Planet planet,
                             ModelMap model) {
        model.addAttribute("density", planet.getDensity());
        model.addAttribute("rotationPeriod", planet.getRotationPeriod());
        model.addAttribute("secondCosmicVelocity", planet.getSecondCosmicVelocity());
        model.addAttribute("name", planet.getName());
        return "result";
    }
}
