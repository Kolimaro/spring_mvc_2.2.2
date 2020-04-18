package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.RequestPartServletServerHttpRequest;
import web.DAO.CarDao;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarDao carDao;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(@RequestParam(value = "locale", required = false) String locale, ModelMap model) {
        List<Car> cars = carDao.allCars();
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
