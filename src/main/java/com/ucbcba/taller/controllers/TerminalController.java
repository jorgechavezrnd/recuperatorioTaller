package com.ucbcba.taller.controllers;

import com.ucbcba.taller.entities.Terminal;
import com.ucbcba.taller.entities.Location;
import com.ucbcba.taller.entities.TerminalHistory;
import com.ucbcba.taller.services.CategoryService;
import com.ucbcba.taller.services.TerminalHistoryService;
import com.ucbcba.taller.services.UserService;
import com.ucbcba.taller.services.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TerminalController {

    private TerminalService terminalService;
    private CategoryService categoryService;
    private UserService userService;
    private TerminalHistoryService terminalHistoryService;

    @Autowired
    public void setTerminalService(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setUserService(UserService userService) { this.userService = userService; }

    @Autowired
    public void setTerminalHistoryService(TerminalHistoryService terminalHistoryService) {
        this.terminalHistoryService = terminalHistoryService;
    }

    @RequestMapping(value = "/terminals", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("terminals", terminalService.listAllTerminals());
        return "terminals";
    }

    @RequestMapping(value = "/terminal/{id}", method = RequestMethod.GET)
    public String showTerminal(@PathVariable Integer id, Model model) {
        model.addAttribute("terminal", terminalService.getTerminalById(id));
        return "terminal";
    }

    @RequestMapping(value = "/terminal/delete/{id}", method = RequestMethod.GET)
    public String deleteTerminal(@PathVariable Integer id) {
        terminalService.deleteTerminal(id);
        return "redirect:/terminals";
    }

    @RequestMapping(value = "/terminal/new", method = RequestMethod.GET)
    public String newTerminal(Model model) {

        model.addAttribute("terminal", new Terminal());
        model.addAttribute("categories", categoryService.listAllCategories());
        model.addAttribute("users", userService.listAllUsers());
        return "terminalForm";
    }

    @RequestMapping(value = "/terminal/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("terminal", terminalService.getTerminalById(id));
        model.addAttribute("categories", categoryService.listAllCategories());
        model.addAttribute("users", userService.listAllUsers());
        return "terminalForm";
    }

    @RequestMapping(value = "terminal", method = RequestMethod.POST)
    public String saveTerminal(Terminal terminal) {
        terminalService.saveTerminal(terminal);
        //terminalHistoryService.saveTerminalHistory(new TerminalHistory(terminal));
        return "redirect:/terminal/" + terminal.getId();
    }

    @RequestMapping(value = "/terminal/drawlocations/{id}", method = RequestMethod.GET)
    public String drawMap(@PathVariable Integer id, Model model) {
        List<Double> latitudes = new ArrayList<>();
        List<Double> longitudes = new ArrayList<>();
        List<String> titulos = new ArrayList<>();

        for (Location l : terminalService.getTerminalById(id).getLocations()) {
            latitudes.add(l.getLat());
            longitudes.add(l.getIng());
            titulos.add(l.getTerminalSerial());
        }

        model.addAttribute("latitudes", latitudes);
        model.addAttribute("longitudes", longitudes);
        model.addAttribute("titulos", titulos);

        return "drawLocations";
    }

}
