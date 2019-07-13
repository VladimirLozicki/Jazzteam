package controller;

import model.orbit.Orbit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GalaxyController {
    @GetMapping(value = "/")
    public String index() {
        return "/index";
    }


    @GetMapping(value = "/galaxy")
    public ModelAndView orbit() {
        return new ModelAndView("galaxy", "command", new Orbit());
    }


    @PostMapping(value = "/galaxy")
    @ResponseBody
    public String add(@RequestBody String jsonObject, ModelMap modelMap) {
       return "1";
   }

    public void setOrbit(ModelMap model, Orbit orbit) {
        model.addAttribute("weight", orbit.getPlanet().getWeight());
        model.addAttribute("radius", orbit.getPlanet().getRadius());
        model.addAttribute("planet_name", orbit.getPlanet().getName());
        model.addAttribute("height", orbit.getHeight());
        model.addAttribute("acceleration", orbit.getAcceleration());
    }
}