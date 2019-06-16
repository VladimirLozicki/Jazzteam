package model.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import model.orbita.Orbit;

import model.planet.Planet;
import model.planet.Satellite;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.ServiceOrbit;
import services.ServicePlanet;

import java.util.List;


@Controller
public class OrbitController {
    @GetMapping(value = "/")
    public String index() {
        return "/index";
    }

    @GetMapping(value = "planet")
    public ModelAndView orbit() {
        return new ModelAndView("planet", "command", new Orbit());
    }


    @PostMapping(value = "/addOrbit")
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

//    @PostMapping (value = "/save")
//    public ModelAndView step(@ModelAttribute("satellite") Orbit orbit,  ModelMap model)	{
//        model.addAttribute("weight", orbit.getPlanet().getWeight()); //извлекаю основного юзера из сессии
//        ServiceOrbit s = new ServiceOrbit();
//        s.savePlanet(String.valueOf()orbit.getVelocity());    // обновляю его в бд  !!!! не обновляется и ошибки в логи тоже не сыпятся !!!!
//       // httpSession.setAttribute("myUser", myUser);   // снова записываю его в сессию, точнее его обновленную версию
//        return new ModelAndView("step3", "satellite", new Orbit()); //отправляю нового юзера для данных из 3го этапа
//    }
}