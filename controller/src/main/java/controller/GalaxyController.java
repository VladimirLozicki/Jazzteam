package controller;


import com.google.gson.Gson;
import model.orbit.Galaxy;
import model.orbit.Orbit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    Galaxy galaxy;

    @PostMapping(value = "/galaxy")
    @ResponseBody
    public void add(@RequestBody String jsonObject) {
        Gson gson = new Gson();
        galaxy = gson.fromJson(jsonObject, Galaxy.class);
    }


    @GetMapping(value = "/result")
    public String add1(Model modelMap) {
        galaxy.run();
        modelMap.addAttribute("orbits", galaxy.getOrbit());
        modelMap.addAttribute("weight", galaxy.getMassiveAstronomicalObject().getWeight());
        modelMap.addAttribute("radius", galaxy.getMassiveAstronomicalObject().getRadius());
        modelMap.addAttribute("time", galaxy.getTime());
        return "result";
    }
}