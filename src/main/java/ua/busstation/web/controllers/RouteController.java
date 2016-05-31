package ua.busstation.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.busstation.BusStation;
import ua.busstation.core.bus.Bus;
import ua.busstation.core.bus.BusManager;
import ua.busstation.core.reckoning.Reckoning;
import ua.busstation.core.route.RouteManager;

import java.sql.Date;

@Controller
@RequestMapping("/index")
public class RouteController {

    private BusStation busStation;

    @Autowired
    private RouteManager routeManager;
    @Autowired
    private BusManager busManager;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listRoutes(Model model) {
        busStation = new BusStation();

        model.addAttribute("routes", routeManager.allRouts());
        return "index";
    }

    @RequestMapping(value = "/chooseBus", method = RequestMethod.POST)
    public String chooseBus(@RequestParam("routeName") String routeName, @RequestParam("date") Date date,
                            Model model) {
        this.busStation.setSelectedRoute(routeManager.findByName(routeName));
        if (this.busStation.checkTime(date)) {
            this.busStation.setDateForAllBuses();
            this.busStation.checkAndAddingRouteAndDateOrReturnExisting();

            model.addAttribute("buses", this.busStation.getSelectedRoute().getBuses());
            model.addAttribute("date", this.busStation.getSelectedDate());
            return "buses";

        } else {
            model.addAttribute("date", date);
            return "errorPageWrongDate";
        }
    }

    @RequestMapping(value = "/reckoning", method = RequestMethod.POST)
    public String getReckoning(@RequestParam("busNumber") String busNumber, Model model) {
        Bus bus = this.busStation.getSelectedRoute().getBusByNumber(busNumber);
        if (bus.getSeats() != 0) {
            Reckoning reckoning = new Reckoning(bus,
                    this.busStation.getSelectedRoute());

            model.addAttribute("reckoning", reckoning);

            return "reckoning";
        } else {
            return "errorPageNoSeats";
        }
    }

}