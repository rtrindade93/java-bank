package org.academiadecodigo.javabank.controller.rest;

import org.academiadecodigo.javabank.command.CustomerForm;
import org.academiadecodigo.javabank.converters.CustomerFormToCustomer;
import org.academiadecodigo.javabank.converters.CustomerToCustomerForm;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerControllerREST {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerFormToCustomer customerFormToCustomer;

    @Autowired
    private CustomerToCustomerForm customerToCustomerForm;

    @RequestMapping(method = RequestMethod.GET, path = "/customer/{id}")
    public ResponseEntity<CustomerForm> showCustomer(@PathVariable Integer id) {

        Customer customer = customerService.get(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerToCustomerForm.convert(customer), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/customer")
    public ResponseEntity<List<CustomerForm>> showCustomers() {

        List<Customer> listCustomer = customerService.list();

        if (listCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<CustomerForm> listCustomerForm = new ArrayList<>();

        for(Customer customer : listCustomer){
            listCustomerForm.add(customerToCustomerForm.convert(customer));
        }

        return new ResponseEntity<>(listCustomerForm, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customer")
    public ResponseEntity addCustomer(@Valid @RequestBody CustomerForm customerForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer customer = customerService.save(customerFormToCustomer.convert(customerForm));

        return new ResponseEntity<>(customerToCustomerForm.convert(customer), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customer/{id}")
    public ResponseEntity editCustomer(@Valid @RequestBody CustomerForm customerForm, BindingResult bindingResult,
                                       @PathVariable Integer id) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (customerForm.getId() != id) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Customer customer = customerService.save(customerFormToCustomer.convert(customerForm));

        return new ResponseEntity<>(customerToCustomerForm.convert(customer), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customer/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {

        Customer customer = customerService.get(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
