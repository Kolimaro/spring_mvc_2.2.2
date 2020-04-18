package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarService;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(@RequestParam(value = "locale", required = false) String locale, ModelMap model) {
        List<Car> cars = carService.allCars();
        if (locale != null) {
            if (locale.equals("ru")) {
                model.addAttribute("locale", "МАШИНЫ");
            } else if (locale.equals("en")) {
                model.addAttribute("locale", "CARS");
            }
        }

        model.addAttribute("allCars", cars);

        return "cars";
    }
}
