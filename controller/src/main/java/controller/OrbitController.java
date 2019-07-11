package controller;

import model.orbit.Orbit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.json.*;
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

        //setOrbit(model, orbit);
        // orbits.add(orbit);
        model.addAttribute("weight", orbit.getPlanet().getWeight());
        model.addAttribute("radius", orbit.getPlanet().getRadius());
        return "result";
    }


    @PostMapping(value = "/planet")
    public String add(@RequestParam(name = "data") String jsonObject, ModelMap modelMap) {
        JSONObject jsonObject1 = new JSONObject(jsonObject);
       // modelMap.addAttribute("weight", orbit.getPlanet().getWeight());
        return "result";
    }

    public void setOrbit(ModelMap model, Orbit orbit) {
        model.addAttribute("weight", orbit.getPlanet().getWeight());
        model.addAttribute("radius", orbit.getPlanet().getRadius());
        model.addAttribute("planet_name", orbit.getPlanet().getName());
        model.addAttribute("height", orbit.getHeight());
        model.addAttribute("acceleration", orbit.getAcceleration());
    }
}