package org.academiadecodigo.javabank.dto;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;

public class Converter {

    @Autowired
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer CustomerDtoToCustomer(CustomerDTO customerDTO) {

        Customer customer = null;

        if(customerDTO.getId() != null){
            customer = customerDao.findById(customerDTO.getId());
        }
        else {
            customer = new Customer();
        }

        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());

        return customer;
    }

    public CustomerDTO CustomerToCustomerDto(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getFirstName(),
                customer.getLastName(), customer.getPhone(), customer.getEmail());
    }
}
