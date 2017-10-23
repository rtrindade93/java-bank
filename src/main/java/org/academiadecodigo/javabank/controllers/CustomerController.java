package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(method = RequestMethod.GET, path = "/customer/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {

        customerService.delete(id);

        return "redirect:/customer";

    }

    @RequestMapping(method = RequestMethod.GET, path = "/customer/show/{id}")
    public String showCustomer(@PathVariable Integer id, Model model) {

        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("accounts", customerService.findById(id).getAccounts());

        return "customerInfo";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/customer/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {

        model.addAttribute("customer", customerService.findById(id));

        return "customerEditAdd";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/customer/add")
    public String addCustomer(Model model) {

        model.addAttribute("customer", new Customer());

        return "customerEditAdd";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customer/persist")
    public String persistCustomer(@ModelAttribute Customer customer) {

        customerService.add(customer);

        return "redirect:/customer/";
    }
}
