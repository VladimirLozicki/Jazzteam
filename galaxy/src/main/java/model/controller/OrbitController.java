package model.controller;
import model.orbit.Orbit;

import model.planet.Planet;
import model.planet.Satellite;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import services.ServiceOrbit;
import services.ServicePlanet;
import services.ServiceSattelite;


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
        write(orbit.getPlanet());
        model.addAttribute("satellite_name", orbit.getSatellite().getName());
        model.addAttribute("velocity", orbit.getSatellite().getVelocity());
        writeSatellite(orbit.getSatellite());

        model.addAttribute("height", orbit.getHeight());
        model.addAttribute("acceleration", orbit.getAcceleration());

        model.addAttribute("result", orbit.getMessage());
        model.addAttribute("result1", orbit.getVelocity());
        model.addAttribute("result2", orbit.getWay());
       // writeOrbit(orbit);
        return "result";
    }

    public void write(Planet orbit){

        ServicePlanet serviceOrbit = new ServicePlanet();

        serviceOrbit.savePlanet(orbit);
    }

    public void writeSatellite(Satellite satellite){

        ServiceSattelite serviceSattelite = new ServiceSattelite();

        serviceSattelite.saveSattelite(satellite);
    }

    public void writeOrbit(Orbit orbit){

        ServiceOrbit serviceSattelite = new ServiceOrbit();

        serviceSattelite.savePlanet(orbit);
    }


//    @PostMapping(value = "/save")
//    public String saveOrbit(@ModelAttribute("weight") Orbit orbit,  ModelMap model)  {
//        model.get("weight");
//        ServiceOrbit serviceOrbit = new ServiceOrbit();
//
//        serviceOrbit.savePlanet(model);
//        return "result";
//    }
}