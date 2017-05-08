package com.ucbcba.taller.controllers;

import com.ucbcba.taller.entities.Company;
import com.ucbcba.taller.services.CompanyService;
import com.ucbcba.taller.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CompanyController {

    private CompanyService companyService;
    private UserService userService;

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Autowired
    public void setUserService(UserService userService) { this.userService = userService; }

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public String list(Model model) {
        model. addAttribute("companies", companyService.listAllCompanies());
        return "companies";
    }

    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public String showCompany(@PathVariable Integer id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));
        return "company";
    }

    @RequestMapping(value = "/company/delete/{id}", method = RequestMethod.GET)
    public String deleteCompany(@PathVariable Integer id) {
        companyService.deleteCompany(id);
        return "redirect:/companies";
    }

    @RequestMapping(value = "/company/new", method = RequestMethod.GET)
    public String newCompany(Model model) {
        model.addAttribute("company", new Company());
        model.addAttribute("users", userService.listAllUsers());
        return "companyForm";
    }

    @RequestMapping(value = "/company/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));
        model.addAttribute("users", userService.listAllUsers());
        return "companyForm";
    }

    @RequestMapping(value = "company", method = RequestMethod.POST)
    public String saveCompany(Company company) {
        companyService.saveCompany(company);
        return "redirect:/company/" + company.getId();
    }

}