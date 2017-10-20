package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, value = "/customer")
    public String showCustomers(Model model) {

        model.addAttribute("customers", customerService.findAll());

        return "customer";

    }
}
