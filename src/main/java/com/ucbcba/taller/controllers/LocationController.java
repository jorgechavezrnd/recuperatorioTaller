package com.ucbcba.taller.controllers;

import com.ucbcba.taller.entities.Location;
import com.ucbcba.taller.services.TerminalService;
import com.ucbcba.taller.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LocationController {

    private LocationService locationService;
    private TerminalService terminalService;

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @Autowired
    public void setTerminalService(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("locations", locationService.listAllLocations());
        return "locations";
    }

    @RequestMapping(value = "/location/{id}", method = RequestMethod.GET)
    public String showLocation(@PathVariable Integer id, Model model) {
        model.addAttribute("location", locationService.getLocationById(id));
        return "location";
    }

    @RequestMapping(value = "/location/delete/{id}", method = RequestMethod.GET)
    public String deleteLocation(@PathVariable Integer id) {
        locationService.deleteLocation(id);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/location/new", method = RequestMethod.GET)
    public String newLocation(Model model) {
        model.addAttribute("location", new Location());
        model.addAttribute("terminals", terminalService.listAllTerminals());
        return "locationForm";
    }

    @RequestMapping("location/edit/{id}") // DUDA: " porque aqui no se pone "value"? "
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("location", locationService.getLocationById(id));
        model.addAttribute("terminals", terminalService.listAllTerminals());
        return "locationForm";
    }

    @RequestMapping(value = "location", method = RequestMethod.POST)
    public String saveLocation(Location location) {
        locationService.saveLocation(location);
        return "redirect:/location/" + location.getId();
    }

    @RequestMapping(value = "/location/like/{id}", method = RequestMethod.GET)
    public String likeLocation(@PathVariable Integer id, HttpServletRequest request) {
        Location location = locationService.getLocationById(id);
        location.setLikes(location.getLikes() + 1);
        locationService.saveLocation(location);

        String referrer = request.getHeader("referer");

        return "redirect:" + referrer;
    }

    @RequestMapping(value = "/location/drawmap/{id}", method = RequestMethod.GET)
    public String drawMap(@PathVariable Integer id, Model model) {
        Location loc = locationService.getLocationById(id);
        model.addAttribute("latitud", loc.getLat());
        model.addAttribute("longitud", loc.getIng());
        model.addAttribute("titulo", loc.getTerminalSerial());
        model.addAttribute("location", locationService.getLocationById(id));

        return "drawMap";
    }

}