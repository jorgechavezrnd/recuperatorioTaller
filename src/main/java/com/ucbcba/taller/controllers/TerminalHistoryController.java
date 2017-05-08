package com.ucbcba.taller.controllers;

import com.ucbcba.taller.services.TerminalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TerminalHistoryController {

    private TerminalHistoryService terminalHistoryService;

    @Autowired
    public void setTerminalHistoryService(TerminalHistoryService terminalHistoryService) {
        this.terminalHistoryService = terminalHistoryService;
    }

    @RequestMapping(value = "/terminalHistories", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute(terminalHistoryService.listAllTerminalHystories());
        return "terminalHistories";
    }

}
